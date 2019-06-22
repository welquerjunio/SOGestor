/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Conexao.ModuloConexao;
import JavaBean.Clientes;
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
public class ClientesDAO {
    private Connection conecta;
    
    public ClientesDAO(){
        this.conecta = new ModuloConexao().conector();
    }
    
    //rotinas SQL
    //Metodo Cadastrar cliente
    public void cadastrarCliente(Clientes cadastrar) throws SQLException {
        try {
            String cmdsql = "insert into clientes(id, nome, email, dataCadastro, endereco, bairro, cidade, estado, cep, cpfcnpj,Celular, Telefone) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

            //organizar
            PreparedStatement stmt = conecta.prepareStatement(cmdsql);
            stmt.setInt(1, cadastrar.getIdClientes());
            stmt.setString(2, cadastrar.getNome());
            stmt.setString(3, cadastrar.getEmail());
            stmt.setString(4, cadastrar.getDatacadastro());
            stmt.setString(5, cadastrar.getEndereco());
            stmt.setString(6, cadastrar.getSetor());
            stmt.setString(7, cadastrar.getCidade());
            stmt.setString(8, cadastrar.getEstado());
            stmt.setString(9, cadastrar.getCep());
            stmt.setString(10, cadastrar.getCpfCnpj());
            stmt.setString(11, cadastrar.getCelular());
            stmt.setString(12, cadastrar.getTelefone());

            //execultar
            stmt.execute();

            // fechar conexao
            stmt.close();

        } catch (SQLDataException error) {

            throw new RuntimeException(error);
        }

    }

    //metodo de busca 
    public List<Clientes> readForDesc(String desc) throws SQLException {

        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Clientes> clientes = new ArrayList<>();

        try {
            stmt = conecta.prepareStatement("SELECT * FROM clientes WHERE nome LIKE ?");
            stmt.setString(1, "%" + desc + "%");

            rs = stmt.executeQuery();
            while (rs.next()) {

                Clientes cliente = new Clientes();

                cliente.setIdClientes(rs.getInt("id"));
                cliente.setNome(rs.getString("nome"));
                cliente.setCpfCnpj(rs.getString("cpfcnpj"));
                cliente.setTelefone(rs.getString("telefone"));
                //cliente.setCelular(rs.getString("Celular"));
                cliente.setEmail(rs.getString("email"));
                //cliente.setEndereco(rs.getString("endereco"));
                //cliente.setSetor(rs.getString("bairro"));
                //cliente.setCidade(rs.getString("cidade"));
                //cliente.setCep(rs.getString("cep"));
                // cliente.setEstado(rs.getString("estado"));
                //cliente.setDatacadastro(rs.getDate("dataCadastro"));

                clientes.add(cliente);

            }
        } catch (SQLException ex) {
            Logger.getLogger(ProdutosDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            stmt.close();
            rs.close();

        }
        return clientes;

    }
      public void update(Clientes alterar) throws SQLException {
        try {
            String cmdsql = "UPDATE clientes SET nome = ?, email=?, dataCadastro= ?, endereco = ?, bairro=?, cidade=?, estado=?, cep=?, cpfcnpj=?, Celular=?, Telefone=? WHERE id = ?";

            //organizar
            
            PreparedStatement stmt = conecta.prepareStatement(cmdsql);
            stmt.setInt(12, alterar.getIdClientes());
            stmt.setString(1, alterar.getNome());
            stmt.setString(2, alterar.getEmail());
            stmt.setString(3,alterar.getDatacadastro());
            stmt.setString(4, alterar.getEndereco());
            stmt.setString(5, alterar.getSetor());
            stmt.setString(6, alterar.getCidade());
            stmt.setString(7, alterar.getEstado());
            stmt.setString(8, alterar.getCep());
            stmt.setString(9, alterar.getCpfCnpj());
            stmt.setString(10, alterar.getCelular());
            stmt.setString(11, alterar.getTelefone());
            

            //executar
            stmt.execute();

            // fechar conexao
            stmt.close();

            JOptionPane.showMessageDialog(null, "Editado com sucesso!");

        } catch (SQLDataException error) {
            JOptionPane.showMessageDialog(null,error);
        }

    }
      //deletar produtos da tabela
      public void delete(Clientes deletar) throws SQLException{
         try {
             String cmdsql = "DELETE FROM clientes WHERE id = ?"; 
             
             //organizar
             
              PreparedStatement stmt = conecta.prepareStatement(cmdsql);

              stmt.setInt(1,deletar.getIdClientes());
              
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
