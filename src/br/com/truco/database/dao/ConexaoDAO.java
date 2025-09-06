package br.com.truco.database.dao;

import br.com.truco.database.conexao.Conexao;
import br.com.truco.model.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ConexaoDAO {
    protected Connection conn;

    public void abrirConexao() {
        try {
            conn = Conexao.getConnection();
        } catch (Exception e) {
            System.err.println("Erro ao abrir conexão: " + e.getMessage());
        }
    }

    public void fecharConexao() {
        try {
            if (conn != null && !conn.isClosed()) {
                conn.close();
                System.out.println("Conexão fechada.");
            }
        } catch (SQLException e) {
            System.err.println("Erro ao fechar conexão: " + e.getMessage());
        }
    }
    
    public void salvarPartida(Partida partida) {
        String sql = "INSERT INTO partidas (equipe1_id, equipe2_id, pontuacao_equipe1, pontuacao_equipe2, vencedor_id, finalizada, inicio, atualizada) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        
        try (Connection conn = Conexao.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            
            stmt.setInt(1, partida.getEquipe1().getId());
            stmt.setInt(2, partida.getEquipe2().getId());
            stmt.setInt(3, partida.getPontuacaoEquipe1());
            stmt.setInt(4, partida.getPontuacaoEquipe2());
            stmt.setInt(5, partida.getVencedores() != null ? partida.getVencedores().getId() : 0);
            stmt.setBoolean(6, partida.isFinalizada());
            stmt.setTimestamp(7, partida.getInicio());
            stmt.setTimestamp(8, partida.getAtualizada());
            
            stmt.executeUpdate();
            
            try (ResultSet rs = stmt.getGeneratedKeys()) {
                if (rs.next()) {
                    partida.setId(rs.getInt(1));
                }
            }
            
        } catch (SQLException e) {
            System.err.println("Erro ao salvar partida: " + e.getMessage());
        }
    }
    
    public void salvarRodada(Rodada rodada) {
        String sql = "INSERT INTO rodadas (partida_id, vencedor_id, valor, inicio) VALUES (?, ?, ?, ?)";
        
        try (Connection conn = Conexao.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            
            stmt.setInt(1, rodada.getPartida().getId());
            stmt.setInt(2, rodada.getVencedor() != null ? rodada.getVencedor().getId() : 0);
            stmt.setInt(3, rodada.getValor());
            stmt.setTimestamp(4, rodada.getInicio());
            
            stmt.executeUpdate();
            
            try (ResultSet rs = stmt.getGeneratedKeys()) {
                if (rs.next()) {
                    rodada.setId(rs.getInt(1));
                }
            }
            
        } catch (SQLException e) {
            System.err.println("Erro ao salvar rodada: " + e.getMessage());
        }
    }
    
    public void salvarJogada(Carta carta, Jogador jogador, Rodada rodada) {
        String sql = "INSERT INTO jogadas (rodada_id, jogador_id, carta_numero, carta_naipe, ordem) VALUES (?, ?, ?, ?, ?)";
        
        try (Connection conn = Conexao.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setInt(1, rodada.getId());
            stmt.setInt(2, jogador.getId());
            stmt.setInt(3, carta.getNumero());
            stmt.setString(4, carta.getNaipe().name());
            stmt.setInt(5, rodada.getCartasJogadas().size());
            
            stmt.executeUpdate();
            
        } catch (SQLException e) {
            System.err.println("Erro ao salvar jogada: " + e.getMessage());
        }
    }
    
    public void atualizarPartida(Partida partida) {
        String sql = "UPDATE partidas SET pontuacao_equipe1 = ?, pontuacao_equipe2 = ?, vencedor_id = ?, finalizada = ?, atualizada = ? WHERE id = ?";
        
        try (Connection conn = Conexao.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setInt(1, partida.getPontuacaoEquipe1());
            stmt.setInt(2, partida.getPontuacaoEquipe2());
            stmt.setInt(3, partida.getVencedores() != null ? partida.getVencedores().getId() : 0);
            stmt.setBoolean(4, partida.isFinalizada());
            stmt.setTimestamp(5, partida.getAtualizada());
            stmt.setInt(6, partida.getId());
            
            stmt.executeUpdate();
            
        } catch (SQLException e) {
            System.err.println("Erro ao atualizar partida: " + e.getMessage());
        }
    }
    
    public List<Partida> listarPartidas() {
        List<Partida> partidas = new ArrayList<>();
        String sql = "SELECT * FROM partidas ORDER BY inicio DESC";
        
        try (Connection conn = Conexao.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            
            while (rs.next()) {
                Partida partida = new Partida();
                partida.setId(rs.getInt("id"));
                partida.setPontuacaoEquipe1(rs.getInt("pontuacao_equipe1"));
                partida.setPontuacaoEquipe2(rs.getInt("pontuacao_equipe2"));
                partida.setFinalizada(rs.getBoolean("finalizada"));
                partida.setInicio(rs.getTimestamp("inicio"));
                partida.setAtualizada(rs.getTimestamp("atualizada"));
                
                partidas.add(partida);
            }
            
        } catch (SQLException e) {
            System.err.println("Erro ao listar partidas: " + e.getMessage());
        }
        
        return partidas;
    }
    
    public List<Rodada> listarRodadasPorPartida(int partidaId) {
        List<Rodada> rodadas = new ArrayList<>();
        String sql = "SELECT * FROM rodadas WHERE partida_id = ? ORDER BY inicio ASC";
        
        try (Connection conn = Conexao.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setInt(1, partidaId);
            ResultSet rs = stmt.executeQuery();
            
            while (rs.next()) {
                Rodada rodada = new Rodada();
                rodada.setId(rs.getInt("id"));
                rodada.setValor(rs.getInt("valor"));
                rodada.setInicio(rs.getTimestamp("inicio"));
                
                rodadas.add(rodada);
            }
            
        } catch (SQLException e) {
            System.err.println("Erro ao listar rodadas: " + e.getMessage());
        }
        
        return rodadas;
    }
}
