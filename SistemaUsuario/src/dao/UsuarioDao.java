/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import jdbc.Conexao;
import modelo.Usuario;

/**
 *
 * @author aluno
 */
public class UsuarioDao {
    public Usuario login (String login, String senha)throws SQLException{
        
        Connection conexao = new Conexao().getConnection();
        String sql = "select * from usuario where login=? and senha=?";
            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setString(1, login);
            ps.setString(2, senha);
            ResultSet rs = ps.executeQuery();
            
            Usuario usuario = null;
            
            while(rs.next()){
                usuario = new Usuario();
                usuario.setCodigo(rs.getInt("codigo"));
                usuario.setNome(rs.getString("nome"));
                usuario.setLogin(rs.getString("login"));
                usuario.setNivel(rs.getString("nivel"));
            }
        rs.close();
        ps.close();
        conexao.close();
        
        return usuario;
    }
    
    public Boolean cadastrar(String nome, String login, String senha, String nivel)throws SQLException{
                
       
        Connection conexao = new Conexao().getConnection();
        String sql = "INSERT INTO usuario (nome, login, senha, nivel) VALUES(?,?,?,?)";
        PreparedStatement ps = conexao.prepareStatement(sql);
        ps.setString(1, nome);
        ps.setString(2, login);
        ps.setString(3, senha);
        ps.setString(4, nivel);
        int result = ps.executeUpdate();
        if (result > 0 ) {
            conexao.close();
            return true;

        }
        conexao.close();
        ps.close();
        return false;
       
    }
    
}
