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
import modelo.UsuarioModelo;

/**
 *
 * @author aluno
 */
public class UsuarioDao {
    
    public void cadastrarUsuario(UsuarioModelo usuario)throws SQLException{
        try (Connection conexao = new Conexao().getConexao()) {
            String sql= "INSERT INTO usuario(nome,login,senha,cargo)VALUES (?,?,?,?)";
            try (PreparedStatement ps = conexao.prepareStatement(sql)) {
                ps.setString(1,usuario.getNome());
                ps.setString(2, usuario.getLogin());
                ps.setString(3,usuario.getSenha());
                ps.setString(4,usuario.getCargo());
                ps.execute();
            }
        }
        
    }
    
    public void excluirUsuario(String login) throws SQLException{
        try (Connection conexao = new Conexao().getConexao()) {
            String sql="DELETE FROM usuario where login= ?";
            try (PreparedStatement ps = conexao.prepareStatement(sql)) {
                ps.setString(1, login);
                ps.executeUpdate();
            }
        }
    }
    
   
    
 
    
    public List<UsuarioModelo> buscarUsuario(String login) throws SQLException{
        List<UsuarioModelo> usuarios;
        try (Connection conexao = new Conexao().getConexao()) {
            String sql = "Select * from usuario where login like ?";
            try (PreparedStatement ps = conexao.prepareStatement(sql)) {
                ps.setString(1, "%" + login + "%");
                try (ResultSet rs = ps.executeQuery()) {
                    usuarios = new ArrayList<>();
                    while (rs.next()) {
                        UsuarioModelo usuariomodelo = new UsuarioModelo(rs.getString("nome"),
                                rs.getString("login"), rs.getString("senha"), rs.getString("cargo"));
                        usuarios.add(usuariomodelo);
                    }
                }
            }
        }
        
        return usuarios;

    }
    
}
