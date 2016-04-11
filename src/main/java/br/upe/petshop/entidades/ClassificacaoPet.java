/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.upe.petshop.entidades;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 *
 * @author -Denys
 */
public class ClassificacaoPet {
    private Long codigo;
    private String descricao;
    private List<Raca> racas;
    private List<Pet> pets;

    public ClassificacaoPet(String descricao) {
        this.descricao = descricao;
        this.racas = new ArrayList<Raca>();
        this.pets = new ArrayList<Pet>();
    }

    public ClassificacaoPet() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "classificacao")
    public List<Raca> getRacas() {
        return racas;
    }

    public void setRacas(List<Raca> racas) {
        this.racas = racas;
    }

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "classificacao")
    public List<Pet> getPets() {
        return pets;
    }

    public void setPets(List<Pet> pets) {
        this.pets = pets;
    }

   
}
