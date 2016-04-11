/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.upe.petshop.entidades;

import java.io.Serializable;
import java.util.List;
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

   
}
