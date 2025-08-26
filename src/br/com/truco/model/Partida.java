package br.com.truco.model;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class Partida {
    private int id;
    private Equipe equipe1;
    private Equipe equipe2;
    private int pontuacaoEquipe1;
    private int pontuacaoEquipe2;
    private Equipe vencedores;
    private boolean finalizada;
    private Timestamp inicio;
    private Timestamp atualizada;
    private List<Rodada> rodadas;

    public Partida(int id, Equipe equipe1, Equipe equipe2) {
        this.id = id;
        this.equipe1 = equipe1;
        this.equipe2 = equipe2;
        this.pontuacaoEquipe1 = 0;
        this.pontuacaoEquipe2 = 0;
        this.finalizada = false;
        this.rodadas = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Equipe getEquipe1() {
        return equipe1;
    }

    public void setEquipe1(Equipe equipe1) {
        this.equipe1 = equipe1;
    }

    public Equipe getEquipe2() {
        return equipe2;
    }

    public void setEquipe2(Equipe equipe2) {
        this.equipe2 = equipe2;
    }

    public int getPontuacaoEquipe1() {
        return pontuacaoEquipe1;
    }

    public void setPontuacaoEquipe1(int pontuacaoEquipe1) {
        this.pontuacaoEquipe1 = pontuacaoEquipe1;
    }

    public int getPontuacaoEquipe2() {
        return pontuacaoEquipe2;
    }

    public void setPontuacaoEquipe2(int pontuacaoEquipe2) {
        this.pontuacaoEquipe2 = pontuacaoEquipe2;
    }

    public Equipe getVencedores() {
        return vencedores;
    }

    public void setVencedores(Equipe vencedores) {
        this.vencedores = vencedores;
    }

    public boolean isFinalizada() {
        return finalizada;
    }

    public void setFinalizada(boolean finalizada) {
        this.finalizada = finalizada;
    }

    public Timestamp getInicio() {
        return inicio;
    }

    public void setInicio(Timestamp inicio) {
        this.inicio = inicio;
    }

    public Timestamp getAtualizada() {
        return atualizada;
    }

    public void setAtualizada(Timestamp atualizada) {
        this.atualizada = atualizada;
    }

    public List<Rodada> getRodadas() {
        return rodadas;
    }

    public void adicionarRodada(Rodada rodada) {
        this.rodadas.add(rodada);
    }

    public void adicionarPontosEquipe1(int pontos) {
        this.pontuacaoEquipe1 += pontos;
    }

    public void adicionarPontosEquipe2(int pontos) {
        this.pontuacaoEquipe2 += pontos;
    }

    public boolean verificarVitoria() {
        if (pontuacaoEquipe1 >= 12) {
            vencedores = equipe1;
            finalizada = true;
            return true;
        } else if (pontuacaoEquipe2 >= 12) {
            vencedores = equipe2;
            finalizada = true;
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "Partida " + id + ": " + equipe1.getNome() + " vs " + equipe2.getNome() + 
               " (" + pontuacaoEquipe1 + " x " + pontuacaoEquipe2 + ")";
    }
}