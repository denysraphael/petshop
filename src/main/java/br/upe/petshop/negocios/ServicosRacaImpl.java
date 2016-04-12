/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.upe.petshop.negocios;

import br.upe.petshop.entidades.Raca;
import br.upe.petshop.exceptions.RacaExistenteException;
import br.upe.petshop.exceptions.RacaInexistenteException;
import br.upe.petshop.persistencia.RepositorioRaca;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author -Denys
 */
@Service
public class ServicosRacaImpl implements ServicosRaca{

    @Autowired
    private RepositorioRaca repositorioRaca;
      
    @Override
    @Transactional(rollbackFor = RacaExistenteException.class)
    public void cadastrar(Raca raca) throws RacaExistenteException {
        if(repositorioRaca.findByNome(raca.getNome())!=null) 
            throw new RacaExistenteException();
        repositorioRaca.save(raca);
    }

    @Override
    @Transactional(rollbackFor = RacaInexistenteException.class)
    public void atualizar(String nomeAtual, String nomeAtualizar) throws RacaInexistenteException {
        Raca racaAtualizar = repositorioRaca.findByNome(nomeAtual);
        if(racaAtualizar==null) throw new RacaInexistenteException();
        racaAtualizar.setNome(nomeAtualizar);
        repositorioRaca.save(racaAtualizar);
    }

    @Override
    public List<Raca> listarTodos() {
        return (List<Raca>) repositorioRaca.findAll();
    }

    @Override
    public Raca consultarPorNome(String nome) throws RacaInexistenteException {
        if(repositorioRaca.findByNome(nome)==null){
            throw new RacaInexistenteException();
        }
        return repositorioRaca.findByNome(nome);
    }
    
}
