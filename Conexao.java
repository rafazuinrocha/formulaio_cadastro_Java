/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexao;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author ifsp
 */
public class Conexao {
    // Método de conexão com o banco de dados
    public static Connection getConexao(){
        try {
            // Cria a variável de conexão
            Connection conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/rafamusic?serverTimezone=UTC",
                    "root", // Usuário
                    "" // Senha
            );
            return conn;
        } catch (Exception e) {
            // Mensagem de erro de conexão
            System.out.println("Houve um erro ao tentar se conectar ao banco de dados -> " + e.getMessage());
            return null;
        }
    }
}
