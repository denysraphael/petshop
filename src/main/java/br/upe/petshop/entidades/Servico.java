/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.upe.petshop.entidades;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author -Denys
 */
@Entity
public class Servico implements Serializable{
    private Long codigo;
    private String tipoServico;
    private PetShop petShop;
    private Double valor;
    private Pet pet;
    private Date dia;
    private Date hora;
    private boolean ativo;
    private Compra compra;

    public Servico() {
    }
    
    public Servico(String tipoServico, PetShop petShop, Double valor, Pet pet, Date dia, Date hora, Compra compra) {
        this.tipoServico = tipoServico;
        this.petShop = petShop;
        this.valor = valor;
        this.pet = pet;
        this.dia = dia;
        this.hora = hora;
        this.ativo = true;
        this.compra = compra;
    }

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public String getTipoServico() {
        return tipoServico;
    }

    public void setTipoServico(String tipoServico) {
        this.tipoServico = tipoServico;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    public PetShop getPetShop() {
        return petShop;
    }

    public void setPetShop(PetShop petShop) {
        this.petShop = petShop;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    public Pet getPet() {
        return pet;
    }

    public void setPet(Pet pet) {
        this.pet = pet;
    }

    @Temporal(TemporalType.DATE)
    public Date getDia() {
        return dia;
    }

    public void setDia(Date dia) {
        this.dia = dia;
    }

    @Temporal(TemporalType.TIME)
    public Date getHora() {
        return hora;
    }

    public void setHora(Date hora) {
        this.hora = hora;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    public Compra getCompra() {
        return compra;
    }

    public void setCompra(Compra compra) {
        this.compra = compra;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.codigo);
        hash = 97 * hash + Objects.hashCode(this.tipoServico);
        hash = 97 * hash + Objects.hashCode(this.petShop);
        hash = 97 * hash + Objects.hashCode(this.valor);
        hash = 97 * hash + Objects.hashCode(this.pet);
        hash = 97 * hash + Objects.hashCode(this.dia);
        hash = 97 * hash + Objects.hashCode(this.hora);
        hash = 97 * hash + (this.ativo ? 1 : 0);
        hash = 97 * hash + Objects.hashCode(this.compra);
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
        final Servico other = (Servico) obj;
        if (!Objects.equals(this.codigo, other.codigo)) {
            return false;
        }
        if (!Objects.equals(this.tipoServico, other.tipoServico)) {
            return false;
        }
        if (!Objects.equals(this.petShop, other.petShop)) {
            return false;
        }
        if (!Objects.equals(this.valor, other.valor)) {
            return false;
        }
        if (!Objects.equals(this.pet, other.pet)) {
            return false;
        }
        if (!Objects.equals(this.dia, other.dia)) {
            return false;
        }
        if (!Objects.equals(this.hora, other.hora)) {
            return false;
        }
        if (this.ativo != other.ativo) {
            return false;
        }
        if (!Objects.equals(this.compra, other.compra)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Servico{" + "codigo=" + codigo + ", tipoServico=" + tipoServico + ", petShop=" + petShop + ", valor=" + valor + ", pet=" + pet + ", dia=" + dia + ", hora=" + hora + ", ativo=" + ativo + ", compra=" + compra + '}';
    }
}
