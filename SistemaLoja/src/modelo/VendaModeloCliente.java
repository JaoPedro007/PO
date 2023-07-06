/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author João Pedro
 */
public class VendaModeloCliente {

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpfCnpj() {
        return cpfCnpj;
    }

    public void setCpfCnpj(String cpfCnpj) {
        this.cpfCnpj = cpfCnpj;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }


    public VendaModeloCliente(String nome, String cpfCnpj, String telefone) {
        this.nome = nome;
        this.cpfCnpj = cpfCnpj;
        this.telefone = telefone;
    }

    @Override
    public String toString() {
        return "VendaModeloCliente{" + "nome=" + nome + ", cpfCnpj=" + cpfCnpj + ", telefone=" + telefone + '}';
    }

    String nome;
    String cpfCnpj;
    String telefone;


    
}
