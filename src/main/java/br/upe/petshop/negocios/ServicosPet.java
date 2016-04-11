/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.upe.petshop.negocios;

import br.upe.petshop.exceptions.PetInexistenteException;
import br.upe.petshop.exceptions.PetExistenteException;
import br.upe.petshop.entidades.Pet;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author -Denys
 */
public interface ServicosPet extends Serializable{
    public void cadastrarPet(Pet pet) throws PetExistenteException;
    public void atualizarPet(Pet pet) throws PetInexistenteException;
    public void excluirPet(String codigo) throws PetInexistenteException;
    public List<Pet> listarTodos();
    public List<Pet> BuscarPorNome(String nome) throws PetInexistenteException;
    public List<Pet> BuscarPorTipo(String tipo) throws PetInexistenteException;
    public List<Pet> BuscarPorRaca(String raca) throws PetInexistenteException;
    public List<Pet> BuscarPorDono(String dono) throws PetInexistenteException;
}
