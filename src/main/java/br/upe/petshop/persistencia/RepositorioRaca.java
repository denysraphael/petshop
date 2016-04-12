/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.upe.petshop.persistencia;

import br.upe.petshop.entidades.Raca;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author -Denys
 */
public interface RepositorioRaca extends CrudRepository<Raca, Long>{
    public Raca findByNome(String nome);
}
