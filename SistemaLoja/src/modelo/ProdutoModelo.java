/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.util.Objects;

/**
 *
 * @author João Pedro
 */
public class ProdutoModelo {

    public ProdutoModelo() {
    }

    public ProdutoModelo(String descricao,String codigo, String quantidade, String valorCusto, String valorVenda, String departamento, String marca) {
        this.codigo = codigo;
        this.descricao = descricao;
        this.quantidade = quantidade;
        this.valorCusto = valorCusto;
        this.valorVenda = valorVenda;
        this.departamento = departamento;
        this.marca = marca;
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

    public String getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(String quantidade) {
        this.quantidade = quantidade;
    }

    public String getValorCusto() {
        return valorCusto;
    }

    public void setValorCusto(String valorCusto) {
        this.valorCusto = valorCusto;
    }

    public String getValorVenda() {
        return valorVenda;
    }

    public void setValorVenda(String valorVenda) {
        this.valorVenda = valorVenda;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    String codigo;
    String descricao;
    String quantidade;
    String valorCusto;
    String valorVenda;
    String departamento;
    String marca;

}
