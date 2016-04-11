/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.upe.petshop.negocios;

import br.upe.petshop.entidades.Compra;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author -Denys
 */
public interface ServicosCompra extends Serializable{
    public void cadastrarCompra(Compra compra) throws CompraExistenteException;
    public void atualizarCompra(Compra compra) throws CompraInexistenteException;
    public void excluirCompra(Long id) throws CompraInexistenteException;
    public List<Compra> listarTodas();
    public List<Compra> buscarPorCliente(String nomeCliente);
}
