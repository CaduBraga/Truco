package database.dao;

import java.sql.Connection;
import java.sql.SQLException;

import database.conexao.Conexao;

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
}
