/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JavaBean;

import javax.swing.JTextField;

/**
 *
 * @author Walleson Moura
 */
public class Os {

    private int id;
    private String data;
    private String tipoOs;
    private String status;
    private String nomeCliente;
    private int idCliente;
    private int idFuncionario;
    private int idProduto;
    private String eqpDesc;
    private String eqpSerie;
    private String eqpModelo;
    private String eqpFabric;
    private String defeito;
    private String servico;
    private String descricao;
    private float valor;
    private String garantia;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getTipoOs() {
        return tipoOs;
    }

    public void setTipoOs(String tipoOs) {
        this.tipoOs = tipoOs;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public int getIdFuncionario() {
        return idFuncionario;
    }

    public void setIdFuncionario(int idFuncionario) {
        this.idFuncionario = idFuncionario;
    }

    public int getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(int idProduto) {
        this.idProduto = idProduto;
    }
    
    public String getEqpDesc() {
        return eqpDesc;
    }

    public void setEqpDesc(String eqpDesc) {
        this.eqpDesc = eqpDesc;
    }

    public String getEqpSerie() {
        return eqpSerie;
    }

    public void setEqpSerie(String eqpSerie) {
        this.eqpSerie = eqpSerie;
    }

    public String getEqpModelo() {
        return eqpModelo;
    }

    public void setEqpModelo(String eqpModelo) {
        this.eqpModelo = eqpModelo;
    }

    public String getEqpFabric() {
        return eqpFabric;
    }

    public void setEqpFabric(String eqpFabric) {
        this.eqpFabric = eqpFabric;
    }

    public String getDefeito() {
        return defeito;
    }

    public void setDefeito(String defeito) {
        this.defeito = defeito;
    }

    public String getServico() {
        return servico;
    }

    public void setServico(String servico) {
        this.servico = servico;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    public String getGarantia() {
        return garantia;
    }

    public void setGarantia(String garantia) {
        this.garantia = garantia;
    }

    public void setId(JTextField txtTelaOSNumOS) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

   

}
