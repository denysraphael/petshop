/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.upe.petshop.listar;

import br.upe.petshop.entidades.Compra;
import br.upe.petshop.entidades.Pet;
import java.util.List;

/**
 *
 * @author -Denys
 */
public class ClienteListar {
    private String cpf;
    private String nome;
    private String endereco;
    private String telefone;
    private List<String> pets;
    private List<String> compras;
    private boolean ativo;
    private String senha;

    public ClienteListar() {
    }

    public ClienteListar(String cpf, String nome, String endereco, String telefone, List<String> pets, List<String> compras, boolean ativo, String senha) {
        this.cpf = cpf;
        this.nome = nome;
        this.endereco = endereco;
        this.telefone = telefone;
        this.pets = pets;
        this.compras = compras;
        this.ativo = ativo;
        this.senha = senha;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public List<String> getPets() {
        return pets;
    }

    public void setPets(List<String> pets) {
        this.pets = pets;
    }

    public List<String> getCompras() {
        return compras;
    }

    public void setCompras(List<String> compras) {
        this.compras = compras;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
