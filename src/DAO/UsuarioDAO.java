/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;
import Conexao.ModuloConexao;
import JavaBean.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLDataException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author wramu
 */
public class UsuarioDAO {
    private Connection conecta;
    
     public UsuarioDAO(){
        this.conecta = new ModuloConexao().conector();
    }
     
     //rotinas SQL
    //Metodo Cadastrar usuario
     
    public void cadastrarUsuario(Usuario cadastrar) throws SQLException{
              
        try {
            String cmdsql = "insert into usuarios(login, senha, Permissao,Funcionariosuser_id) values ( ?, ?, ?,?) ";
            
            //organizar
            
            PreparedStatement stmt = conecta.prepareStatement(cmdsql);
            
            stmt.setString(1, cadastrar.getLogin());
            stmt.setString(2, cadastrar.getSenha());
            stmt.setString(3, cadastrar.getPermissao());
            stmt.setInt(4, cadastrar.getIdfuncionario());
            
            
            //execultar
            stmt.execute();
            
            //fechar conexao
            stmt.close();
            
        } catch (SQLDataException error) {
            throw new RuntimeException(error);
        }
    }
    //criando metodo de pesquisa
     public List<Usuario> read() throws SQLException{
         
          PreparedStatement stmt = null;
          ResultSet rs = null;
          List<Usuario> usuarios = new ArrayList<>();
          
        try {
            stmt = conecta.prepareStatement("SELECT * FROM usuarios");
           
            rs = stmt.executeQuery();
            while (rs.next()) {
                 
                
                Usuario usuario = new Usuario();
              
               // usuario.setIdusuario(rs.getInt("id"));
                usuario.setLogin(rs.getString("login"));
                usuario.setSenha(rs.getString("senha"));
                usuario.setIdfuncionario(rs.getInt("Funcionariosuser_id"));
                usuario.setPermissao(rs.getString("Permissao"));
                
                usuarios.add(usuario);
                
                
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProdutosDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            stmt.close();
            rs.close();
           
        }
        return usuarios;
         
}
     public List<Usuario> readForDesc(String desc) throws SQLException{
         
          PreparedStatement stmt = null;
          ResultSet rs = null;
          List<Usuario> usuarios = new ArrayList<>();
          
        try {
            stmt = conecta.prepareStatement("SELECT * FROM usuarios WHERE login LIKE ?");
            stmt.setString(1, "%"+desc+"%");
           
            rs = stmt.executeQuery();
            while (rs.next()) {
                 
                
                Usuario usuario = new Usuario();
              
               usuario.setIdusuario(rs.getInt("id"));
                usuario.setLogin(rs.getString("login"));
                usuario.setSenha(rs.getString("senha"));
               //usuario.setIdfuncionario(rs.getInt("Funcionariosuser_id"));
                usuario.setPermissao(rs.getString("Permissao")); // trocar no banco propriedade para string
                
                usuarios.add(usuario);
                
                
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProdutosDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            stmt.close();
            rs.close();
           
        }
        return usuarios;
         
}
    //alterar produtos da tabela

    public void update(Usuario alterar) throws SQLException {
        try {
            String cmdsql = "UPDATE usuarios SET login = ?, senha=?, Permissao = ? WHERE id = ?";

            //organizar
            PreparedStatement stmt = conecta.prepareStatement(cmdsql);

            stmt.setString(1, alterar.getLogin());
            stmt.setString(2, alterar.getSenha());
            stmt.setString(3, alterar.getPermissao());
            stmt.setInt(4, alterar.getIdfuncionario());
            stmt.setInt(4, alterar.getIdusuario());

            //execultar
            stmt.execute();

            // fechar conexao
            stmt.close();

            JOptionPane.showMessageDialog(null, "Editado com sucesso!");

        } catch (SQLDataException error) {
            JOptionPane.showMessageDialog(null,error);
        }

    }
      //deletar produtos da tabela
      public void delete(Usuario deletar) throws SQLException{
         try {
             String cmdsql = "DELETE FROM usuarios WHERE id = ?"; 
             
             //organizar
             
              PreparedStatement stmt = conecta.prepareStatement(cmdsql);

              stmt.setInt(1,deletar.getIdusuario());
              
               //execultar
            stmt.execute();
            
            // fechar conexao
            stmt.close();
            
             JOptionPane.showMessageDialog(null, "Excluido com sucesso!");
             
         } catch (SQLDataException error) {
             throw new RuntimeException(error);
         }
     }
}
        
        
          
         
       

