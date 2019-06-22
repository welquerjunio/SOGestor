/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Conexao.ModuloConexao;
import JavaBean.Fornecedor;
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
public class FornecedorDAO {
    
    private Connection conecta;
    
    public FornecedorDAO(){
        this.conecta = new ModuloConexao().conector();
    }
   
    //rotinas SQL
    //Metodo Cadastrar funcionario
    public void cadastrarFornecedor(Fornecedor cadastrar) throws SQLException {
        try {
            String cmdsql = "insert into fornecedor(id, nome, nomefantasia, cnpj, inestadual, bairro, cidade, cep, endereco, estado, email, telefone, dataCadastro) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

            //13 colunas
            PreparedStatement stmt = conecta.prepareStatement(cmdsql);
            stmt.setInt(1, cadastrar.getId());
            stmt.setString(2, cadastrar.getNome());
            stmt.setString(3, cadastrar.getNomeFantasia());
            stmt.setString(4, cadastrar.getCnpj());
            stmt.setString(5, cadastrar.getInEstadual());
            stmt.setString(6, cadastrar.getBairro());
            stmt.setString(7, cadastrar.getCidade());
            stmt.setString(8, cadastrar.getCep());
            stmt.setString(9, cadastrar.getEndereco());
            stmt.setString(10, cadastrar.getEstado());
            stmt.setString(11, cadastrar.getEmail());
            stmt.setString(12, cadastrar.getTelefone());
            stmt.setString(13, cadastrar.getDataCadastro());
            //execultar
            stmt.execute();

            //fechar conexao
            stmt.close();

        } catch (SQLDataException error) {
            throw new RuntimeException(error);
        }
    }
    //metodo de busca 
      public List<Fornecedor> readForDesc(String desc) throws SQLException{
         
          PreparedStatement stmt = null;
          ResultSet rs = null;
          List<Fornecedor> forncedors = new ArrayList<>();
          
        try {
            stmt = conecta.prepareStatement("SELECT * FROM fornecedor WHERE nome LIKE ?");
            stmt.setString(1, "%"+desc+"%");
           
            rs = stmt.executeQuery();
            while (rs.next()) {
                 
                
                Fornecedor fornecedor = new Fornecedor();
              
                fornecedor.setId(rs.getInt("id"));
                fornecedor.setNome(rs.getString("nome"));
                fornecedor.setCnpj(rs.getString("cnpj"));
                fornecedor.setTelefone(rs.getString("Telefone"));
                //cliente.setCelular(rs.getString("Celular"));
                fornecedor.setEmail(rs.getString("email"));
                //cliente.setEndereco(rs.getString("endereco"));
                //cliente.setSetor(rs.getString("bairro"));
                //cliente.setCidade(rs.getString("cidade"));
                //cliente.setCep(rs.getString("cep"));
               // cliente.setEstado(rs.getString("estado"));
                //cliente.setDatacadastro(rs.getDate("dataCadastro"));
                
                forncedors.add(fornecedor);
                
                
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProdutosDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            stmt.close();
            rs.close();
           
        }
        return forncedors;
         
}
       public void update(Fornecedor alterar) throws SQLException {
        try {
            String cmdsql = "UPDATE fornecedor SET nome = ?, nomefantasia=?, cnpj= ?, inestadual = ?, bairro=?, cidade=?, cep=?, endereco=?, estado=?, email=?, telefone=?, datacadastro=? WHERE id = ?";

            //organizar
            
            PreparedStatement stmt = conecta.prepareStatement(cmdsql);
            stmt.setInt(13, alterar.getId());
            stmt.setString(1, alterar.getNome());
            stmt.setString(2, alterar.getNomeFantasia());
            stmt.setString(2, alterar.getCnpj());
            stmt.setString(4, alterar.getInEstadual());
            stmt.setString(5, alterar.getBairro());
            stmt.setString(6, alterar.getCidade());
            stmt.setString(7, alterar.getCep());
            stmt.setString(8, alterar.getEndereco());
            stmt.setString(9, alterar.getEstado());
            stmt.setString(10, alterar.getEmail());
            stmt.setString(11, alterar.getTelefone());
            stmt.setString(12, alterar.getDataCadastro());
            

            //execultar
            stmt.execute();

            // fechar conexao
            stmt.close();

            

        } catch (SQLDataException error) {
            JOptionPane.showMessageDialog(null,error);
        }

    }
        //deletar produtos da tabela
      public void delete(Fornecedor deletar) throws SQLException{
         try {
             String cmdsql = "DELETE FROM fornecedor WHERE id = ?"; 
             
             //organizar
             
              PreparedStatement stmt = conecta.prepareStatement(cmdsql);

              stmt.setInt(1,deletar.getId());
              
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
