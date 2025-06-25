package br.com.truco.model.deck;

public class Carta {
final int id;
final int numero;
final Naipe naipe;

    public Carta(int id, int numero, Naipe naipe) {
        this.id = id;
        this.numero = numero;
        this.naipe = naipe;
    }

    public int getId() {
        return id;
    }
    public int getNumero() {
        return numero;
    }
    public Naipe getNaipe() {
        return naipe;
    }
}