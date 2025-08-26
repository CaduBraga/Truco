package br.com.truco.model;

import br.com.truco.model.deck.Carta;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class Rodada {
    private int id;
    private Partida partida;
    private Jogador vencedor;
    private int valor;
    private Timestamp inicio;
    private List<Carta> cartasJogadas;
    private Jogador jogadorAtual;

    public Rodada(int id, Partida partida, int valor) {
        this.id = id;
        this.partida = partida;
        this.valor = valor;
        this.cartasJogadas = new ArrayList<>();
        this.inicio = new Timestamp(System.currentTimeMillis());
    }

    public int getId() {
        return id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    
    public Partida getPartida() {
        return partida;
    }
    
    public void setPartida(Partida partida) {
        this.partida = partida;
    }
    
    public Jogador getVencedor() {
        return vencedor;
    }
    
    public void setVencedor(Jogador vencedor) {
        this.vencedor = vencedor;
    }
    
    public int getValor() {
        return valor;
    }
    
    public void setValor(int valor) {
        this.valor = valor;
    }
    
    public Timestamp getInicio() {
        return inicio;
    }
    
    public void setInicio(Timestamp inicio) {
        this.inicio = inicio;
    }

    public List<Carta> getCartasJogadas() {
        return cartasJogadas;
    }

    public void adicionarCartaJogada(Carta carta) {
        this.cartasJogadas.add(carta);
    }

    public Jogador getJogadorAtual() {
        return jogadorAtual;
    }

    public void setJogadorAtual(Jogador jogadorAtual) {
        this.jogadorAtual = jogadorAtual;
    }

    public boolean isCompleta() {
        return cartasJogadas.size() >= 4; // 4 cartas = 2 jogadores x 2 cartas cada
    }

    public void determinarVencedor() {
        if (cartasJogadas.size() >= 4) {
            // Lógica simples: primeira carta jogada vence
            // Em um jogo real, seria mais complexo
            this.vencedor = this.jogadorAtual;
        }
    }

    @Override
    public String toString() {
        return "Rodada " + id + " - Valor: " + valor + " - Vencedor: " + 
               (vencedor != null ? vencedor.getNome() : "Não definido");
    }
}