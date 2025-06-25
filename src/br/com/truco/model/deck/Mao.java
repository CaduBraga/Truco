package br.com.truco.model.deck;

public class Mao {
    Carta carta1;
    Carta carta2;
    Carta carta3;

    public Mao (Carta carta1, Carta carta2, Carta carta3) {
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
}
