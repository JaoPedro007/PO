/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author aluno
 */
public class Conexao {
    private final String database="db_sistema";
    private final String user="root";
    private final String password = "";
    
    public Connection getConnection(){
        try {
           return DriverManager.getConnection("jdbc:mysql://localhost/" + database + "?userSSL", user, password);
        } 
        catch (SQLException ex) {
            System.out.println("Erro ao fazer a conexão");
            throw new RuntimeException(ex);
        }
    }
    
}
