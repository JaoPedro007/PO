/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author João Pedro
 */
public class VendaModelo {

    public VendaModelo(String codigo, String descricao, String valorVenda) {
        this.codigo = codigo;
        this.descricao = descricao;
        this.valorVenda = valorVenda;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

     public String getValorVenda() {
        return valorVenda;
    }

    public void setValorVenda(String valorVenda) {
        this.valorVenda = valorVenda;
    }

    @Override
    public String toString() {
        return "VendaModelo{" + "codigo=" + codigo + ", descricao=" + descricao + ", valorVenda=" + valorVenda + '}';
    }
    
    String codigo;
    String descricao;
    String valorVenda;

    
}
