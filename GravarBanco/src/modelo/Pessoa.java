/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.util.Objects;

/**
 *
 * @author aluno
 */
public class Pessoa {
    private String nome;
    private String sexo;
    private String endereco;
    private String cep;
    private String bairro;
    private String cpf;
    private String nascimento;
    private String dataVencimento;
    private String unidadeConsumidora;
    private String email;
    private int kwh;
    private int valorTotal;
    
    
    
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 19 * hash + Objects.hashCode(this.nome);
        hash = 19 * hash + Objects.hashCode(this.sexo);
        hash = 19 * hash + Objects.hashCode(this.endereco);
        hash = 19 * hash + Objects.hashCode(this.cep);
        hash = 19 * hash + Objects.hashCode(this.bairro);
        hash = 19 * hash + Objects.hashCode(this.cpf);
        hash = 19 * hash + Objects.hashCode(this.nascimento);
        hash = 19 * hash + Objects.hashCode(this.dataVencimento);
        hash = 19 * hash + Objects.hashCode(this.unidadeConsumidora);
        hash = 19 * hash + Objects.hashCode(this.email);
        hash = 19 * hash + this.kwh;
        hash = 19 * hash + this.valorTotal;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Pessoa other = (Pessoa) obj;
        if (this.kwh != other.kwh) {
            return false;
        }
        if (this.valorTotal != other.valorTotal) {
            return false;
        }
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        if (!Objects.equals(this.sexo, other.sexo)) {
            return false;
        }
        if (!Objects.equals(this.endereco, other.endereco)) {
            return false;
        }
        if (!Objects.equals(this.cep, other.cep)) {
            return false;
        }
        if (!Objects.equals(this.bairro, other.bairro)) {
            return false;
        }
        if (!Objects.equals(this.cpf, other.cpf)) {
            return false;
        }
        if (!Objects.equals(this.nascimento, other.nascimento)) {
            return false;
        }
        if (!Objects.equals(this.dataVencimento, other.dataVencimento)) {
            return false;
        }
        if (!Objects.equals(this.unidadeConsumidora, other.unidadeConsumidora)) {
            return false;
        }
        return Objects.equals(this.email, other.email);
    }

    
    public String getNome() {
        return nome;
    }

    public String getSexo() {
        return sexo;
    }

    public String getEndereco() {
        return endereco;
    }

    public String getCep() {
        return cep;
    }

    public String getBairro() {
        return bairro;
    }

    public String getCpf() {
        return cpf;
    }

    public String getNascimento() {
        return nascimento;
    }

    public String getDataVencimento() {
        return dataVencimento;
    }

    public String getUnidadeConsumidora() {
        return unidadeConsumidora;
    }

    public String getEmail() {
        return email;
    }

    public int getKwh() {
        return kwh;
    }

    public int getValorTotal() {
        return valorTotal;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setNascimento(String nascimento) {
        this.nascimento = nascimento;
    }

    public void setDataVencimento(String dataVencimento) {
        this.dataVencimento = dataVencimento;
    }

    public void setUnidadeConsumidora(String unidadeConsumidora) {
        this.unidadeConsumidora = unidadeConsumidora;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setKwh(int kwh) {
        this.kwh = kwh;
    }

    public void setValorTotal(int valorTotal) {
        this.valorTotal = valorTotal;
    }

    public Pessoa(String nome, String sexo, String endereco, String cep, String bairro, String cpf, String nascimento, String dataVencimento, String unidadeConsumidora, String email, int kwh, int valorTotal) {
        this.nome = nome;
        this.sexo = sexo;
        this.endereco = endereco;
        this.cep = cep;
        this.bairro = bairro;
        this.cpf = cpf;
        this.nascimento = nascimento;
        this.dataVencimento = dataVencimento;
        this.unidadeConsumidora = unidadeConsumidora;
        this.email = email;
        this.kwh = kwh;
        this.valorTotal = valorTotal;
    }
    

    
    
}
