/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.upe.petshop.negocios;

import br.upe.petshop.entidades.Raca;
import br.upe.petshop.exceptions.RacaExistenteException;
import br.upe.petshop.exceptions.RacaInexistenteException;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author -Denys
 */
public interface ServicosRaca extends Serializable{
    public void cadastrar(Raca raca) throws RacaExistenteException;
    public void atualizar(String nomeAtual, String nomeAtualizar) throws RacaInexistenteException;
    public List<Raca> listarTodos();
    public Raca consultarPorNome(String nome) throws RacaInexistenteException;
}
