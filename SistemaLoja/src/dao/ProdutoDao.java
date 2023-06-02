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
        try (Connection conexao = new Conexao().getConexao()) {
            String sql = "INSERT INTO produto(descricao, codigo, quantidade, valorCusto, valorVenda, departamento, marca)VALUES (?,?,?,?,?,?,?)";
            try (PreparedStatement ps = conexao.prepareStatement(sql)) {
                ps.setString(1, produto.getDescricao());
                ps.setString(2, produto.getCodigo());
                ps.setString(3, produto.getQuantidade());
                ps.setString(4, produto.getValorCusto());
                ps.setString(5, produto.getValorVenda());
                ps.setString(6, produto.getDepartamento());
                ps.setString(7, produto.getMarca());
                ps.execute();
            }
        }

    }

    public List<ProdutoModelo> buscarProduto(String descricao) throws SQLException {
        List<ProdutoModelo> produtos;
        try (Connection conexao = new Conexao().getConexao()) {
            String sql = "Select * from produto where descricao like ?";
            try (PreparedStatement ps = conexao.prepareStatement(sql)) {
                ps.setString(1, "%" + descricao + "%");
                try (ResultSet rs = ps.executeQuery()) {
                    produtos = new ArrayList<>();
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
                }
            }
        }

        return produtos;

    }

    public void excluirProduto(String codigo) throws SQLException {
        try (Connection conexao = new Conexao().getConexao()) {
            String sql = "delete from produto where codigo= ?";
            try (PreparedStatement ps = conexao.prepareStatement(sql)) {
                ps.setString(1, codigo);

                ps.executeUpdate();
            }
        }

    }

    public void editar(ProdutoModelo produto) throws SQLException {
        try (Connection conexao = new Conexao().getConexao()) {
            String sql = "UPDATE produto set codigo=? ,descricao=?, quantidade=?, valorCusto=?, valorVenda=?, marca=?, departamento=?"
                    + " where codigo=?";
            try (PreparedStatement ps = conexao.prepareStatement(sql)) {
                ps.setString(1, produto.getCodigo());
                ps.setString(2, produto.getDescricao());
                ps.setString(3, produto.getQuantidade());
                ps.setString(4, produto.getValorCusto());
                ps.setString(5, produto.getValorVenda());
                ps.setString(6, produto.getDepartamento());
                ps.setString(7, produto.getMarca());

                ps.executeUpdate();
            }
        }
    }

}
