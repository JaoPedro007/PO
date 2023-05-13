

package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import jdbc.Conexao;
import modelo.Pessoa;
import modelo.Usuario;


public class UsuarioDao {
    
     public Usuario login (String login, String senha) throws SQLException{
        Connection conexao = new Conexao().getConexao();
        String sql = "Select * from usuario where login= ? and senha = ?";
        PreparedStatement ps = conexao.prepareStatement(sql);
        ps.setString(1, login);
        ps.setString(2, senha);
        ResultSet rs =ps.executeQuery();
        Usuario usuario=null;
        
        while (rs.next()) {
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

    
}
