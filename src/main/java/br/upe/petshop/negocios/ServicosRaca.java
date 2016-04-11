/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.upe.petshop.negocios;

import br.upe.petshop.entidades.Raca;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author -Denys
 */
public interface ServicosRaca extends Serializable {
    public void cadastrarRaca(Raca raca) throws RacaExistenteException,RacaInexistenteException;
    public void atualizarRaca(Raca raca) throws RacaInexistenteException;
    public void excluirRaca(Long codigo) throws RacaInexistenteException;
    public List<Raca> listarTodos();
    public List<Raca> BuscarPorClassificacao(String classificacao);   
}
