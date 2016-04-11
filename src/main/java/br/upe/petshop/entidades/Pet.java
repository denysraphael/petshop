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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 *
 * @author -Denys
 */
@Entity
public class Pet implements Serializable{
    private Long codigo;
    private String nome;
    private ClassificacaoPet classificacao;
    private Raca raca;
    private Cliente dono;
    private List<Servico> servicos;
    private boolean ativo;

    public Pet() {
    }

    public Pet(String nome, ClassificacaoPet classificacao, Raca raca, String tamanho) {
        this.nome = nome;
        this.classificacao = classificacao;
        this.raca = raca;
        this.ativo = true;
    }

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @ManyToOne (fetch = FetchType.EAGER)
    public ClassificacaoPet getClassificacao() {
        return classificacao;
    }

    public void setClassificacao(ClassificacaoPet classificacao) {
        this.classificacao = classificacao;
    }

    @ManyToOne (fetch = FetchType.EAGER)
    public Raca getRaca() {
        return raca;
    }

    public void setRaca(Raca raca) {
        this.raca = raca;
    }

    @ManyToOne (fetch = FetchType.EAGER)
    public Cliente getDono() {
        return dono;
    }

    public void setDono(Cliente dono) {
        this.dono = dono;
    }

    @OneToMany (fetch = FetchType.EAGER,mappedBy = "pet")
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

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.codigo);
        hash = 97 * hash + Objects.hashCode(this.nome);
        hash = 97 * hash + Objects.hashCode(this.classificacao);
        hash = 97 * hash + Objects.hashCode(this.raca);
        hash = 97 * hash + Objects.hashCode(this.dono);
        hash = 97 * hash + Objects.hashCode(this.servicos);
        hash = 97 * hash + (this.ativo ? 1 : 0);
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
        final Pet other = (Pet) obj;
        if (!Objects.equals(this.codigo, other.codigo)) {
            return false;
        }
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        if (!Objects.equals(this.classificacao, other.classificacao)) {
            return false;
        }
        if (!Objects.equals(this.raca, other.raca)) {
            return false;
        }
        if (!Objects.equals(this.dono, other.dono)) {
            return false;
        }
        if (!Objects.equals(this.servicos, other.servicos)) {
            return false;
        }
        if (this.ativo != other.ativo) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Pet{" + "codigo=" + codigo + ", nome=" + nome + ", classificacao=" + classificacao + ", raca=" + raca + ", dono=" + dono + ", servicos=" + servicos + ", ativo=" + ativo + '}';
    }
}
