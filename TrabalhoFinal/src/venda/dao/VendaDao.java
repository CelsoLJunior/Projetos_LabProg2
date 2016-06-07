/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package venda.dao;

import java.util.List;
import venda.dominio.Venda;

/**
 *
 * @author 691001155
 */
public interface VendaDao extends Dao<Venda>{
    public Venda procurarPorCodigo(int codigo);
    public List<Venda> procurarPorNumContaCliente(int codigo);
}
