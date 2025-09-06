package br.com.truco.service;

import br.com.truco.model.*;
import br.com.truco.model.deck.*;
import br.com.truco.database.dao.ConexaoDAO;
import java.util.*;

public class GerenciadorJogo {
    private Partida partida;
    private List<Carta> baralho;
    private List<Jogador> ordemJogadores;
    private int jogadorAtualIndex;
    private List<Carta> cartasJogadas;
    private int valorRodada;
    private boolean trucoPendente;
    private Jogador quemPediuTruco;
    private List<Rodada> rodadas;
    private ConexaoDAO conexaoDAO;
    
    public GerenciadorJogo(Partida partida) {
        this.partida = partida;
        this.rodadas = new ArrayList<>();
        this.cartasJogadas = new ArrayList<>();
        this.valorRodada = 1;
        this.trucoPendente = false;
        this.quemPediuTruco = null;
        
        // Definir ordem dos jogadores
        this.ordemJogadores = new ArrayList<>();
        this.ordemJogadores.add(partida.getEquipe1().getJogador1());
        this.ordemJogadores.add(partida.getEquipe2().getJogador1());
        this.ordemJogadores.add(partida.getEquipe1().getJogador2());
        this.ordemJogadores.add(partida.getEquipe2().getJogador2());
        
        this.jogadorAtualIndex = 0;
        this.conexaoDAO = new ConexaoDAO();
        
        partida.setInicio(new java.sql.Timestamp(System.currentTimeMillis()));
        partida.setAtualizada(new java.sql.Timestamp(System.currentTimeMillis()));
        conexaoDAO.salvarPartida(partida);
    }
    
    public void iniciarNovaRodada() {
        this.baralho = Embaralhar.criarBaralho();
        Embaralhar.embaralharBaralho(baralho);
        
        this.cartasJogadas.clear();
        
        distribuirCartas();
        
        Rodada rodada = new Rodada(rodadas.size() + 1, partida, valorRodada);
        rodadas.add(rodada);
        
        this.trucoPendente = false;
        this.quemPediuTruco = null;
    }
    
    private void distribuirCartas() {
        for (Jogador jogador : ordemJogadores) {
            List<Carta> cartas = Embaralhar.pegarCartasDoTopo(baralho, 3);
            jogador.receberCartas(cartas.get(0), cartas.get(1), cartas.get(2));
        }
    }
    
    public boolean jogarCarta(Jogador jogador, Carta carta) {
        if (!isVezDoJogador(jogador)) {
            return false;
        }
        
        if (!jogador.temCartas() || !jogador.getMao().temCarta(carta)) {
            return false;
        }
        
        Carta cartaJogada = jogador.jogarCarta(carta);
        if (cartaJogada != null) {
            cartasJogadas.add(cartaJogada);
            
            if (!rodadas.isEmpty()) {
                rodadas.get(rodadas.size() - 1).adicionarCartaJogada(cartaJogada);
            }
            
            if (cartasJogadas.size() >= 4) {
                finalizarRodada();
            } else {
                proximoJogador();
            }
            
            return true;
        }
        
        return false;
    }
    
    public boolean isVezDoJogador(Jogador jogador) {
        return ordemJogadores.get(jogadorAtualIndex).equals(jogador);
    }
    
    public void proximoJogador() {
        jogadorAtualIndex = (jogadorAtualIndex + 1) % ordemJogadores.size();
    }
    
    private void finalizarRodada() {
        if (rodadas.isEmpty()) return;
        
        Rodada rodadaAtual = rodadas.get(rodadas.size() - 1);
        
        Jogador vencedor = RegrasTruco.determinarVencedorRodada(cartasJogadas, ordemJogadores);
        rodadaAtual.setVencedor(vencedor);
        
        if (partida.getEquipe1().temJogador(vencedor)) {
            partida.adicionarPontosEquipe1(valorRodada);
        } else {
            partida.adicionarPontosEquipe2(valorRodada);
        }
        
        conexaoDAO.salvarRodada(rodadaAtual);
        
        for (int i = 0; i < cartasJogadas.size(); i++) {
            Carta carta = cartasJogadas.get(i);
            Jogador jogador = ordemJogadores.get(i % ordemJogadores.size());
            conexaoDAO.salvarJogada(carta, jogador, rodadaAtual);
        }
        
        if (RegrasTruco.partidaTerminada(partida)) {
            partida.setFinalizada(true);
            partida.setVencedores(RegrasTruco.getVencedorPartida(partida));
        }
        
        partida.setAtualizada(new java.sql.Timestamp(System.currentTimeMillis()));
        conexaoDAO.atualizarPartida(partida);
    }
    
    public boolean pedirTruco(Jogador jogador) {
        if (trucoPendente) {
            return false;
        }
        
        if (!RegrasTruco.podePedirTruco(getEquipeDoJogador(jogador), valorRodada)) {
            return false;
        }
        
        this.trucoPendente = true;
        this.quemPediuTruco = jogador;
        
        return true;
    }
    
    public boolean aceitarTruco(Jogador jogador) {
        if (!trucoPendente) {
            return false;
        }
        
        this.valorRodada = RegrasTruco.getProximoValorTruco(valorRodada);
        this.trucoPendente = false;
        this.quemPediuTruco = null;
        
        return true;
    }
    
    public boolean recusarTruco(Jogador jogador) {
        if (!trucoPendente) {
            return false;
        }
        
        if (partida.getEquipe1().temJogador(quemPediuTruco)) {
            partida.adicionarPontosEquipe1(valorRodada);
        } else {
            partida.adicionarPontosEquipe2(valorRodada);
        }
        
        this.trucoPendente = false;
        this.quemPediuTruco = null;
        
        finalizarRodada();
        
        return true;
    }
    
    private Equipe getEquipeDoJogador(Jogador jogador) {
        if (partida.getEquipe1().temJogador(jogador)) {
            return partida.getEquipe1();
        } else {
            return partida.getEquipe2();
        }
    }
    
    public Jogador getJogadorAtual() {
        return ordemJogadores.get(jogadorAtualIndex);
    }
    
    public List<Carta> getCartasJogadas() {
        return new ArrayList<>(cartasJogadas);
    }
    
    public int getValorRodada() {
        return valorRodada;
    }
    
    public boolean isTrucoPendente() {
        return trucoPendente;
    }
    
    public Jogador getQuemPediuTruco() {
        return quemPediuTruco;
    }
    
    public Partida getPartida() {
        return partida;
    }
    
    public List<Rodada> getRodadas() {
        return new ArrayList<>(rodadas);
    }
    
    public boolean isPartidaTerminada() {
        return partida.isFinalizada();
    }
    
    public Equipe getVencedorPartida() {
        return partida.getVencedores();
    }
}
