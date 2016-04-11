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
    private String tipo;
    private String raca;
    private String tamanho;
    private Cliente dono;
    private List<Servico> servicos;
    private boolean ativo;

    public Pet() {
    }

    public Pet(String tipo, String raca, String tamanho, Cliente dono, List<Servico> servicos, boolean ativo) {
        this.tipo = tipo;
        this.raca = raca;
        this.tamanho = tamanho;
        this.dono = dono;
        this.servicos = servicos;
        this.ativo = ativo;
    }

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getRaca() {
        return raca;
    }

    public void setRaca(String raca) {
        this.raca = raca;
    }

    public String getTamanho() {
        return tamanho;
    }

    public void setTamanho(String tamanho) {
        this.tamanho = tamanho;
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
        hash = 79 * hash + Objects.hashCode(this.codigo);
        hash = 79 * hash + Objects.hashCode(this.tipo);
        hash = 79 * hash + Objects.hashCode(this.raca);
        hash = 79 * hash + Objects.hashCode(this.tamanho);
        hash = 79 * hash + Objects.hashCode(this.dono);
        hash = 79 * hash + Objects.hashCode(this.servicos);
        hash = 79 * hash + (this.ativo ? 1 : 0);
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
        if (!Objects.equals(this.tipo, other.tipo)) {
            return false;
        }
        if (!Objects.equals(this.raca, other.raca)) {
            return false;
        }
        if (!Objects.equals(this.tamanho, other.tamanho)) {
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
        return "Pet{" + "codigo=" + codigo + ", tipo=" + tipo + ", raca=" + raca + ", tamanho=" + tamanho + ", dono=" + dono + ", servicos=" + servicos + ", ativo=" + ativo + '}';
    }
}
