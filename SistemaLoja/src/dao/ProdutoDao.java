/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import jdbc.Conexao;
import modelo.ProdutoModelo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author João Pedro
 */
public class ProdutoDao {
    
    public void cadastrarProduto(ProdutoModelo produto) throws SQLException {
        Connection conexao = new Conexao().getConexao();
        String sql = "INSERT INTO produto(descricao, codigo, quantidade, valorCusto, valorVenda, departamento, marca)VALUES (?,?,?,?,?,?,?)";
        PreparedStatement ps = conexao.prepareStatement(sql);
        ps.setString(1, produto.getDescricao());
        ps.setString(2, produto.getCodigo());
        ps.setString(3, produto.getQuantidade());
        ps.setString(4, produto.getValorCusto());
        ps.setString(5, produto.getValorVenda());
        ps.setString(6, produto.getDepartamento());
        ps.setString(7, produto.getMarca());
        ps.execute();
        ps.close();
        conexao.close();
        
    }
    
    public List<ProdutoModelo> buscarProduto(String descricao) throws SQLException {
        Connection conexao = new Conexao().getConexao();
        String sql = "Select * from produto where descricao like ?";
        PreparedStatement ps = conexao.prepareStatement(sql);
        ps.setString(1, "%" + descricao + "%");
        ResultSet rs = ps.executeQuery();
        List<ProdutoModelo> produtos = new ArrayList<>();
        while (rs.next()) {
            ProdutoModelo produtoModelo = new ProdutoModelo(rs.getString("descricao"),
            rs.getString("codigo"), 
            rs.getString("quantidade"),
            rs.getString("valorCusto"),
            rs.getString("valorVenda"), 
            rs.getString("departamento"),
            rs.getString("marca"));
            produtos.add(produtoModelo);
        }
        rs.close();
        ps.close();
        conexao.close();
        
        return produtos;
        
    }
    
}
