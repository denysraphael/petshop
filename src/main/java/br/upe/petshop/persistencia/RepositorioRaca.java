/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.upe.petshop.persistencia;

import br.upe.petshop.entidades.Pet;
import br.upe.petshop.entidades.Raca;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author -Denys
 */
public interface RepositorioRaca extends CrudRepository<Raca, Long>{
    @Query("select r from Raca c where r.classificacao.descricao=:classificacao")
    public List<Raca> findByClassificacao(@Param("classificacao") String classificacao);   
}
