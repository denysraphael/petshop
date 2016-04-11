/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.upe.petshop.entidades;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
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
public class Raca {
    private Long Codigo;
    private String descricao;
    private ClassificacaoPet classificacao;
    private List<Pet> pets;

    public Raca(String descricao) {
        this.descricao = descricao;
        this.pets = new ArrayList<Pet>();
    }

    public Raca() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getCodigo() {
        return Codigo;
    }

    public void setCodigo(Long Codigo) {
        this.Codigo = Codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "raca")
    public List<Pet> getPets() {
        return pets;
    }

    public void setPets(List<Pet> pets) {
        this.pets = pets;
    }

    @ManyToOne (fetch = FetchType.EAGER)
    public ClassificacaoPet getClassificacao() {
        return classificacao;
    }

    public void setClassificacao(ClassificacaoPet classificacao) {
        this.classificacao = classificacao;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 47 * hash + Objects.hashCode(this.Codigo);
        hash = 47 * hash + Objects.hashCode(this.descricao);
        hash = 47 * hash + Objects.hashCode(this.classificacao);
        hash = 47 * hash + Objects.hashCode(this.pets);
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
        final Raca other = (Raca) obj;
        if (!Objects.equals(this.Codigo, other.Codigo)) {
            return false;
        }
        if (!Objects.equals(this.descricao, other.descricao)) {
            return false;
        }
        if (!Objects.equals(this.classificacao, other.classificacao)) {
            return false;
        }
        if (!Objects.equals(this.pets, other.pets)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Raca{" + "Codigo=" + Codigo + ", descricao=" + descricao + ", classificacao=" + classificacao + ", pets=" + pets + '}';
    }
}
