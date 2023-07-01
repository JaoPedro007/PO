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
import modelo.DepartamentoModelo;

/**
 *
 * @author João Pedro
 */
public class DepartamentoDao {

    public void cadastrarDepartamento(DepartamentoModelo departamento) throws SQLException {
        try (Connection conexao = new Conexao().getConexao()) {
            String sql = "INSERT INTO departamento(nome,descricao)VALUES (?,?)";
            try (PreparedStatement ps = conexao.prepareStatement(sql)) {
                ps.setString(1, departamento.getNome());
                ps.setString(2, departamento.getDescricao());
                ps.execute();
            }
        }

    }

    public void excluirDepartamento(String nome) throws SQLException {
        try (Connection conexao = new Conexao().getConexao()) {
            String sql = "DELETE FROM departamento where nome= ?";
            try (PreparedStatement ps = conexao.prepareStatement(sql)) {
                ps.setString(1, nome);
                ps.executeUpdate();
            }
        }
    }

    public void editarDepartamento(DepartamentoModelo departamento) throws SQLException {

        try (Connection conexao = new Conexao().getConexao()) {
            String sql = "UPDATE departamento SET nome=?, descricao=? WHERE nome=?";
            try (PreparedStatement ps = conexao.prepareStatement(sql)) {
                ps.setString(1, departamento.getNome());
                ps.setString(2, departamento.getDescricao());
                ps.setString(3, departamento.getNome()); //Parametro para o where
                ps.executeUpdate();
            }
        }
    }

    public List<DepartamentoModelo> buscarDepartamento(String nome) throws SQLException {
        List<DepartamentoModelo> departamentos;
        try (Connection conexao = new Conexao().getConexao()) {
            String sql = "Select * from departamento where nome like ?";
            try (PreparedStatement ps = conexao.prepareStatement(sql)) {
                ps.setString(1, "%" + nome + "%");
                try (ResultSet rs = ps.executeQuery()) {
                    departamentos = new ArrayList<>();
                    while (rs.next()) {
                        DepartamentoModelo departamentoModelo = new DepartamentoModelo(rs.getString("nome"),
                                rs.getString("descricao"));
                        departamentos.add(departamentoModelo);
                    }
                }
            }
        }

        return departamentos;

    }

}
