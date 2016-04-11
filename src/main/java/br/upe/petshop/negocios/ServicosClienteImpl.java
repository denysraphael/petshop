/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.upe.petshop.negocios;

import br.upe.petshop.entidades.Cliente;
import br.upe.petshop.exceptions.ClienteExistenteException;
import br.upe.petshop.exceptions.ClienteInexistenteException;
import br.upe.petshop.listar.ClienteListar;
import br.upe.petshop.persistencia.RepositorioCliente;
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
public class ServicosClienteImpl implements ServicosCliente {

    @Autowired
    private RepositorioCliente repositorioCliente;
    
    @Override
    @Transactional(rollbackFor = ClienteExistenteException.class)
    public void cadastrarCliente(Cliente cliente) throws ClienteExistenteException, ClienteInexistenteException{
        Cliente c = repositorioCliente.findOne(cliente.getCpf());
        if(c!=null){
            if(!c.isAtivo()){
                c.setAtivo(true);
                c.setNome(cliente.getNome());
                c.setEndereco(cliente.getEndereco());
                c.setTelefone(cliente.getTelefone());
                c.setSenha(c.getSenha());
                atualizarCliente(c, c.getCpf());
                
            }else{
                throw new ClienteExistenteException();
            }
        }else{
            repositorioCliente.save(cliente);
        }
    }

    @Override
    @Transactional(rollbackFor = ClienteInexistenteException.class)
    public void atualizarCliente(Cliente cliente, String cpf) throws ClienteInexistenteException {
        Cliente clienteAtualizar = repositorioCliente.findOne(cliente.getCpf());
        if(clienteAtualizar==null){
            throw new ClienteInexistenteException();
        }
        else{
            clienteAtualizar.setNome(cliente.getNome());
            clienteAtualizar.setEndereco(cliente.getEndereco());
            clienteAtualizar.setTelefone(cliente.getTelefone());
            clienteAtualizar.setSenha(cliente.getSenha());
            clienteAtualizar.setPets(cliente.getPets());
            clienteAtualizar.setCompras(cliente.getCompras());
            clienteAtualizar.setAtivo(cliente.isAtivo());
            repositorioCliente.save(clienteAtualizar);
        }
    }

    @Override
    @Transactional(rollbackFor = ClienteInexistenteException.class)
    public void excluirCliente(String cpf) throws ClienteInexistenteException {
        Cliente clienteAtualizar = repositorioCliente.findOne(cpf);
        if(clienteAtualizar==null)
            throw new ClienteInexistenteException();
        clienteAtualizar.setAtivo(false);
        repositorioCliente.save(clienteAtualizar);
    }

    @Override
    public List<ClienteListar> listarTodos() {
        List<ClienteListar> retorno = new ArrayList<ClienteListar>();
        List<Cliente> pesquisa = (List<Cliente>) repositorioCliente.findAll();
        for(int i = 0; i < pesquisa.size(); i++){
            if(pesquisa.get(i).isAtivo()){
                ClienteListar cl = new ClienteListar();
                cl.setCpf(pesquisa.get(i).getCpf());
                cl.setNome(pesquisa.get(i).getNome());
                cl.setEndereco(pesquisa.get(i).getEndereco());
                cl.setTelefone(pesquisa.get(i).getTelefone());
                cl.setSenha(pesquisa.get(i).getSenha());
                if(pesquisa.get(i).getPets()!=null){
                    List<String> pets = new ArrayList<String>();
                    for(int j = 0; j < pesquisa.get(i).getPets().size(); j++){
                        String nome = pesquisa.get(i).getPets().get(j).getNome();
                        pets.add(nome);
                    }
                    cl.setPets(pets);
                }
                retorno.add(cl);
            }
        }
        return retorno;
    }
    
    @Override
    public Cliente BuscarPorCpf(String cpf) throws ClienteInexistenteException {
       Cliente clienteAtualizar = repositorioCliente.findOne(cpf);
        if(clienteAtualizar==null || !clienteAtualizar.isAtivo())
            throw new ClienteInexistenteException();
        return clienteAtualizar;
    }
    
    @Override
    public List<ClienteListar> BuscarPorNome(String nome) {
        List<ClienteListar> retorno = new ArrayList<ClienteListar>();
        List<Cliente> pesquisa = (List<Cliente>) repositorioCliente.findByNome(nome);
        for(int i = 0; i < pesquisa.size(); i++){
            if(pesquisa.get(i).isAtivo()){
                ClienteListar cl = new ClienteListar();
                cl.setCpf(pesquisa.get(i).getCpf());
                cl.setNome(pesquisa.get(i).getNome());
                cl.setEndereco(pesquisa.get(i).getEndereco());
                cl.setTelefone(pesquisa.get(i).getTelefone());
                cl.setSenha(pesquisa.get(i).getSenha());
                if(pesquisa.get(i).getPets()!=null){
                    List<String> pets = new ArrayList<String>();
                    for(int j = 0; j < pesquisa.get(i).getPets().size(); j++){
                        String nom = pesquisa.get(i).getPets().get(j).getNome();
                        pets.add(nom);
                    }
                    cl.setPets(pets);
                }
                retorno.add(cl);
            }
        }
        return retorno;
    }  
}
