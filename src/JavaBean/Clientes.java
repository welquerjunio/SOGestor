/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JavaBean;

import java.sql.Date;

/**
 *
 * @author wramu
 */
public class Clientes {
    //atributos
    private int idClientes;
    private String nome;
    private String cpfCnpj;
    private String telefone;
    private String celular;
    private String email;
    private String endereco;
    private String setor;
    private String cidade;
    private String cep;
    private String estado;
    private String datacadastro;

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }
    
    public String getDatacadastro() {
        return datacadastro;
    }

    public void setDatacadastro(String datacadastro) {
        this.datacadastro = datacadastro;
    }
    
    //getters and setters
 
    public int getIdClientes() {
        return idClientes;
    }


    public String getNome() {
        return nome;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getCpfCnpj() {
        return cpfCnpj;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCelular() {
        return celular;
    }

    public String getEndereco() {
        return endereco;
    }

    public String getSetor() {
        return setor;
    }

    public String getEstado() {
        return estado;
    }

    public void setIdClientes(int idClientes) {
       this.idClientes = idClientes;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCpfCnpj(String cpfCnpj) {
        this.cpfCnpj = cpfCnpj;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public void setSetor(String setor) {
        this.setor = setor;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    
    
    
    
}
