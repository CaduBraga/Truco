package br.com.truco.model.deck;

import java.util.ArrayList;
import java.util.List;

public class Mao {
    private Carta carta1;
    private Carta carta2;
    private Carta carta3;

    public Mao(Carta carta1, Carta carta2, Carta carta3) {
        this.carta1 = carta1;
        this.carta2 = carta2;
        this.carta3 = carta3;
    }

    public Carta getCarta1() {
        return carta1;
    }
    
    public void setCarta1(Carta carta1) {
        this.carta1 = carta1;
    }
    
    public Carta getCarta2() {
        return carta2;
    }
    
    public void setCarta2(Carta carta2) {
        this.carta2 = carta2;
    }
    
    public Carta getCarta3() {
        return carta3;
    }
    
    public void setCarta3(Carta carta3) {
        this.carta3 = carta3;
    }
    
    public List<Carta> getCartas() {
        List<Carta> cartas = new ArrayList<>();
        if (carta1 != null) cartas.add(carta1);
        if (carta2 != null) cartas.add(carta2);
        if (carta3 != null) cartas.add(carta3);
        return cartas;
    }
    
    public void removerCarta(Carta carta) {
        if (carta1 != null && carta1.getId() == carta.getId()) {
            carta1 = null;
        } else if (carta2 != null && carta2.getId() == carta.getId()) {
            carta2 = null;
        } else if (carta3 != null && carta3.getId() == carta.getId()) {
            carta3 = null;
        }
    }
    
    public boolean temCarta(Carta carta) {
        return (carta1 != null && carta1.getId() == carta.getId()) ||
               (carta2 != null && carta2.getId() == carta.getId()) ||
               (carta3 != null && carta3.getId() == carta.getId());
    }
    
    public int getQuantidadeCartas() {
        int count = 0;
        if (carta1 != null) count++;
        if (carta2 != null) count++;
        if (carta3 != null) count++;
        return count;
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (carta1 != null) sb.append(carta1.toString()).append(" ");
        if (carta2 != null) sb.append(carta2.toString()).append(" ");
        if (carta3 != null) sb.append(carta3.toString());
        return sb.toString().trim();
    }
}
