/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.upe.petshop.persistencia;

import br.upe.petshop.entidades.Compra;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author -Denys
 */
public interface RepositorioCompra extends CrudRepository<Compra, Long> {
    @Query("select c from Compra c where c.cliente.nome=:nomeCliente")
    public List<Compra> findByCliente(@Param("nomeCliente") String nomeCliente);   
}
