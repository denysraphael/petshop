/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.upe.petshop.persistencia;

import br.upe.petshop.entidades.Cliente;
import br.upe.petshop.entidades.PetShop;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author -Denys
 */
public interface RepositorioPetShop extends CrudRepository<PetShop, String>{
    public List<PetShop> findByNome(String nome);  
}
