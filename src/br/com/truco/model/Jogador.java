package br.com.truco.model;

import br.com.truco.model.deck.Carta;
import br.com.truco.model.deck.Mao;

public class Jogador {
    private int id;
    private String nome;
    private Mao mao;
    private boolean vez;

    public Jogador(int id, String nome) {
        this.id = id;
        this.nome = nome;
        this.mao = null;
        this.vez = false;
    }
    
    public int getId() {
        return id;
    }
    
    public String getNome() {
        return nome;
    }
    
    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    
    public Mao getMao() {
        return mao;
    }
    
    public void setMao(Mao mao) {
        this.mao = mao;
    }
    
    public boolean isVez() {
        return vez;
    }
    
    public void setVez(boolean vez) {
        this.vez = vez;
    }
    
    public void receberCartas(Carta carta1, Carta carta2, Carta carta3) {
        this.mao = new Mao(carta1, carta2, carta3);
    }
    
    public Carta jogarCarta(Carta carta) {
        if (mao != null && mao.temCarta(carta)) {
            mao.removerCarta(carta);
            return carta;
        }
        return null;
    }
    
    public boolean temCartas() {
        return mao != null && mao.getQuantidadeCartas() > 0;
    }
    
    @Override
    public String toString() {
        return nome;
    }
}