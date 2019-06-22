/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Conexao;



import java.sql.*;

public class ModuloConexao {

    //metodo responsavel por estabelecer conexao com  banco

    public static Connection conector() {
        java.sql.Connection conexao;
        
        //a linha abaixo 'chama' o driver
        String driver = "com.mysql.jdbc.Driver";
        //Armazenando informacoes referente ao banco
        String url = "jdbc:mysql://127.0.0.1/banco";
        String user = "root";
        String password = "";
        //estabelecendo a conexão co o banco
        try {
            Class.forName(driver);
            conexao = DriverManager.getConnection(url, user, password);
            return conexao;
        } catch (ClassNotFoundException | SQLException e) {
            //System.out.println(e);
            return null;
        }
        

    }

    

}