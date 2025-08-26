package br.com.truco.model.deck;

public class Carta {
    private final int id;
    private final int numero;
    private final Naipe naipe;

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
    
    public String getNomeCarta() {
        String nome = "";
        switch (numero) {
            case 1: nome = "Ás"; break;
            case 2: nome = "2"; break;
            case 3: nome = "3"; break;
            case 4: nome = "4"; break;
            case 5: nome = "5"; break;
            case 6: nome = "6"; break;
            case 7: nome = "7"; break;
            case 10: nome = "10"; break;
            case 11: nome = "Valete"; break;
            case 12: nome = "Dama"; break;
            case 13: nome = "Rei"; break;
        }
        return nome + " de " + naipe.toString();
    }
    
    public int getValorTruco() {
        // Valores das cartas no Truco
        switch (numero) {
            case 1: return 14; // Ás é a mais alta
            case 2: return 13;
            case 3: return 12;
            case 4: return 11;
            case 5: return 10;
            case 6: return 9;
            case 7: return 8;
            case 10: return 7;
            case 11: return 6;
            case 12: return 5;
            case 13: return 4;
            default: return 0;
        }
    }
    
    @Override
    public String toString() {
        return getNomeCarta();
    }
}