/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Conexao.ModuloConexao;
import JavaBean.Funcionario;
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
public class FuncionarioDAO {
    private Connection conecta;
    
    public FuncionarioDAO(){
        this.conecta = new ModuloConexao().conector();
    }
    
     //rotinas SQL
    //Metodo Cadastrar funcionario
    public void cadastrarFuncionario(Funcionario cadastrar) throws SQLException{
        try {
            String cmdsql= "insert into funcionarios(id, nome, rg, cpf, endereco, bairro, cidade, estado, email, dataCadastro, Salario, Formacao, Cargo, CTPS, NCarteTraba, cep, Celular, Telefone) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?,?, ?, ?)";
            
            
            //16 colunas
            PreparedStatement stmt = conecta.prepareStatement(cmdsql);
            stmt.setInt(1, cadastrar.getIdfuncionario());
            stmt.setString(2, cadastrar.getNome());
            stmt.setString(3, cadastrar.getRg());
            stmt.setString(4, cadastrar.getCpf());
            stmt.setString(5, cadastrar.getEndereco());
            stmt.setString(6, cadastrar.getBairro());
            stmt.setString(7, cadastrar.getCidade());
            stmt.setString(8, cadastrar.getEstado());
            stmt.setString(9, cadastrar.getEmail());
            stmt.setString(10, cadastrar.getDataCadastro());
            stmt.setString(11, cadastrar.getSalario());
            stmt.setString(12, cadastrar.getFormacao());
            stmt.setString(13, cadastrar.getCargo());
            stmt.setString(14, cadastrar.getCtps());
            stmt.setString(15, cadastrar.getNCarteTraba());
            stmt.setString(16, cadastrar.getCep());
            stmt.setString(17, cadastrar.getCelular());
            stmt.setString(18, cadastrar.getTelefone());
             //execultar
            stmt.execute();
            
            //fechar conexao
            stmt.close();
            
            
            
            
        } catch (SQLDataException error) {
            throw new RuntimeException(error);
        }
    }
    //metodo de busca 
      public List<Funcionario> readForDesc(String desc) throws SQLException{
         
          PreparedStatement stmt = null;
          ResultSet rs = null;
          List<Funcionario> funcionarios = new ArrayList<>();
          
        try {
            stmt = conecta.prepareStatement("SELECT * FROM funcionarios WHERE nome LIKE ?");
            stmt.setString(1, "%"+desc+"%");
           
            rs = stmt.executeQuery();
            while (rs.next()) {
                 
                
                Funcionario funcionario = new Funcionario();
           
                funcionario.setIdfuncionario(rs.getInt("id"));
                funcionario.setNome(rs.getString("nome"));
                funcionario.setCpf(rs.getString("cpf"));
                funcionario.setCelular(rs.getString("Celular"));
                funcionario.setEmail(rs.getString("email"));
                
                funcionarios.add(funcionario);
                
                
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProdutosDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            stmt.close();
            rs.close();
           
        }
        return funcionarios;
         
}
      public void update(Funcionario alterar) throws SQLException {
        try {
            String cmdsql = "UPDATE funcionarios SET nome = ?, rg=?, cpf= ?, endereco = ?, bairro=?, cidade=?, estado=?, email=?, Salario=?, Formacao=?, Cargo=?, CTPS=?, NCarteTraba=?, CEP=?, Celular=?, Telefone=? WHERE id = ?";

            //organizar
            PreparedStatement stmt = conecta.prepareStatement(cmdsql);

            stmt.setString(1, alterar.getNome());
            stmt.setString(2, alterar.getRg());
            stmt.setString(3, alterar.getCpf());
            stmt.setString(4, alterar.getEndereco());
            stmt.setString(5, alterar.getBairro());
            stmt.setString(6, alterar.getCidade());
            stmt.setString(7, alterar.getEstado());
            stmt.setString(8, alterar.getEmail());
            stmt.setString(9, alterar.getSalario());
            stmt.setString(10, alterar.getFormacao());
            stmt.setString(11, alterar.getCargo());
            stmt.setString(12, alterar.getCtps());
            stmt.setString(13, alterar.getNCarteTraba());
            stmt.setString(14, alterar.getCep());
            stmt.setString(15, alterar.getCelular());
            stmt.setString(16, alterar.getTelefone());
            stmt.setInt(17, alterar.getIdfuncionario());
            

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
      public void delete(Funcionario deletar) throws SQLException{
         try {
             String cmdsql = "DELETE FROM funcionarios WHERE id = ?"; 
             
             //organizar
             
              PreparedStatement stmt = conecta.prepareStatement(cmdsql);

              stmt.setInt(1,deletar.getIdfuncionario());
              
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
