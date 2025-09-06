package br.com.truco.service;

import br.com.truco.model.deck.Carta;
import br.com.truco.model.deck.Naipe;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Embaralhar {
    
    public static List<Carta> criarBaralho() {
        List<Carta> baralho = new ArrayList<>();
        int id = 1;
        
        for (Naipe naipe : Naipe.values()) {
            int[] numeros = {1, 2, 3, 4, 5, 6, 7, 10, 11, 12, 13};
            
            for (int numero : numeros) {
                baralho.add(new Carta(id++, numero, naipe));
            }
        }
        
        return baralho;
    }
    
    public static void embaralharBaralho(List<Carta> baralho) {
        Collections.shuffle(baralho);
    }
    
    public static List<Carta> distribuirCartas(List<Carta> baralho, int quantidade) {
        List<Carta> cartas = new ArrayList<>();
        
        for (int i = 0; i < quantidade && i < baralho.size(); i++) {
            cartas.add(baralho.get(i));
        }
        
        return cartas;
    }
    
    public static List<Carta> pegarCartasDoTopo(List<Carta> baralho, int quantidade) {
        List<Carta> cartas = new ArrayList<>();
        
        for (int i = 0; i < quantidade && i < baralho.size(); i++) {
            cartas.add(baralho.get(i));
        }
        
        for (int i = 0; i < quantidade && i < baralho.size(); i++) {
            baralho.remove(0);
        }
        
        return cartas;
    }
    
    public static void mostrarBaralho(List<Carta> baralho) {
        System.out.println("Baralho (" + baralho.size() + " cartas):");
        for (int i = 0; i < baralho.size(); i++) {
            System.out.println((i + 1) + ". " + baralho.get(i));
        }
    }
}
