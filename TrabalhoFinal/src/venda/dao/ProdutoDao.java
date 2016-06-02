/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package venda.dao;

import java.util.List;
import venda.dominio.Produto;

/**
 *
 * @author 691001155
 */
public interface ProdutoDao extends Dao<Produto>{
    public Produto procurarPorCodigo(int codigo);
    public List<Produto> procurarPorNome(String nome);
}
