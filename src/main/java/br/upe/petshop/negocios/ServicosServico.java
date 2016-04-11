/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.upe.petshop.negocios;

import br.upe.petshop.exceptions.ServicoInexistenteException;
import br.upe.petshop.exceptions.ServicoExistenteException;
import br.upe.petshop.entidades.Servico;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author -Denys
 */
public interface ServicosServico extends Serializable{
    public void cadastrarServico(Servico servico) throws ServicoExistenteException;
    public void atualizarServico(Servico servico)  throws ServicoInexistenteException;
    public void excluirServico(Long codigo)  throws ServicoInexistenteException;
    public List<Servico> litarTodos();
    public List<Servico> buscarPorTipo(String tipo);
    public List<Servico> buscarPorPet(String nomePet);
    public List<Servico> buscarPorPetShop(String nomePetShop);
}
