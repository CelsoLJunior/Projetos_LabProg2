/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package venda.view;

import venda.dominio.Produto;
import venda.negocio.NegocioException;
import venda.negocio.ProdutoNegocio;
import venda.util.Console;
import venda.view.menu.ProdutoMenu;
import java.util.InputMismatchException;
import java.util.List;


/**
 *
 * @author 691001155
 */
public class ProdutoUI {

    private ProdutoNegocio produtoNegocio;

    public ProdutoUI() {
        produtoNegocio = new ProdutoNegocio();
    }

    public void menu() {
        int opcao = -1;
        do {
            try {
                System.out.println(ProdutoMenu.getOpcoes());
                opcao = Console.scanInt("Digite sua opcao:");
                switch (opcao) {
                    case ProdutoMenu.OP_CADASTRAR:
                        cadastrarProduto();
                        break;
                    case ProdutoMenu.OP_DELETAR:
                        deletarProduto();
                        break;
                    case ProdutoMenu.OP_ATUALIZAR:
                        atualizarProduto();
                        break;
                    case ProdutoMenu.OP_LISTAR:
                        mostrarProdutos();
                        break;
                    case ProdutoMenu.OP_CONSULTAR:
                        consultarProdutosPorNome();
                        break;
                    case ProdutoMenu.OP_SAIR:
                        System.out.println("Retornando a aplicacao..");
                        break;
                    default:
                        System.out.println("Opcao invalida..");
                }
            } catch (InputMismatchException ex) {
                UIUtil.mostrarErro("Somente numeros sao permitidos!");
            }

        } while (opcao != ProdutoMenu.OP_SAIR);
    }

    private void cadastrarProduto() {
        int codigo = Console.scanInt("Codigo: ");
        String nome = Console.scanString("Nome: ");
        Double preco = Console.scanDouble("Preco do produto: ");
        try {
            produtoNegocio.salvar(new Produto(codigo, nome, preco));
            System.out.println("Produto " + nome + " cadastrado com sucesso!");
        } catch (NegocioException ex) {
            UIUtil.mostrarErro(ex.getMessage());
        }
    }

    public void mostrarProdutos() {
        List<Produto> listaProdutos = produtoNegocio.listar();
        this.mostrarProdutos(listaProdutos);
    }

    private void deletarProduto() {
        int codigo = Console.scanInt("Codigo do produto a ser deletado: ");
        try {
            Produto pac = produtoNegocio.procurarPorCodigo(codigo);
            this.mostrarProduto(pac);
            if (UIUtil.getConfirmacao("Realmente deseja excluir esse produto?")) {
                produtoNegocio.deletar(pac);
                System.out.println("Produto deletado com sucesso!");
            } else {
                System.out.println("Operacao cancelada!");
            }
        } catch (NegocioException ex) {
            UIUtil.mostrarErro(ex.getMessage());
        }
    }

    private void atualizarProduto() {
    	int codigo = Console.scanInt("Codigo do produto a ser alterado: ");
        try {
            Produto pac = produtoNegocio.procurarPorCodigo(codigo);
            this.mostrarProduto(pac);

            System.out.println("Digite os dados do produto que quer alterar [Vazio caso nao queira]");
            String nome = Console.scanString("Nome: ");
            Double preco = Console.scanDouble("Preco do produto: ");
            if (!nome.isEmpty()) {
                pac.setNomeProd(nome);
            }
            if (!preco.isNaN() || preco > 0) {
                pac.setPreco(preco);
            }

            produtoNegocio.atualizar(pac);
            System.out.println("Produto " + nome + " atualizado com sucesso!");
        } catch (NegocioException ex) {
            UIUtil.mostrarErro(ex.getMessage());
        }
    }

    private void consultarProdutosPorNome() {
        String nome = Console.scanString("Nome: ");
        try {
            List<Produto> listaPac = produtoNegocio.procurarPorNome(nome);
            this.mostrarProdutos(listaPac);
        } catch (NegocioException ex) {
            UIUtil.mostrarErro(ex.getMessage());
        }

    }

    private void mostrarProduto(Produto p) {
        System.out.println("-----------------------------");
        System.out.println("Produto");
        System.out.println("Codigo: " + p.getCodigo());
        System.out.println("Nome: "   + p.getNomeProd());
        System.out.println("Preco: "  + p.getPreco());
        System.out.println("-----------------------------");
    }

    private void mostrarProdutos(List<Produto> listaProdutos) {
        if (listaProdutos.isEmpty()) {
            System.out.println("Produtos nao encontrados!");
        } else {
            System.out.println("-----------------------------\n");
            System.out.println(String.format("%-10s", "Codigo") + "\t"
                    + String.format("%-20s", "|NOME") + "\t"
                    + String.format("%-20s", "|PRECO"));
            for (Produto produto : listaProdutos) {
                System.out.println(String.format("%-10s", produto.getCodigo()) + "\t"
                        + String.format("%-20s", "|" + produto.getNomeProd()) + "\t"
                        + String.format("%-20s", "|R$ " + produto.getPreco()));
            }
        }
    }
}
