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
import modelo.VendaModeloCliente;

/**
 *
 * @author João Pedro
 */
public class VendaClienteDao {

    public List<VendaModeloCliente> adicionarClienteVenda(String cpfCnpj) throws SQLException {
        List<VendaModeloCliente> dadosCliente;
        try (Connection conexao = new Conexao().getConexao()) {
            String sql = "Select * from cliente where cpfcnpj= ?";
            try (PreparedStatement ps = conexao.prepareStatement(sql)) {
                ps.setString(1, cpfCnpj);
                try (ResultSet rs = ps.executeQuery()) {
                    dadosCliente = new ArrayList<>();
                    while (rs.next()) {
                        VendaModeloCliente vendaModeloCliente = new VendaModeloCliente(
                                rs.getString("nome"),
                                rs.getString("cpfCnpj"),
                                rs.getString("telefone"));
                        dadosCliente.add(vendaModeloCliente);
                    }
                }
            }
        }
        return dadosCliente;
    }

}
