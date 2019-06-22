/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;
import Conexao.ModuloConexao;
import static Conexao.ModuloConexao.conector;
import JavaBean.Produto;
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
 * @author Walleson Moura
 */
public class ProdutosDAO {
    private Connection conecta;
    
     public ProdutosDAO(){
        this.conecta = new ModuloConexao().conector();
    }
     
     //rotinas
     //cadastrar produto
     public void cadastrarProduto(Produto cadastrar) throws SQLException{
         try {
             String cmdsql = "insert into produto(id, descricao, precoCompra, precoVenda, quantidade, fornecedor) values (?, ?, ?, ?, ?, ?)"; 
             
             //organizar
             
              PreparedStatement stmt = conecta.prepareStatement(cmdsql);
              stmt.setInt(1,cadastrar.getIdproduto());
              stmt.setString(2, cadastrar.getDescricao());
              stmt.setFloat(3, cadastrar.getPrecoCompra());
              stmt.setFloat(4, cadastrar.getPrecoVenda());
              stmt.setInt(5, cadastrar.getQuantidade());
              stmt.setString(6, cadastrar.getFornecedor());
              
               //execultar
            stmt.execute();
            
            // fechar conexao
            stmt.close();
            
            
             
         } catch (SQLDataException error) {
             throw new RuntimeException(error);
         }
     }
     //listar produtos a tabela
     
     public List<Produto> read() throws SQLException{
         
          PreparedStatement stmt = null;
          ResultSet rs = null;
          List<Produto> produtos = new ArrayList<>();
          
        try {
            stmt = conecta.prepareStatement("SELECT * FROM produto");
           
            rs = stmt.executeQuery();
            while (rs.next()) {
                 
                
                Produto produto = new Produto();
              
                produto.setIdproduto(rs.getInt("id"));
                produto.setDescricao(rs.getString("descricao"));
                produto.setPrecoCompra(rs.getFloat("precoCompra"));
                produto.setPrecoVenda(rs.getFloat("precoVenda"));
                produto.setQuantidade(rs.getInt("quantidade"));
                produto.setFornecedor(rs.getString("fornecedor"));
                produtos.add(produto);
                
                
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProdutosDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            stmt.close();
            rs.close();
           
        }
        return produtos;
         
         
         
     }
     //alterar produtos da tabela
      public void update(Produto cadastrar) throws SQLException{
         try {
             String cmdsql = "UPDATE produto SET descricao = ?, precoCompra=?, precoVenda=?, quantidade=?, fornecedor=? WHERE id = ?"; 
             
             //organizar
             
              PreparedStatement stmt = conecta.prepareStatement(cmdsql);
              
              stmt.setString(1, cadastrar.getDescricao());
              stmt.setFloat(2, cadastrar.getPrecoCompra());
              stmt.setFloat(3, cadastrar.getPrecoVenda());
              stmt.setInt(4, cadastrar.getQuantidade());
              stmt.setString(5, cadastrar.getFornecedor());
              stmt.setInt(6,cadastrar.getIdproduto());
              
               //execultar
            stmt.execute();
            
            // fechar conexao
            stmt.close();
            
            JOptionPane.showMessageDialog(null, "Editado com sucesso!");
             
         } catch (SQLDataException error) {
             throw new RuntimeException(error);
         }
     }
      //deletar produtos da tabela
      public void delete(Produto cadastrar) throws SQLException{
         try {
             String cmdsql = "DELETE FROM produto WHERE id = ?"; 
             
             //organizar
             
              PreparedStatement stmt = conecta.prepareStatement(cmdsql);

              stmt.setInt(1,cadastrar.getIdproduto());
              
               //execultar
            stmt.execute();
            
            // fechar conexao
            stmt.close();
            
             JOptionPane.showMessageDialog(null, "Excluido com sucesso!");
             
         } catch (SQLDataException error) {
             throw new RuntimeException(error);
         }
     }
      
     //Consulta Nome Fornecedor  
      public void mostrarFornecedor ()throws SQLException {
          PreparedStatement stmt = null;
          ResultSet rs = null;
          try {
              stmt = conecta.prepareStatement("SELECT nome FROM fornecedor order by nome");
           
            rs = stmt.executeQuery();
          while (rs.next()) {
             //jbCadFornecedorFornecedor.addItem(rs.getString(1));
                //lucas 
                //jComboBox1.addItem(rs.getString(1)+ " " +rs.getString(1));
                
            }
          }catch (SQLException ex) {
            Logger.getLogger(ProdutosDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            stmt.close();
            rs.close();
           
        }
          
        // Exemplo de comunicaçao LUCAS
         /* Statement st=con.createStatement();
          ResultSet rs= st.executeQuery("select nome from clientes;");
          jComboBox1.removeAllItems();
          while(rs.next()){
              jComboBox1.addItem(rs.getString(1));
          }
                 
         */        
      }      
      
}
