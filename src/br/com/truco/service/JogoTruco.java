package br.com.truco.service;

import br.com.truco.model.*;
import br.com.truco.model.deck.Carta;
import java.util.List;
import java.util.Scanner;
import java.sql.Timestamp;

public class JogoTruco {
    private Partida partida;
    private List<Carta> baralho;
    private Scanner scanner;
    
    public JogoTruco() {
        this.scanner = new Scanner(System.in);
        inicializarJogo();
    }
    
    private void inicializarJogo() {
        System.out.println("🎮 BEM-VINDO AO JOGO DE TRUCO! 🎮");
        System.out.println("=====================================");
        
        // Criar jogadores
        Jogador jogador1 = new Jogador(1, "João");
        Jogador jogador2 = new Jogador(2, "Maria");
        Jogador jogador3 = new Jogador(3, "Pedro");
        Jogador jogador4 = new Jogador(4, "Ana");
        
        // Criar equipes
        Equipe equipe1 = new Equipe(1, "Equipe A");
        equipe1.setJogador1(jogador1);
        equipe1.setJogador2(jogador2);
        
        Equipe equipe2 = new Equipe(2, "Equipe B");
        equipe2.setJogador1(jogador3);
        equipe2.setJogador2(jogador4);
        
        // Criar partida
        this.partida = new Partida(1, equipe1, equipe2);
        
        // Criar e embaralhar baralho
        this.baralho = br.com.truco.service.Embaralhar.criarBaralho();
        br.com.truco.service.Embaralhar.embaralharBaralho(baralho);
        
        System.out.println("Jogadores criados:");
        System.out.println(equipe1.getNome() + ": " + equipe1.getJogador1().getNome() + " e " + equipe1.getJogador2().getNome());
        System.out.println(equipe2.getNome() + ": " + equipe2.getJogador1().getNome() + " e " + equipe2.getJogador2().getNome());
        System.out.println();
        
        iniciarPartida();
    }
    
    private void iniciarPartida() {
        System.out.println("🚀 INICIANDO PARTIDA! 🚀");
        System.out.println("=========================");
        
        while (!partida.isFinalizada()) {
            jogarRodada();
            
            if (partida.getPontuacaoEquipe1() >= 12 || partida.getPontuacaoEquipe2() >= 12) {
                break;
            }
            
            System.out.println("\n" + "=".repeat(50));
            System.out.println("=== PLACAR ===");
            System.out.println(partida.getEquipe1().getNome() + ": " + partida.getPontuacaoEquipe1() + " pontos");
            System.out.println(partida.getEquipe2().getNome() + ": " + partida.getPontuacaoEquipe2() + " pontos");
            System.out.println("==============");
            System.out.println("=".repeat(50) + "\n");
        }
        
        finalizarPartida();
    }
    
    private void jogarRodada() {
        System.out.println("\n🃏 NOVA RODADA 🃏");
        System.out.println("------------------");
        
        // Distribuir cartas
        distribuirCartas();
        
        // Mostrar cartas dos jogadores
        mostrarCartasJogadores();
        
        // Simular jogo da rodada (versão simplificada)
        simularRodada();
        
        // Limpar mãos dos jogadores
        limparMaosJogadores();
    }
    
    private void distribuirCartas() {
        System.out.println("Distribuindo cartas...");
        
        // Distribuir 3 cartas para cada jogador
        List<Carta> cartasJogador1 = br.com.truco.service.Embaralhar.pegarCartasDoTopo(baralho, 3);
        List<Carta> cartasJogador2 = br.com.truco.service.Embaralhar.pegarCartasDoTopo(baralho, 3);
        List<Carta> cartasJogador3 = br.com.truco.service.Embaralhar.pegarCartasDoTopo(baralho, 3);
        List<Carta> cartasJogador4 = br.com.truco.service.Embaralhar.pegarCartasDoTopo(baralho, 3);
        
        partida.getEquipe1().getJogador1().receberCartas(cartasJogador1.get(0), cartasJogador1.get(1), cartasJogador1.get(2));
        partida.getEquipe1().getJogador2().receberCartas(cartasJogador2.get(0), cartasJogador2.get(1), cartasJogador2.get(2));
        partida.getEquipe2().getJogador1().receberCartas(cartasJogador3.get(0), cartasJogador3.get(1), cartasJogador3.get(2));
        partida.getEquipe2().getJogador2().receberCartas(cartasJogador4.get(0), cartasJogador4.get(1), cartasJogador4.get(2));
    }
    
    private void mostrarCartasJogadores() {
        System.out.println("\nCartas dos jogadores:");
        System.out.println(partida.getEquipe1().getJogador1().getNome() + ": " + partida.getEquipe1().getJogador1().getMao().getCartas());
        System.out.println(partida.getEquipe1().getJogador2().getNome() + ": " + partida.getEquipe1().getJogador2().getMao().getCartas());
        System.out.println(partida.getEquipe2().getJogador1().getNome() + ": " + partida.getEquipe2().getJogador1().getMao().getCartas());
        System.out.println(partida.getEquipe2().getJogador2().getNome() + ": " + partida.getEquipe2().getJogador2().getMao().getCartas());
    }
    
    private void simularRodada() {
        // Simulação simplificada - equipe 1 sempre vence por enquanto
        System.out.println("\n🎯 Simulando jogo da rodada...");
        
        // Determinar valor da rodada (1 ponto por padrão)
        int valorRodada = 1;
        
        // Criar rodada
        Rodada rodada = new Rodada(partida.getRodadas().size() + 1, partida, valorRodada);
        partida.adicionarRodada(rodada);
        
        // Simular vitória da equipe 1
        partida.setPontuacaoEquipe1(partida.getPontuacaoEquipe1() + valorRodada);
        
        System.out.println("🏆 " + partida.getEquipe1().getNome() + " venceu a rodada! (+" + valorRodada + " ponto)");
    }
    
    private void limparMaosJogadores() {
        partida.getEquipe1().getJogador1().setMao(null);
        partida.getEquipe1().getJogador2().setMao(null);
        partida.getEquipe2().getJogador1().setMao(null);
        partida.getEquipe2().getJogador2().setMao(null);
    }
    
    private void finalizarPartida() {
        System.out.println("\n🎉 PARTIDA FINALIZADA! 🎉");
        System.out.println("==========================");
        
        if (partida.getPontuacaoEquipe1() >= 12) {
            System.out.println("\n🎉 PARABÉNS! 🎉");
            System.out.println("Vencedores: " + partida.getEquipe1().getNome());
            System.out.println("Placar final: " + partida.getEquipe1().getNome() + " " + 
                             partida.getPontuacaoEquipe1() + " x " + 
                             partida.getPontuacaoEquipe2() + " " + partida.getEquipe2().getNome());
        } else if (partida.getPontuacaoEquipe2() >= 12) {
            System.out.println("\n🎉 PARABÉNS! 🎉");
            System.out.println("Vencedores: " + partida.getEquipe2().getNome());
            System.out.println("Placar final: " + partida.getEquipe1().getNome() + " " + 
                             partida.getPontuacaoEquipe1() + " x " + 
                             partida.getPontuacaoEquipe2() + " " + partida.getEquipe2().getNome());
        }
        
        System.out.println("\nObrigado por jogar Truco!");
        scanner.close();
    }
    
    public void executar() {
        // O jogo já inicia automaticamente no construtor
    }
}
