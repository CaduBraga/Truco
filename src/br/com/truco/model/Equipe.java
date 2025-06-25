package br.com.truco.model;

public class Equipe {
    int id;
    String nome;
    Jogador jogador1;
    Jogador jogador2;

    public Equipe(int id, String nome) {
        this.id = id;
        this.nome = nome;
        this.jogador1 = jogador1;
        this.jogador2 = jogador2;
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
}