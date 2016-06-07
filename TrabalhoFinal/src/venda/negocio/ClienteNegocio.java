/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package venda.negocio;

import venda.dominio.Cliente;
import venda.dao.ClienteDao;
import venda.dao.impl_BD.ClienteDaoBd;
import java.util.List;

/**
 *
 * @author 691001155
 */
public class ClienteNegocio {

    private ClienteDao clienteDao;

    public ClienteNegocio() {
        clienteDao = new ClienteDaoBd();
    }

    public void salvar(Cliente p) throws NegocioException {
        this.validarCamposObrigatorios(p);
        this.validarCodigoExistente(p);
        clienteDao.salvar(p);
    }

    public List<Cliente> listar() {
        return (clienteDao.listar());
    }

    public void deletar(Cliente cliente) throws NegocioException {
        if (cliente == null || cliente.getNome() == null) {
            throw new NegocioException("Cliente nao existe!");
        }
        clienteDao.deletar(cliente);
    }

    public void atualizar(Cliente cliente) throws NegocioException {
        if (cliente == null || cliente.getNome() == null) {
            throw new NegocioException("Cliente nao existe!");
        }
        this.validarCamposObrigatorios(cliente);
        clienteDao.atualizar(cliente);
    }

    public Cliente procurarPorCodigo(int codigo) throws NegocioException {
        if (codigo < 0) {
            throw new NegocioException("Campo numero de conta nao informado ou zerado");
        }
        Cliente cliente = clienteDao.procurarPorNumConta(codigo);
        if (cliente == null) {
            throw new NegocioException("Cliente nao encontrado");
        }
        return (cliente);
    }

    public List<Cliente> procurarPorNome(String nome) throws NegocioException {
        if (nome == null || nome.isEmpty()) {
            throw new NegocioException("Campo nome nao informado");
        }
        return(clienteDao.procurarPorNome(nome));
    }

    public boolean clienteExiste(int codigo) {
        Cliente cliente = clienteDao.procurarPorNumConta(codigo);
        return (cliente != null);
    }

    private void validarCamposObrigatorios(Cliente p) throws NegocioException {
        if (p.getNumconta() < 1) {
            throw new NegocioException("Campo numero de conta negativo ou zero!");
        }

        if (p.getCpf()== null || p.getCpf().isEmpty()) {
            throw new NegocioException("Campo cpf nao informado");
        }
        
        if (p.getNome() == null || p.getNome().isEmpty()) {
            throw new NegocioException("Campo nome nao informado");
        }
        
        if (p.getEmail()== null || p.getEmail().isEmpty()) {
            throw new NegocioException("Campo email nao informado");
        }
        
        if (p.getSaldo()== null || p.getSaldo() < 0) {
            throw new NegocioException("Campo preco nao informado ou zero");
        }
    }

    private void validarCodigoExistente(Cliente p) throws NegocioException {
        if (clienteExiste(p.getNumconta())) {
            throw new NegocioException("Numero de conta ja existente");
        }
    }

}
