/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.upe.petshop.persistencia;

import br.upe.petshop.entidades.Servico;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author -Denys
 */
public interface RepositorioServico extends CrudRepository<Servico, Long>{
    public List<Servico> findByTipo (String tipoServico);
    @Query("select s from Servico s where p.pet.nome=:nomePet")
    public List<Servico> findByPet(@Param("nomePet") String nomePet);
    @Query("select s from Servico s where p.petShop.nome=:nomePetShop")
    public List<Servico> findByPetShop(@Param("nomePetShop") String nomePetShop);
}
