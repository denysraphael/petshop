/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.upe.petshop.negocios;

import br.upe.petshop.entidades.PetShop;
import br.upe.petshop.exceptions.PetShopExistenteException;
import br.upe.petshop.exceptions.PetShopInexistenteException;
import br.upe.petshop.listar.PetShopListar;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author -Denys
 */
public interface ServicosPetShop extends Serializable{
    public void cadastrarPetShop(PetShop petShop) throws PetShopExistenteException,PetShopInexistenteException;
    public void atualizarPetShop(PetShop petShop, String cnpj) throws PetShopInexistenteException;
    public void excluirPetShop(String cnpj) throws PetShopInexistenteException;
    public List<PetShopListar> listarTodos();
    public PetShop BuscarPorCnp(String cnpj) throws PetShopInexistenteException;
    public List<PetShopListar> BuscarPorNome(String nome);
}
