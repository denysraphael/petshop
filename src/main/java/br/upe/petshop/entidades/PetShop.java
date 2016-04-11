/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.upe.petshop.entidades;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 *
 * @author -Denys
 */
@Entity
public class PetShop implements Serializable{
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
    private List<Servico> servicos;
    private boolean ativo;
    private String senha;

    public PetShop() {
    }

    public PetShop(String cnpj, String nome, String endereco, String telefone, String senha) {
        this.cnpj = cnpj;
        this.nome = nome;
        this.endereco = endereco;
        this.telefone = telefone;
        this.banho = false;
        this.banhoHidratacao = false;
        this.tosaHigienica = false;
        this.tosaBebe = false;
        this.tosaRaca = false;
        this.consulta = false;
        this.busca = false;
        this.ativo = true;
        this.senha = senha;
    }
    
    @Id
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

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "petShop")
    public List<Servico> getServicos() {
        return servicos;
    }

    public void setServicos(List<Servico> servicos) {
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

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 23 * hash + Objects.hashCode(this.cnpj);
        hash = 23 * hash + Objects.hashCode(this.nome);
        hash = 23 * hash + Objects.hashCode(this.endereco);
        hash = 23 * hash + Objects.hashCode(this.telefone);
        hash = 23 * hash + (this.banho ? 1 : 0);
        hash = 23 * hash + (this.banhoHidratacao ? 1 : 0);
        hash = 23 * hash + (this.tosaHigienica ? 1 : 0);
        hash = 23 * hash + (this.tosaBebe ? 1 : 0);
        hash = 23 * hash + (this.tosaRaca ? 1 : 0);
        hash = 23 * hash + (this.consulta ? 1 : 0);
        hash = 23 * hash + (this.busca ? 1 : 0);
        hash = 23 * hash + Objects.hashCode(this.servicos);
        hash = 23 * hash + (this.ativo ? 1 : 0);
        hash = 23 * hash + Objects.hashCode(this.senha);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final PetShop other = (PetShop) obj;
        if (!Objects.equals(this.cnpj, other.cnpj)) {
            return false;
        }
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        if (!Objects.equals(this.endereco, other.endereco)) {
            return false;
        }
        if (!Objects.equals(this.telefone, other.telefone)) {
            return false;
        }
        if (this.banho != other.banho) {
            return false;
        }
        if (this.banhoHidratacao != other.banhoHidratacao) {
            return false;
        }
        if (this.tosaHigienica != other.tosaHigienica) {
            return false;
        }
        if (this.tosaBebe != other.tosaBebe) {
            return false;
        }
        if (this.tosaRaca != other.tosaRaca) {
            return false;
        }
        if (this.consulta != other.consulta) {
            return false;
        }
        if (this.busca != other.busca) {
            return false;
        }
        if (!Objects.equals(this.servicos, other.servicos)) {
            return false;
        }
        if (this.ativo != other.ativo) {
            return false;
        }
        if (!Objects.equals(this.senha, other.senha)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "PetShop{" + "cnpj=" + cnpj + ", nome=" + nome + ", endereco=" + endereco + ", telefone=" + telefone + ", banho=" + banho + ", banhoHidratacao=" + banhoHidratacao + ", tosaHigienica=" + tosaHigienica + ", tosaBebe=" + tosaBebe + ", tosaRaca=" + tosaRaca + ", consulta=" + consulta + ", busca=" + busca + ", servicos=" + servicos + ", ativo=" + ativo + ", senha=" + senha + '}';
    }
}
