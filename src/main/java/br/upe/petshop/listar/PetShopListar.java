/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.upe.petshop.listar;

import br.upe.petshop.entidades.Servico;
import java.util.List;

/**
 *
 * @author -Denys
 */
public class PetShopListar {
    private String cnpj;
    private String nome;
    private String endereco;
    private String telefone;
    private boolean banho;
    private boolean banhoHidratacao;
    private boolean tosaHigienica;
    private boolean tosaBebe;
    private boolean tosaRaca;
    private boolean consulta;
    private boolean busca;
    private List<String> servicos;
    private boolean ativo;
    private String senha;

    public PetShopListar(String cnpj, String nome, String endereco, String telefone, boolean banho, boolean banhoHidratacao, boolean tosaHigienica, boolean tosaBebe, boolean tosaRaca, boolean consulta, boolean busca, List<String> servicos, boolean ativo, String senha) {
        this.cnpj = cnpj;
        this.nome = nome;
        this.endereco = endereco;
        this.telefone = telefone;
        this.banho = banho;
        this.banhoHidratacao = banhoHidratacao;
        this.tosaHigienica = tosaHigienica;
        this.tosaBebe = tosaBebe;
        this.tosaRaca = tosaRaca;
        this.consulta = consulta;
        this.busca = busca;
        this.servicos = servicos;
        this.ativo = ativo;
        this.senha = senha;
    }

    public PetShopListar() {
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
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

    public boolean isBanho() {
        return banho;
    }

    public void setBanho(boolean banho) {
        this.banho = banho;
    }

    public boolean isBanhoHidratacao() {
        return banhoHidratacao;
    }

    public void setBanhoHidratacao(boolean banhoHidratacao) {
        this.banhoHidratacao = banhoHidratacao;
    }

    public boolean isTosaHigienica() {
        return tosaHigienica;
    }

    public void setTosaHigienica(boolean tosaHigienica) {
        this.tosaHigienica = tosaHigienica;
    }

    public boolean isTosaBebe() {
        return tosaBebe;
    }

    public void setTosaBebe(boolean tosaBebe) {
        this.tosaBebe = tosaBebe;
    }

    public boolean isTosaRaca() {
        return tosaRaca;
    }

    public void setTosaRaca(boolean tosaRaca) {
        this.tosaRaca = tosaRaca;
    }

    public boolean isConsulta() {
        return consulta;
    }

    public void setConsulta(boolean consulta) {
        this.consulta = consulta;
    }

    public boolean isBusca() {
        return busca;
    }

    public void setBusca(boolean busca) {
        this.busca = busca;
    }

    public List<String> getServicos() {
        return servicos;
    }

    public void setServicos(List<String> servicos) {
        this.servicos = servicos;
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
