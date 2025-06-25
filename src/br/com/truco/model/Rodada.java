package br.com.truco.model;

import java.sql.Timestamp;

public class Rodada {
    int id;
    Partida partida;
    Jogador vencedor;
    int valor;
    Timestamp inicio;

    public Rodada(int id, Partida partida, Jogador vencedor, int valor, Timestamp inicio) {
        this.id = id;
        this.partida = partida;
        this.vencedor = vencedor;
        this.valor = valor;
        this.inicio = inicio;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public Partida getPartida() {
        return partida;
    }
    public void setPartida(Partida partida) {
        this.partida = partida;
    }
    public Jogador getVencedor() {
        return vencedor;
    }
    public void setVencedor(Jogador vencedor) {
        this.vencedor = vencedor;
    }
    public int getValor() {
        return valor;
    }
    public void setValor(int valor) {
        this.valor = valor;
    }
    public Timestamp getInicio() {
        return inicio;
    }
    public void setInicio(Timestamp inicio) {
        this.inicio = inicio;
    }
}