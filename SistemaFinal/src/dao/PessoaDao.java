/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.net.ConnectException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import jdbc.Conexao;
import modelo.Pessoa;

/**
 *
 * @author aluno
 */
public class PessoaDao {
    
    
    public void adicionar(Pessoa pessoa)throws SQLException{
        Connection conexao = new Conexao().getConnection();
        String sql = "INSERT INTO pessoa (descricao, cep, bairro, numero) VALUES(?,?,?,?)";
        PreparedStatement ps = conexao.prepareStatement(sql);
        ps.setString(1,pessoa.getDescricao());
        ps.setString(2, pessoa.getCep());
        ps.setString(3, pessoa.getBairro());
        ps.setInt(4, pessoa.getNumero());      
        ps.execute();       
        ps.close();
        conexao.close();
        
    }
    
    
}
