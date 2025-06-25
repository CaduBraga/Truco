package br.com.truco.database.conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {

    private static final String URL = "jdbc:mysql://turntable.proxy.rlwy.net:14028/railway";
    private static final String USER = "root";
    private static final String PASSWORD = "dyiyzCuVMZyHLhoNoNetzJEbHhOzsOxl";

    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            System.err.println("Erro ao conectar ao banco de dados: " + e.getMessage());
            throw new RuntimeException("Falha na conexão com o banco de dados", e);
        }
    }
}
