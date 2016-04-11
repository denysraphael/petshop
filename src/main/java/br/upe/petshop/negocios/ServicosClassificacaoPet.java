/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.upe.petshop.negocios;

import br.upe.petshop.entidades.ClassificacaoPet;
import br.upe.petshop.exceptions.ClassificacaoPetExistenteException;
import br.upe.petshop.exceptions.ClassificacaoPetInexistenteException;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author -Denys
 */
public interface ServicosClassificacaoPet extends Serializable{
    public void cadastrarClassificacaoPet(ClassificacaoPet classificacao) throws ClassificacaoPetExistenteException,ClassificacaoPetInexistenteException;
    public void atualizarClassificacaoPet(ClassificacaoPet classificacao) throws ClassificacaoPetInexistenteException;
    public void excluirClassificacaoPet(Long id) throws ClassificacaoPetInexistenteException;
    public List<ClassificacaoPet> listarTodos();
}
