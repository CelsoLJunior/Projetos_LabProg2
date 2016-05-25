/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package venda.dao;

import venda.dominio.Produto;
import java.util.List;

/**
 *
 * @author 691001155
 */
public interface Dao<T> {
    public void salvar(T dominio);
    public void deletar(T paciente);
    public void atualizar(T paciente);
    public List<T> listar();
    public T procurarPorId(int id);
}
