package br.com.truco.service;

import br.com.truco.model.Equipe;
import br.com.truco.model.Jogador;
import br.com.truco.model.Partida;
import br.com.truco.model.Rodada;
import java.util.List;

public class Resultados {
    
    public static void mostrarResultadoRodada(Rodada rodada) {
        if (rodada.getVencedor() != null) {
            System.out.println("Vencedor da rodada: " + rodada.getVencedor().getNome());
            System.out.println("Valor da rodada: " + rodada.getValor());
        }
    }
    
    public static void mostrarPlacar(Partida partida) {
        System.out.println("\n=== PLACAR ===");
        System.out.println(partida.getEquipe1().getNome() + ": " + partida.getPontuacaoEquipe1() + " pontos");
        System.out.println(partida.getEquipe2().getNome() + ": " + partida.getPontuacaoEquipe2() + " pontos");
        System.out.println("==============\n");
    }
    
    public static void mostrarVencedorPartida(Partida partida) {
        if (partida.isFinalizada() && partida.getVencedores() != null) {
            System.out.println("\n🎉 PARABÉNS! 🎉");
            System.out.println("Vencedores: " + partida.getVencedores().getNome());
            System.out.println("Placar final: " + partida.getEquipe1().getNome() + " " + 
                             partida.getPontuacaoEquipe1() + " x " + 
                             partida.getPontuacaoEquipe2() + " " + partida.getEquipe2().getNome());
        }
    }
    
    public static void mostrarEstatisticasJogador(Jogador jogador, Partida partida) {
        System.out.println("\n=== ESTATÍSTICAS DO JOGADOR ===");
        System.out.println("Nome: " + jogador.getNome());
        System.out.println("Equipe: " + (partida.getEquipe1().temJogador(jogador) ? 
                                       partida.getEquipe1().getNome() : partida.getEquipe2().getNome()));
        System.out.println("Cartas na mão: " + (jogador.getMao() != null ? 
                                               jogador.getMao().getQuantidadeCartas() : 0));
        System.out.println("==============================\n");
    }
    
    public static void mostrarHistoricoRodadas(Partida partida) {
        System.out.println("\n=== HISTÓRICO DE RODADAS ===");
        List<Rodada> rodadas = partida.getRodadas();
        
        if (rodadas.isEmpty()) {
            System.out.println("Nenhuma rodada jogada ainda.");
        } else {
            for (int i = 0; i < rodadas.size(); i++) {
                Rodada rodada = rodadas.get(i);
                System.out.println((i + 1) + ". " + rodada.toString());
            }
        }
        System.out.println("============================\n");
    }
    
    public static boolean verificarEmpate(Partida partida) {
        return partida.getPontuacaoEquipe1() == partida.getPontuacaoEquipe2() && 
               partida.getPontuacaoEquipe1() >= 11;
    }
    
    public static void mostrarEmpate(Partida partida) {
        if (verificarEmpate(partida)) {
            System.out.println("\n⚖️ EMPATE! ⚖️");
            System.out.println("Ambas as equipes têm " + partida.getPontuacaoEquipe1() + " pontos!");
            System.out.println("A partida continuará até que uma equipe vença por 2 pontos de diferença.");
        }
    }
}
