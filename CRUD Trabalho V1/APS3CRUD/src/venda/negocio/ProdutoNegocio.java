/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package venda.negocio;

import venda.dominio.Produto;
import venda.dao.ProdutoDao;
import venda.dao.impl_BD.ProdutoDaoBd;
import java.util.List;

/**
 *
 * @author 691001155
 */
public class ProdutoNegocio {

    private ProdutoDao produtoDao;

    public ProdutoNegocio() {
        produtoDao = new ProdutoDaoBd();
    }

    public void salvar(Produto p) throws NegocioException {
        this.validarCamposObrigatorios(p);
        this.validarCodigoExistente(p);
        produtoDao.salvar(p);
    }

    public List<Produto> listar() {
        return (produtoDao.listar());
    }

    public void deletar(Produto produto) throws NegocioException {
        if (produto == null || produto.getNomeProd() == null) {
            throw new NegocioException("Produto nao existe!");
        }
        produtoDao.deletar(produto);
    }

    public void atualizar(Produto produto) throws NegocioException {
        if (produto == null || produto.getNomeProd() == null) {
            throw new NegocioException("Produto nao existe!");
        }
        this.validarCamposObrigatorios(produto);
        produtoDao.atualizar(produto);
    }

    public Produto procurarPorCodigo(int codigo) throws NegocioException {
        if (codigo < 0) {
            throw new NegocioException("Campo codigo nao informado ou zerado");
        }
        Produto produto = produtoDao.procurarPorCodigo(codigo);
        if (produto == null) {
            throw new NegocioException("Produto nao encontrado");
        }
        return (produto);
    }

    public List<Produto> procurarPorNome(String nome) throws NegocioException {
        if (nome == null || nome.isEmpty()) {
            throw new NegocioException("Campo nome nao informado");
        }
        return(produtoDao.procurarPorNome(nome));
    }

    public boolean produtoExiste(int codigo) {
        Produto produto = produtoDao.procurarPorCodigo(codigo);
        return (produto != null);
    }

    private void validarCamposObrigatorios(Produto p) throws NegocioException {
        if (p.getCodigo() < 1) {
            throw new NegocioException("Campo codigo negativo ou zero!");
        }

        if (p.getNomeProd() == null || p.getNomeProd().isEmpty()) {
            throw new NegocioException("Campo nome nao informado");
        }
        
        if (p.getPreco() == null || p.getPreco() < 0) {
            throw new NegocioException("Campo preco nao informado ou zero");
        }
    }

    private void validarCodigoExistente(Produto p) throws NegocioException {
        if (produtoExiste(p.getCodigo())) {
            throw new NegocioException("Codigo ja existente");
        }
    }

}
