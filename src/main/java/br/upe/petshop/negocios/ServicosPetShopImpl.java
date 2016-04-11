/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.upe.petshop.negocios;

import br.upe.petshop.entidades.PetShop;
import br.upe.petshop.exceptions.PetShopExistenteException;
import br.upe.petshop.exceptions.PetShopInexistenteException;
import br.upe.petshop.listar.PetShopListar;
import br.upe.petshop.persistencia.RepositorioPetShop;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author -Denys
 */
@Service
public class ServicosPetShopImpl implements ServicosPetShop{
    
    @Autowired
    private RepositorioPetShop repositorioPetShop;

    @Override
    @Transactional(rollbackFor = PetShopExistenteException.class)
    public void cadastrarPetShop(PetShop petShop) throws PetShopExistenteException, PetShopInexistenteException {
        PetShop p = repositorioPetShop.findOne(petShop.getCnpj());
        if(p!=null){
            if(!p.isAtivo()){
                p.setAtivo(true);
                p.setNome(petShop.getNome());
                p.setEndereco(petShop.getEndereco());
                p.setTelefone(petShop.getTelefone());
                p.setSenha(petShop.getSenha());
                p.setBanho(petShop.isBanho());
                p.setBanhoHidratacao(petShop.isBanhoHidratacao());
                p.setBusca(petShop.isBusca());
                p.setConsulta(petShop.isConsulta());
                p.setTosaBebe(petShop.isTosaBebe());
                p.setTosaHigienica(petShop.isTosaHigienica());
                p.setTosaRaca(petShop.isTosaRaca());
                atualizarPetShop(p, p.getCnpj());
            }else{
                throw new PetShopExistenteException();
            }
        }else{
            repositorioPetShop.save(petShop);
        }
    }

    @Override
    @Transactional(rollbackFor = PetShopInexistenteException.class)
    public void atualizarPetShop(PetShop petShop, String cnpj) throws PetShopInexistenteException {
        PetShop petShopAtualizar = repositorioPetShop.findOne(petShop.getCnpj());
        if(petShopAtualizar==null){
            throw new PetShopInexistenteException();
        }
        else{
            petShopAtualizar.setNome(petShop.getNome());
            petShopAtualizar.setEndereco(petShop.getEndereco());
            petShopAtualizar.setTelefone(petShop.getTelefone());
            petShopAtualizar.setSenha(petShop.getSenha());
            petShopAtualizar.setBanho(petShop.isBanho());
            petShopAtualizar.setBanhoHidratacao(petShop.isBanhoHidratacao());
            petShopAtualizar.setBusca(petShop.isBusca());
            petShopAtualizar.setConsulta(petShop.isConsulta());
            petShopAtualizar.setTosaBebe(petShop.isTosaBebe());
            petShopAtualizar.setTosaHigienica(petShop.isTosaHigienica());
            petShopAtualizar.setTosaRaca(petShop.isTosaRaca());
            petShopAtualizar.setServicos(petShop.getServicos());
            petShopAtualizar.setAtivo(petShop.isAtivo());
            repositorioPetShop.save(petShopAtualizar);
        }
    }

    @Override
    @Transactional(rollbackFor = PetShopInexistenteException.class)
    public void excluirPetShop(String cnpj) throws PetShopInexistenteException {
        PetShop petShopAtualizar = repositorioPetShop.findOne(cnpj);
        if(petShopAtualizar==null){
            throw new PetShopInexistenteException();
        }
        else{
           petShopAtualizar.setAtivo(false);
           repositorioPetShop.save(petShopAtualizar);
        }
        
    }

    @Override
    public List<PetShopListar> listarTodos() {
        List<PetShopListar> retorno = new ArrayList<PetShopListar>();
        List<PetShop> pesquisa = (List<PetShop>) repositorioPetShop.findAll();
        for(int i = 0; i < pesquisa.size(); i++){
            if(pesquisa.get(i).isAtivo()){
                PetShopListar psl = new PetShopListar();
                psl.setCnpj(pesquisa.get(i).getCnpj());
                psl.setNome(pesquisa.get(i).getNome());
                psl.setEndereco(pesquisa.get(i).getEndereco());
                psl.setTelefone(pesquisa.get(i).getTelefone());
                psl.setBanho(pesquisa.get(i).isBanho());
                psl.setBanhoHidratacao(pesquisa.get(i).isBanhoHidratacao());
                psl.setBusca(pesquisa.get(i).isBusca());
                psl.setConsulta(pesquisa.get(i).isConsulta());
                psl.setTosaBebe(pesquisa.get(i).isTosaBebe());
                psl.setTosaHigienica(pesquisa.get(i).isTosaHigienica());
                psl.setTosaRaca(pesquisa.get(i).isTosaRaca());
                if(pesquisa.get(i).getServicos()!=null){
                    List<String> servicos = new ArrayList<String>();
                    for(int j = 0; j < pesquisa.get(i).getServicos().size(); j++){
                        String serv = pesquisa.get(i).getServicos().get(j).getTipoServico();
                        servicos.add(serv);
                    }
                    psl.setServicos(servicos);
                }
                retorno.add(psl);
            }
        }
        return retorno;
    }

    @Override
    public PetShop BuscarPorCnp(String cnpj) throws PetShopInexistenteException {
        PetShop petShopAtualizar = repositorioPetShop.findOne(cnpj);
        if(petShopAtualizar==null || !petShopAtualizar.isAtivo())
            throw new PetShopInexistenteException();
        return petShopAtualizar;
    }

    @Override
    public List<PetShopListar> BuscarPorNome(String nome) {
        List<PetShopListar> retorno = new ArrayList<PetShopListar>();
        List<PetShop> pesquisa = (List<PetShop>) repositorioPetShop.findByNome(nome);
        for(int i = 0; i < pesquisa.size(); i++){
            if(pesquisa.get(i).isAtivo()){
                PetShopListar psl = new PetShopListar();
                psl.setCnpj(pesquisa.get(i).getCnpj());
                psl.setNome(pesquisa.get(i).getNome());
                psl.setEndereco(pesquisa.get(i).getEndereco());
                psl.setTelefone(pesquisa.get(i).getTelefone());
                psl.setBanho(pesquisa.get(i).isBanho());
                psl.setBanhoHidratacao(pesquisa.get(i).isBanhoHidratacao());
                psl.setBusca(pesquisa.get(i).isBusca());
                psl.setConsulta(pesquisa.get(i).isConsulta());
                psl.setTosaBebe(pesquisa.get(i).isTosaBebe());
                psl.setTosaHigienica(pesquisa.get(i).isTosaHigienica());
                psl.setTosaRaca(pesquisa.get(i).isTosaRaca());
                if(pesquisa.get(i).getServicos()!=null){
                    List<String> servicos = new ArrayList<String>();
                    for(int j = 0; j < pesquisa.get(i).getServicos().size(); j++){
                        String serv = pesquisa.get(i).getServicos().get(j).getTipoServico();
                        servicos.add(serv);
                    }
                    psl.setServicos(servicos);
                }
                retorno.add(psl);
            }
        }
        return retorno;
    }
}
