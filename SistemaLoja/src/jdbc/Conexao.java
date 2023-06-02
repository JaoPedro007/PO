/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author aluno
 */
public class Conexao {
        
    private final String database ="sistemaLoja";
    private final String user ="root";
    private final String password ="";
    
    public Connection getConexao(){
        try{
            return DriverManager.getConnection("jdbc:mysql://localhost/"+database+"?userSSL=false",user, password);
        }catch(SQLException ex){
           JOptionPane.showMessageDialog(null, "Erro ao conectar com o Banco de Dados", "Erro", JOptionPane.ERROR_MESSAGE);
            throw new RuntimeException(ex);
        }
        
    }
}
