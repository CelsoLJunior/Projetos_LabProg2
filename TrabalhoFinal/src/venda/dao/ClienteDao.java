/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package venda.dao;

import java.util.List;
import venda.dominio.Cliente;

/**
 *
 * @author 691001155
 */
public interface ClienteDao extends Dao<Cliente>{
    public Cliente procurarPorNumConta(int codigo);
    public List<Cliente> procurarPorNome(String nome);
}
