/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import jdbc.Conexao;
import modelo.VendaModeloProduto;


/**
 *
 * @author João Pedro
 */
public class VendaProdutoDao {

    public List<VendaModeloProduto> adicionarProdutoVenda(String codigo) throws SQLException {
        List<VendaModeloProduto> produtosVenda;
        try (Connection conexao = new Conexao().getConexao()) {
            String sql = "Select * from produto where codigo= ?";
            try (PreparedStatement ps = conexao.prepareStatement(sql)) {
                ps.setString(1, codigo);
                try (ResultSet rs = ps.executeQuery()) {
                    produtosVenda = new ArrayList<>();
                    while (rs.next()) {
                        VendaModeloProduto vendaModeloProduto = new VendaModeloProduto(rs.getString("codigo"),
                                rs.getString("descricao"),
                                rs.getString("valorVenda"));
                        produtosVenda.add(vendaModeloProduto);
                    }
                }
            }
        }

        return produtosVenda;

    }
}
