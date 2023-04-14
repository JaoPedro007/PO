/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

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
        String sql = "INSERT INTO cliente (nome, sexo, endereco, cep, bairro, cpf, nascimento, data_vencimento, unidade_consumidora, email, kwh, valor_total) VALUES(?,?,?,?,?,?,?,?,?,?,?)";
        PreparedStatement ps = conexao.prepareStatement(sql);
        ps.setString(1,pessoa.getNome());
        ps.setString(2, pessoa.getSexo());
        ps.setString(3, pessoa.getEndereco());
        ps.setString(4, pessoa.getCep());
        ps.setString(5, pessoa.getBairro());
        ps.setString(6, pessoa.getNascimento());
        ps.setString(7, pessoa.getDataVencimento());
        ps.setString(8, pessoa.getUnidadeConsumidora());
        ps.setString(9, pessoa.getEmail());
        ps.setInt(10, pessoa.getKwh());
        ps.setInt(11, pessoa.getValorTotal());        
        ps.execute();       
        ps.close();
        conexao.close();
        
    }
    
    
}
