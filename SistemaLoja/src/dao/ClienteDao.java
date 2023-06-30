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
import modelo.ClienteModelo;

/**
 *
 * @author João Pedro
 */
public class ClienteDao {

    public void cadastrarCliente(ClienteModelo cliente) throws SQLException {
        try (Connection conexao = new Conexao().getConexao()) {
            String sql = "INSERT INTO cliente(nome, cpfcnpj, telefone, cidade, bairro, rua, numero)VALUES (?,?,?,?,?,?,?)";
            try (PreparedStatement ps = conexao.prepareStatement(sql)) {
                ps.setString(1, cliente.getNome());
                ps.setString(2, cliente.getCpfcnpj());
                ps.setString(3, cliente.getTelefone());
                ps.setString(4, cliente.getCidade());
                ps.setString(5, cliente.getBairro());
                ps.setString(6, cliente.getRua());
                ps.setString(7, cliente.getNumero());
                ps.execute();
            }
        }

    }

    public List<ClienteModelo> buscarCliente(String nome) throws SQLException {
        List<ClienteModelo> clientes;
        try (Connection conexao = new Conexao().getConexao()) {
            String sql = "Select * from cliente where nome like ?";
            try (PreparedStatement ps = conexao.prepareStatement(sql)) {
                ps.setString(1, "%" + nome + "%");
                try (ResultSet rs = ps.executeQuery()) {
                    clientes = new ArrayList<>();
                    while (rs.next()) {
                        ClienteModelo clienteModelo = new ClienteModelo(
                                rs.getString("nome"),
                                rs.getString("cpfcnpj"),
                                rs.getString("telefone"),
                                rs.getString("cidade"),
                                rs.getString("bairro"),
                                rs.getString("rua"),
                                rs.getString("numero"));
                        clientes.add(clienteModelo);
                    }
                }
            }
        }

        return clientes;

    }

    public void excluirCliente(String cpfcnpj) throws SQLException {
        try (Connection conexao = new Conexao().getConexao()) {
            String sql = "delete from cliente where cpfcnpj= ?";
            try (PreparedStatement ps = conexao.prepareStatement(sql)) {
                ps.setString(1, cpfcnpj);

                ps.executeUpdate();

            }
        }

    }

    public void editar(ClienteModelo cliente) throws SQLException {
        try (Connection conexao = new Conexao().getConexao()) {
            String sql = "UPDATE cliente SET nome=?, cpfcnpj=?, telefone=?, cidade=?, bairro=?, rua=?, numero=? WHERE cpfcnpj=?";
            try (PreparedStatement ps = conexao.prepareStatement(sql)) {
                ps.setString(1, cliente.getNome());
                ps.setString(2, cliente.getCpfcnpj());
                ps.setString(3, cliente.getTelefone());
                ps.setString(4, cliente.getCidade());
                ps.setString(5, cliente.getBairro());
                ps.setString(6, cliente.getRua());
                ps.setString(7, cliente.getNumero());
                ps.setString(8, cliente.getCpfcnpj());

                ps.executeUpdate();
            }
        }
    }
}
