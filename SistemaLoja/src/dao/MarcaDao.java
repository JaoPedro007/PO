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
import modelo.MarcaModelo;

/**
 *
 * @author João Pedro
 */
public class MarcaDao {
 
    public void cadastrarMarca(MarcaModelo marca) throws SQLException {
        System.out.print(marca);
        try (Connection conexao = new Conexao().getConexao()) {
            String sql = "INSERT INTO marca(nome,descricao)VALUES (?,?)";
            try (PreparedStatement ps = conexao.prepareStatement(sql)) {
                ps.setString(1, marca.getNome());
                ps.setString(2, marca.getDescricao());
                ps.execute();
            }
        }

    }

    public void excluirMarca(String nome) throws SQLException {
        try (Connection conexao = new Conexao().getConexao()) {
            String sql = "DELETE FROM marca where nome= ?";
            try (PreparedStatement ps = conexao.prepareStatement(sql)) {
                ps.setString(1, nome);
                ps.executeUpdate();
            }
        }
    }

    public void editarMarca(MarcaModelo marca) throws SQLException {

        try (Connection conexao = new Conexao().getConexao()) {
            String sql = "UPDATE marca SET nome=?, descricao=? WHERE nome=?";
            try (PreparedStatement ps = conexao.prepareStatement(sql)) {
                ps.setString(1, marca.getNome());
                ps.setString(2, marca.getDescricao());
                ps.setString(3, marca.getNome()); //Parametro para o where
                ps.executeUpdate();
            }
        }
    }

    public List<MarcaModelo> buscarMarca(String nome) throws SQLException {
        List<MarcaModelo> marcas;
        try (Connection conexao = new Conexao().getConexao()) {
            String sql = "Select * from marca where nome like ?";
            try (PreparedStatement ps = conexao.prepareStatement(sql)) {
                ps.setString(1, "%" + nome + "%");
                try (ResultSet rs = ps.executeQuery()) {
                    marcas = new ArrayList<>();
                    while (rs.next()) {
                        MarcaModelo marcaModelo = new MarcaModelo(rs.getString("nome"),
                                rs.getString("descricao"));
                        marcas.add(marcaModelo);
                    }
                }
            }
        }

        return marcas;
       
}
}
