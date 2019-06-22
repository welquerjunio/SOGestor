/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import JavaBean.Clientes;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import Conexao.ModuloConexao;
import JavaBean.Os;
import java.sql.Connection;
import java.sql.SQLDataException;
import javax.swing.JOptionPane;


/**
 *
 * @author Walleson Moura
 */
public class OsDAO {
    private Connection conecta;
    
    public OsDAO(){
        this.conecta = new ModuloConexao().conector();
    }
    
    //rotinas SQL
    //Metodo Cadastrar cliente
    public void emitirOs(Os emitir) throws SQLException {
        try {
            String cmdsql = "insert into ordemservicos(id, data, garantia, descricao, defeito, status, servico, valor, clientesOs_id, funcionariosOs_id,produtoOs_id, eqpdesc, eqpserie, eqpmodelo, eqpfabri, tipo) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

            //organizar
            PreparedStatement stmt = conecta.prepareStatement(cmdsql);
            stmt.setInt(1, emitir.getId());
            stmt.setString(2, emitir.getData());
            stmt.setString(3, emitir.getGarantia());
            stmt.setString(4, emitir.getDescricao());
            stmt.setString(5, emitir.getDefeito());
            stmt.setString(6, emitir.getStatus());
            stmt.setString(7, emitir.getServico());
            stmt.setFloat(8, emitir.getValor());
            stmt.setInt(9, emitir.getIdCliente());
            stmt.setInt(10, emitir.getIdFuncionario());
            stmt.setInt(11, emitir.getIdProduto());
            stmt.setString(12, emitir.getEqpDesc());
            stmt.setString(13, emitir.getEqpSerie());
            stmt.setString(14, emitir.getEqpModelo());
            stmt.setString(15, emitir.getEqpFabric());
            stmt.setString(16, emitir.getTipoOs());

            //execultar
            stmt.execute();

            // fechar conexao
            stmt.close();
            JOptionPane.showMessageDialog(null, "OS emitida com sucesso!"); 

        } catch (SQLDataException error) {
            JOptionPane.showMessageDialog(null, "Falha ao emitir OS!"); 
            throw new RuntimeException(error);
        }

    }
    
     //metodo de busca 
    public List<Clientes> readForDesc(String desc) throws SQLException {

        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Clientes> clientes = new ArrayList<>();

        try {
            stmt = conecta.prepareStatement("SELECT * FROM ordemservicos WHERE nome LIKE ?");
            stmt.setString(1, "%"+desc + "%");

            rs = stmt.executeQuery();
            while (rs.next()) {

                Clientes cliente = new Clientes();

                cliente.setIdClientes(rs.getInt("id"));
                cliente.setNome(rs.getString("nome"));
                cliente.setTelefone(rs.getString("telefone"));
                //cliente.setCpfCnpj(rs.getString("cpfcnpj"));
                //cliente.setCelular(rs.getString("Celular"));
                //cliente.setEmail(rs.getString("email"));
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
    //Editar OS
    public void updateOs(Os emitir) throws SQLException {
        try {
            String cmdsql = "UPDATE ordemservicos SET garantia =?"
                    + ", descricao =?, defeito=?, status =?, servico =?, valor =?, clientesOs_id =?, funcionariosOs_id =?, produtoOs_id =?, eqpdesc =?, eqpserie=?, eqpmodelo =?, eqpfabri=?, tipo =? "
                    + "WHERE id =?";

            
            
            //organizar
            PreparedStatement stmt = conecta.prepareStatement(cmdsql);
            
            //stmt.setString(2, emitir.getData());
            stmt.setString(1, emitir.getGarantia());
            stmt.setString(2, emitir.getDescricao());
            stmt.setString(3, emitir.getDefeito());
            stmt.setString(4, emitir.getStatus());
            stmt.setString(5, emitir.getServico());
            stmt.setFloat(6, emitir.getValor());
            stmt.setInt(7, emitir.getIdCliente());
            stmt.setInt(8, emitir.getIdFuncionario());
            stmt.setInt(9, emitir.getIdProduto());
            stmt.setString(10, emitir.getEqpDesc());
            stmt.setString(11, emitir.getEqpSerie());
            stmt.setString(12, emitir.getEqpModelo());
            stmt.setString(13, emitir.getEqpFabric());
            stmt.setString(14, emitir.getTipoOs());
            stmt.setInt(15, emitir.getId());

            //execultar
            stmt.execute();

            // fechar conexao
            stmt.close();
            JOptionPane.showMessageDialog(null, "OS emitida com sucesso!"); 

        } catch (SQLDataException error) {
            JOptionPane.showMessageDialog(null, "Falha ao emitir OS!"); 
            throw new RuntimeException(error);
        }

    }
    //deletar produtos da tabela
      public void delete(Os cadastrar) throws SQLException{
         try {
             String cmdsql = "DELETE FROM ordemservicos WHERE id = ?"; 
             
             //organizar
             
              PreparedStatement stmt = conecta.prepareStatement(cmdsql);

              stmt.setInt(1,cadastrar.getId());
              
               //execultar
            stmt.execute();
            
            // fechar conexao
            stmt.close();
            
             JOptionPane.showMessageDialog(null, "Excluido com sucesso!");
             
         } catch (SQLDataException error) {
            JOptionPane.showMessageDialog(null, error);
            JOptionPane.showMessageDialog(null, "Falha ao Excluir!");
         }
     }
    
}
