package br.com.truco.model;

public class Equipe {
    private int id;
    private String nome;
    private Jogador jogador1;
    private Jogador jogador2;
    private int pontos;

    public Equipe(int id, String nome) {
        this.id = id;
        this.nome = nome;
        this.pontos = 0;
    }
    
    public int getId() {
        return id;
    }
    
    public String getNome() {
        return nome;
    }
    
    public Jogador getJogador1() {
        return jogador1;
    }
    
    public Jogador getJogador2() {
        return jogador2;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    
    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public void setJogador1(Jogador jogador1) {
        this.jogador1 = jogador1;
    }
    
    public void setJogador2(Jogador jogador2) {
        this.jogador2 = jogador2;
    }
    
    public int getPontos() {
        return pontos;
    }
    
    public void setPontos(int pontos) {
        this.pontos = pontos;
    }
    
    public void adicionarPontos(int pontos) {
        this.pontos += pontos;
    }
    
    public boolean temJogador(Jogador jogador) {
        return (jogador1 != null && jogador1.getId() == jogador.getId()) ||
               (jogador2 != null && jogador2.getId() == jogador.getId());
    }
    
    @Override
    public String toString() {
        return nome + " (Pontos: " + pontos + ")";
    }
}