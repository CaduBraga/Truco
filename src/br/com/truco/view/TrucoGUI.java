package br.com.truco.view;

import br.com.truco.model.*;
import br.com.truco.model.deck.*;
import br.com.truco.service.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.ArrayList;

public class TrucoGUI extends JFrame {
    private GerenciadorJogo gerenciadorJogo;
    private Partida partida;
    private Jogador jogadorAtual;
    private List<Carta> cartasJogadas;
    private int valorRodada;
    private boolean trucoAceito;
    
    // Componentes da interface
    private JPanel painelPrincipal;
    private JPanel painelCartas;
    private JPanel painelInfo;
    private JPanel painelControles;
    private JLabel labelPlacar;
    private JLabel labelJogadorAtual;
    private JLabel labelValorRodada;
    private JTextArea areaHistorico;
    private JButton botaoTruco;
    private JButton botaoAceitar;
    private JButton botaoRecusar;
    private JButton botaoNovaPartida;
    
    public TrucoGUI() {
        inicializarInterface();
        inicializarJogo();
    }
    
    private void inicializarInterface() {
        setTitle("Jogo de Truco - Projeto de Estudo");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1000, 700);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());
        
        // Painel principal
        painelPrincipal = new JPanel(new BorderLayout());
        painelPrincipal.setBackground(new Color(34, 139, 34)); // Verde escuro
        
        // Painel de informações
        painelInfo = new JPanel(new GridLayout(3, 1));
        painelInfo.setBackground(new Color(34, 139, 34));
        painelInfo.setBorder(BorderFactory.createTitledBorder("Informações da Partida"));
        
        labelPlacar = new JLabel("Placar: Equipe A 0 x 0 Equipe B", JLabel.CENTER);
        labelPlacar.setFont(new Font("Arial", Font.BOLD, 16));
        labelPlacar.setForeground(Color.WHITE);
        
        labelJogadorAtual = new JLabel("Jogador atual: ", JLabel.CENTER);
        labelJogadorAtual.setFont(new Font("Arial", Font.BOLD, 14));
        labelJogadorAtual.setForeground(Color.WHITE);
        
        labelValorRodada = new JLabel("Valor da rodada: 1", JLabel.CENTER);
        labelValorRodada.setFont(new Font("Arial", Font.BOLD, 14));
        labelValorRodada.setForeground(Color.WHITE);
        
        painelInfo.add(labelPlacar);
        painelInfo.add(labelJogadorAtual);
        painelInfo.add(labelValorRodada);
        
        // Painel de cartas
        painelCartas = new JPanel(new FlowLayout());
        painelCartas.setBackground(new Color(34, 139, 34));
        painelCartas.setBorder(BorderFactory.createTitledBorder("Suas Cartas"));
        
        // Painel de controles
        painelControles = new JPanel(new FlowLayout());
        painelControles.setBackground(new Color(34, 139, 34));
        
        botaoTruco = new JButton("Truco!");
        botaoTruco.setBackground(new Color(220, 20, 60));
        botaoTruco.setForeground(Color.WHITE);
        botaoTruco.setFont(new Font("Arial", Font.BOLD, 14));
        botaoTruco.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pedirTruco();
            }
        });
        
        botaoAceitar = new JButton("Aceitar");
        botaoAceitar.setBackground(new Color(0, 128, 0));
        botaoAceitar.setForeground(Color.WHITE);
        botaoAceitar.setFont(new Font("Arial", Font.BOLD, 14));
        botaoAceitar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                aceitarTruco();
            }
        });
        
        botaoRecusar = new JButton("Recusar");
        botaoRecusar.setBackground(new Color(220, 20, 60));
        botaoRecusar.setForeground(Color.WHITE);
        botaoRecusar.setFont(new Font("Arial", Font.BOLD, 14));
        botaoRecusar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                recusarTruco();
            }
        });
        
        botaoNovaPartida = new JButton("Nova Partida");
        botaoNovaPartida.setBackground(new Color(70, 130, 180));
        botaoNovaPartida.setForeground(Color.WHITE);
        botaoNovaPartida.setFont(new Font("Arial", Font.BOLD, 14));
        botaoNovaPartida.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                novaPartida();
            }
        });
        
        painelControles.add(botaoTruco);
        painelControles.add(botaoAceitar);
        painelControles.add(botaoRecusar);
        painelControles.add(botaoNovaPartida);
        
        // Área de histórico
        areaHistorico = new JTextArea(10, 30);
        areaHistorico.setEditable(false);
        areaHistorico.setBackground(new Color(245, 245, 245));
        areaHistorico.setFont(new Font("Monospaced", Font.PLAIN, 12));
        JScrollPane scrollPane = new JScrollPane(areaHistorico);
        scrollPane.setBorder(BorderFactory.createTitledBorder("Histórico do Jogo"));
        
        // Adicionar componentes ao painel principal
        painelPrincipal.add(painelInfo, BorderLayout.NORTH);
        painelPrincipal.add(painelCartas, BorderLayout.CENTER);
        painelPrincipal.add(painelControles, BorderLayout.SOUTH);
        
        add(painelPrincipal, BorderLayout.CENTER);
        add(scrollPane, BorderLayout.EAST);
        
        // Inicializar estado dos botões
        atualizarBotoes();
    }
    
    private void inicializarJogo() {
        // Criar jogadores
        Jogador jogador1 = new Jogador(1, "João");
        Jogador jogador2 = new Jogador(2, "Maria");
        Jogador jogador3 = new Jogador(3, "Pedro");
        Jogador jogador4 = new Jogador(4, "Ana");
        
        // Criar equipes
        Equipe equipe1 = new Equipe(1, "Equipe A");
        equipe1.setJogador1(jogador1);
        equipe1.setJogador2(jogador2);
        
        Equipe equipe2 = new Equipe(2, "Equipe B");
        equipe2.setJogador1(jogador3);
        equipe2.setJogador2(jogador4);
        
        // Criar partida
        this.partida = new Partida(1, equipe1, equipe2);
        
        // Criar gerenciador de jogo
        this.gerenciadorJogo = new GerenciadorJogo(partida);
        this.jogadorAtual = gerenciadorJogo.getJogadorAtual();
        this.cartasJogadas = new ArrayList<>();
        this.valorRodada = 1;
        this.trucoAceito = false;
        
        // Iniciar primeira rodada
        gerenciadorJogo.iniciarNovaRodada();
        
        atualizarInterface();
        adicionarMensagem("🎮 Bem-vindo ao Jogo de Truco! 🎮");
        adicionarMensagem("Partida iniciada entre " + equipe1.getNome() + " e " + equipe2.getNome());
    }
    
    private void mostrarCartasJogador() {
        painelCartas.removeAll();
        
        if (jogadorAtual.getMao() != null) {
            List<Carta> cartas = jogadorAtual.getMao().getCartas();
            for (int i = 0; i < cartas.size(); i++) {
                Carta carta = cartas.get(i);
                JButton botaoCarta = new JButton(carta.toString());
                botaoCarta.setPreferredSize(new Dimension(120, 80));
                botaoCarta.setBackground(Color.WHITE);
                botaoCarta.setFont(new Font("Arial", Font.BOLD, 10));
                botaoCarta.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        jogarCarta(carta);
                    }
                });
                painelCartas.add(botaoCarta);
            }
        }
        
        painelCartas.revalidate();
        painelCartas.repaint();
    }
    
    private void jogarCarta(Carta carta) {
        if (gerenciadorJogo.jogarCarta(jogadorAtual, carta)) {
            adicionarMensagem(jogadorAtual.getNome() + " jogou: " + carta.toString());
            
            // Atualizar jogador atual
            jogadorAtual = gerenciadorJogo.getJogadorAtual();
            
            // Atualizar cartas jogadas
            cartasJogadas = gerenciadorJogo.getCartasJogadas();
            
            // Verificar se a partida terminou
            if (gerenciadorJogo.isPartidaTerminada()) {
                finalizarPartida();
            } else if (cartasJogadas.size() >= 4) {
                // Nova rodada
                novaRodada();
            }
            
            mostrarCartasJogador();
            atualizarInterface();
        }
    }
    
    private void novaRodada() {
        gerenciadorJogo.iniciarNovaRodada();
        jogadorAtual = gerenciadorJogo.getJogadorAtual();
        cartasJogadas = gerenciadorJogo.getCartasJogadas();
        valorRodada = gerenciadorJogo.getValorRodada();
        trucoAceito = gerenciadorJogo.isTrucoPendente();
        
        adicionarMensagem("🃏 Nova rodada iniciada!");
        mostrarCartasJogador();
        atualizarInterface();
    }
    
    private void finalizarPartida() {
        adicionarMensagem("🎉 PARTIDA FINALIZADA! 🎉");
        Equipe vencedor = gerenciadorJogo.getVencedorPartida();
        if (vencedor != null) {
            adicionarMensagem("Vencedores: " + vencedor.getNome());
        }
        
        // Desabilitar botões de jogo
        botaoTruco.setEnabled(false);
        botaoAceitar.setEnabled(false);
        botaoRecusar.setEnabled(false);
    }
    
    private void pedirTruco() {
        if (!trucoAceito && gerenciadorJogo.pedirTruco(jogadorAtual)) {
            adicionarMensagem("🔥 " + jogadorAtual.getNome() + " pediu TRUCO!");
            trucoAceito = true;
            valorRodada = gerenciadorJogo.getValorRodada();
            atualizarInterface();
        }
    }
    
    private void aceitarTruco() {
        if (trucoAceito && gerenciadorJogo.aceitarTruco(jogadorAtual)) {
            adicionarMensagem("✅ Truco aceito! Valor da rodada: " + valorRodada);
            trucoAceito = false;
            valorRodada = gerenciadorJogo.getValorRodada();
            atualizarInterface();
        }
    }
    
    private void recusarTruco() {
        if (trucoAceito && gerenciadorJogo.recusarTruco(jogadorAtual)) {
            adicionarMensagem("❌ Truco recusado! Rodada finalizada.");
            trucoAceito = false;
            
            // Verificar se a partida terminou
            if (gerenciadorJogo.isPartidaTerminada()) {
                finalizarPartida();
            } else {
                novaRodada();
            }
        }
    }
    
    private void novaPartida() {
        int opcao = JOptionPane.showConfirmDialog(this, 
            "Deseja iniciar uma nova partida?", 
            "Nova Partida", 
            JOptionPane.YES_NO_OPTION);
        
        if (opcao == JOptionPane.YES_OPTION) {
            areaHistorico.setText("");
            inicializarJogo();
        }
    }
    
    private void atualizarInterface() {
        labelPlacar.setText("Placar: " + partida.getEquipe1().getNome() + " " + 
                           partida.getPontuacaoEquipe1() + " x " + 
                           partida.getPontuacaoEquipe2() + " " + partida.getEquipe2().getNome());
        
        labelJogadorAtual.setText("Jogador atual: " + jogadorAtual.getNome());
        labelValorRodada.setText("Valor da rodada: " + valorRodada);
        
        atualizarBotoes();
    }
    
    private void atualizarBotoes() {
        botaoTruco.setEnabled(!trucoAceito && jogadorAtual.temCartas() && gerenciadorJogo.isVezDoJogador(jogadorAtual));
        botaoAceitar.setEnabled(trucoAceito && gerenciadorJogo.isVezDoJogador(jogadorAtual));
        botaoRecusar.setEnabled(trucoAceito && gerenciadorJogo.isVezDoJogador(jogadorAtual));
    }
    
    private void adicionarMensagem(String mensagem) {
        areaHistorico.append(mensagem + "\n");
        areaHistorico.setCaretPosition(areaHistorico.getDocument().getLength());
    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeel());
                } catch (Exception e) {
                    e.printStackTrace();
                }
                
                new TrucoGUI().setVisible(true);
            }
        });
    }
}
