package br.com.truco.model;

import java.sql.Timestamp;

public class Partida {
    int id;
    Equipe equipe1;
    Equipe equipe2;
    int pontuacaoEquipe1;
    int pontuacaoEquipe2;
    Equipe vencedores;
    boolean finalizada;
    Timestamp inicio;
    Timestamp atualizada;

    public Partida(int id, Equipe equipe1, Equipe equipe2, int pontuacaoEquipe1, int pontuacaoEquipe2, Equipe vencedores, Timestamp inicio, Timestamp atualizada) {
        this.id = id;
        this.equipe1 = equipe1;
        this.equipe2 = equipe2;
        this.pontuacaoEquipe1 = pontuacaoEquipe1;
        this.pontuacaoEquipe2 = pontuacaoEquipe2;
        this.vencedores = vencedores;
        this.finalizada = finalizada;
        this.inicio = inicio;
        this.atualizada = atualizada;
    }
}