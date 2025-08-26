package br.com.truco.model.deck;

public enum Naipe {
    PAUS("♣"),
    COPAS("♥"),
    ESPADAS("♠"),
    OUROS("♦");
    
    private final String simbolo;
    
    Naipe(String simbolo) {
        this.simbolo = simbolo;
    }
    
    public String getSimbolo() {
        return simbolo;
    }
    
    @Override
    public String toString() {
        switch (this) {
            case PAUS: return "Paus";
            case COPAS: return "Copas";
            case ESPADAS: return "Espadas";
            case OUROS: return "Ouros";
            default: return name();
        }
    }
}