package br.com.truco.service;

import br.com.truco.model.*;
import br.com.truco.model.deck.*;
import java.util.*;

public class RegrasTruco {
    
    public static final int VALOR_MANILHA_4_PAUS = 14;
    public static final int VALOR_MANILHA_7_COPAS = 13;
    public static final int VALOR_MANILHA_AS_ESPADAS = 12;
    public static final int VALOR_MANILHA_7_OUROS = 11;
    
    public static final int VALOR_AS = 10;
    public static final int VALOR_2 = 9;
    public static final int VALOR_3 = 8;
    public static final int VALOR_4 = 7;
    public static final int VALOR_5 = 6;
    public static final int VALOR_6 = 5;
    public static final int VALOR_7 = 4;
    public static final int VALOR_10 = 3;
    public static final int VALOR_VALETE = 2;
    public static final int VALOR_DAMA = 1;
    public static final int VALOR_REI = 0;
    
    public static int getValorCarta(Carta carta) {
        if (isManilha(carta)) {
            return getValorManilha(carta);
        }
        switch (carta.getNumero()) {
            case 1: return VALOR_AS;
            case 2: return VALOR_2;
            case 3: return VALOR_3;
            case 4: return VALOR_4;
            case 5: return VALOR_5;
            case 6: return VALOR_6;
            case 7: return VALOR_7;
            case 10: return VALOR_10;
            case 11: return VALOR_VALETE;
            case 12: return VALOR_DAMA;
            case 13: return VALOR_REI;
            default: return 0;
        }
    }
    
    public static boolean isManilha(Carta carta) {
        return (carta.getNumero() == 4 && carta.getNaipe() == Naipe.PAUS) ||
               (carta.getNumero() == 7 && carta.getNaipe() == Naipe.COPAS) ||
               (carta.getNumero() == 1 && carta.getNaipe() == Naipe.ESPADAS) ||
               (carta.getNumero() == 7 && carta.getNaipe() == Naipe.OUROS);
    }
    
    private static int getValorManilha(Carta carta) {
        if (carta.getNumero() == 4 && carta.getNaipe() == Naipe.PAUS) {
            return VALOR_MANILHA_4_PAUS;
        } else if (carta.getNumero() == 7 && carta.getNaipe() == Naipe.COPAS) {
            return VALOR_MANILHA_7_COPAS;
        } else if (carta.getNumero() == 1 && carta.getNaipe() == Naipe.ESPADAS) {
            return VALOR_MANILHA_AS_ESPADAS;
        } else if (carta.getNumero() == 7 && carta.getNaipe() == Naipe.OUROS) {
            return VALOR_MANILHA_7_OUROS;
        }
        return 0;
    }
    
    public static int compararCartas(Carta carta1, Carta carta2) {
        int valor1 = getValorCarta(carta1);
        int valor2 = getValorCarta(carta2);
        
        if (valor1 > valor2) {
            return 1;
        } else if (valor1 < valor2) {
            return -1;
        } else {
            return 0;
        }
    }
    
    public static Jogador determinarVencedorRodada(List<Carta> cartasJogadas, List<Jogador> jogadores) {
        if (cartasJogadas.size() < 2) {
            return null;
        }
        
        Carta carta1 = cartasJogadas.get(0);
        Carta carta2 = cartasJogadas.get(1);
        
        int resultado = compararCartas(carta1, carta2);
        
        if (resultado > 0) {
            return jogadores.get(0);
        } else if (resultado < 0) {
            return jogadores.get(1);
        } else {
            return jogadores.get(0);
        }
    }
    
    public static boolean podePedirTruco(Equipe equipe, int valorAtual) {
        return valorAtual < 12;
    }
    
    public static int getProximoValorTruco(int valorAtual) {
        switch (valorAtual) {
            case 1: return 3;
            case 3: return 6;
            case 6: return 9;
            case 9: return 12;
            default: return valorAtual;
        }
    }
    
    public static boolean partidaTerminada(Partida partida) {
        return partida.getPontuacaoEquipe1() >= 12 || partida.getPontuacaoEquipe2() >= 12;
    }
    
    public static Equipe getVencedorPartida(Partida partida) {
        if (partida.getPontuacaoEquipe1() >= 12) {
            return partida.getEquipe1();
        } else if (partida.getPontuacaoEquipe2() >= 12) {
            return partida.getEquipe2();
        }
        return null;
    }
    
    public static int calcularPontuacaoMao(List<Carta> cartas) {
        int pontuacao = 0;
        for (Carta carta : cartas) {
            pontuacao += getValorCarta(carta);
        }
        return pontuacao;
    }
    
    public static boolean temTruco(List<Carta> cartas) {
        if (cartas.size() != 3) return false;
        
        Naipe naipe1 = cartas.get(0).getNaipe();
        Naipe naipe2 = cartas.get(1).getNaipe();
        Naipe naipe3 = cartas.get(2).getNaipe();
        
        return naipe1 == naipe2 && naipe2 == naipe3;
    }
    
    public static boolean temFlor(List<Carta> cartas) {
        return temTruco(cartas);
    }
    
    public static int calcularPontuacaoFlor(List<Carta> cartas) {
        if (!temFlor(cartas)) return 0;
        
        int pontuacao = 20;
        pontuacao += calcularPontuacaoMao(cartas);
        return pontuacao;
    }
}
