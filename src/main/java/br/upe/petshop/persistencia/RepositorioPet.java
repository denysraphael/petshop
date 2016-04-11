/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.upe.petshop.persistencia;

import br.upe.petshop.entidades.Pet;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author -Denys
 */
public interface RepositorioPet  extends CrudRepository<Pet, Long> {
    public List<Pet> findByNome (String nome);
    @Query("select p from Pet p where p.classificacao.descricao=:classificacao")
    public List<Pet> findByClassificacao(@Param("classificacao") String classificacao);
    @Query("select p from Pet p where p.raca.descricao=:raca")
    public List<Pet> findByRaca (@Param("raca") String raca);
    @Query("select p from Pet p where p.dono.nome=:nomeDono")
    public List<Pet> findByDono(@Param("nomeDono") String nomeDono);   
}
