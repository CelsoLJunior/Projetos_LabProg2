/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package venda.view;

import venda.util.Console;
import venda.view.menu.PrincipalMenu;
import java.util.InputMismatchException;

/**
 *
 * @author 691001155
 */
public class PrincipalUI {

    public void menu() {
        int opcao = -1;
        do {
            try {
                System.out.println(PrincipalMenu.getOpcoes());
                opcao = Console.scanInt("Digite sua opcao:");
                switch (opcao) {
                    case PrincipalMenu.OP_CADASTRARCLIENTE:
                        cadastrarCliente();
                        break;
                    case PrincipalMenu.OP_CADASTRARPROD:
                    	cadastrarProduto();
                        break;
                    case PrincipalMenu.OP_MONETIZA:
                        motenizacao();
                        break;
                    case PrincipalMenu.OP_VENDA:
                        venda();
                        break;
                    case PrincipalMenu.OP_RELATORIO:
                        relatorio();
                        break;
                    case PrincipalMenu.OP_SAIR:
                        System.out.println("Finalizando a aplicacao..");
                        break;
                    default:
                        System.out.println("Opcao invalida...");
                }
            } catch (InputMismatchException ex) {
                UIUtil.mostrarErro("Somente numeros sao permitidos!");
            }

        } while (opcao != PrincipalMenu.OP_SAIR);
    }

    private void cadastrarCliente() {
    	new ClienteUI().menu();
    }
 
    private void cadastrarProduto() {
        new ProdutoUI().menu();
    }

    public void motenizacao() {
    	new MonetizacaoUI().menu();
    }

    private void venda() {
    	/*
    	if(clientes.isEmpty() || produtos.isEmpty()){
			System.out.println("Sistema nao possui clientes ou produtos!");
		}
		else{
			System.out.println("Venda de produtos com monetizacao:");
			
			while (true) {
				int teste=0;
				System.out.println("Numero da conta do cliente: ");
				vendaNumContaCliente = e.nextInt();
				
				for (Cliente cliente : clientes) {
					if (cliente.getNumero_conta() == vendaNumContaCliente) {
						teste = 1;
					}
				}
				if (teste != 0) {
					break;
				}
				else{
					System.out.println("Conta nao cadastrada!");
				}
			}
			
			LocalDate dataHoraAtual = LocalDate.now();
			
			do {
				while (true) {
					int teste=0;
					System.out.println("Produto: ");
					vendaCodProd = e.nextInt();
					
					for (Produto produto : produtos) {
						if (produto.getCodigo() == vendaCodProd) {
							produtoVendido = produto;
							teste = 1;
						}
					}
					if (teste != 0) {
						break;
					}
					else {
						System.out.println("Produto nao encontrado!");
					}
				}
				System.out.println("Quantidade do produto: ");
				vendaQuantProd = e.nextInt();
				
				System.out.println("Deseja adicionar novo produto? \n0 = Nao\n1 = Sim");
				resposta = e.nextInt();
				
			} while (resposta != 0);
			
			Venda venda = new Venda(vendaNumContaCliente, dataHoraAtual, produtoVendido, vendaQuantProd);
			vendas.add(venda);
		}
    	*/
    }

    private void relatorio() {
    	new RelatorioUI().menu();
    }
}