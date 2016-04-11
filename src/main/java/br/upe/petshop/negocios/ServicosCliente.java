/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.upe.petshop.negocios;

import br.upe.petshop.entidades.Cliente;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author -Denys
 */
public interface ServicosCliente extends Serializable {
    public void cadastrarCliente(Cliente cliente) throws ClienteExistenteException;
    public void atualizarCliente(Cliente cliente) throws ClienteInexistenteException;
    public void excluirCliente(String cpf) throws ClienteInexistenteException;
    public List<Cliente> listarTodos();
    public Cliente BuscarPorCpf(String cpf) throws ClienteInexistenteException;
    public List<Cliente> BuscarPorNome(String nome);
}
