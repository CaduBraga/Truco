package br.com.truco.database.conexao;

import java.sql.Connection;

public class TesteConexao {
    public static void main(String[] args) {
        try (Connection conn = database.conexao.Conexao.getConnection()) {
            if (conn != null) {
                System.out.println("✅ Conexão estabelecida com sucesso!");
            } else {
                System.out.println("❌ Falha na conexão.");
            }
        } catch (Exception e) {
            System.err.println("Erro durante o teste de conexão: " + e.getMessage());
        }
    }
}