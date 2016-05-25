package application;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

import cadastro.Cliente;
import cadastro.Produto;
import cadastro.Venda;
import menus.MenuOperacoes;
import menus.MenuPrincipal;
import menus.MenuRelatorios;

public class Application {

	static Scanner e = new Scanner(System.in);
	static int escolha=0, escolhaOp=0, escolhaOp1=0, escolhaOp2=0;
	static String cpf, nome, email, nomeProd, dataHoraAtual;
	static int numero_conta, codigo, testeSair, vendaNumContaCliente, vendaCodProd, vendaQuantProd, resposta;
	static double saldo, preco;
	static ArrayList<Cliente> clientes = new ArrayList<>();
	static ArrayList<Produto> produtos = new ArrayList<>();
	static ArrayList<Venda> vendas = new ArrayList<>();
	static Produto produtoVendido;

 	public static void main(String[] args) {
		do{				
			switch(menu()){
			case 0: 
				escolha_0();
				break;
			case 1: 
				escolha_1();
				break;
			case 2: 
				escolha_2();
				break;
			case 3: 
				escolha_3();
				break;
			case 4: 
				escolha_4();
				break;
			case 5: 
				escolha_5();
				break;
			default:
				System.out.println("Escolha invalida!");
			}
		}while(escolha != 0);

	}
	static int menu(){
		System.out.println(MenuPrincipal.getOpcoes());
		escolha = e.nextInt();
		return escolha;
	}
	static void escolha_0(){
		System.out.println("> Obrigado por utilizar este programa! <");		
	}
	static void escolha_1(){
		System.out.println("Cadastro de clientes:");
		
		System.out.println("CPF: ");
		cpf = e.next();
		System.out.println("Nome: ");
		nome = e.next();
		System.out.println("E-mail: ");
		email = e.next();
		
		while(true){
			System.out.println("Numero da conta: ");
			numero_conta = e.nextInt();
			
			if (numero_conta < 0) {
				System.out.println("Numero da conta negativo!");
			}
			else{
				break;
			}	
		}
		
		while(true){
			System.out.println("Saldo: ");
			saldo = e.nextDouble();

			if (saldo < 0) {
				System.out.println("Saldo negativo!");
			}
			else{
				break;
			}	
		}
				
		Cliente cliente = new Cliente(cpf, nome, email, numero_conta, saldo);
		clientes.add(cliente);
	}
	static void escolha_2(){
		System.out.println("Cadastro de produtos:");
		
		while(true){
			System.out.println("Codigo: ");
			codigo = e.nextInt();
			
			if (codigo < 0) {
				System.out.println("Codigo do produto negativo!");
			}
			else{
				break;
			}	
		}
		
		System.out.println("Nome: ");
		nomeProd = e.next();
		
		while(true){
			
			System.out.println("Preco: ");
			preco = e.nextDouble();
	
			if (preco < 0) {
				System.out.println("Preco negativo!");
			}
			else{
				break;
			}	
		}
				
		Produto produto = new Produto(codigo, nomeProd, preco);
		produtos.add(produto);
	}
	static void escolha_3(){
		if(clientes.size() < 1){
			System.out.println("Sistema nao possui clientes!");
		}
		else{
			testeSair = 0;
			
			while (testeSair == 0) {
				System.out.println("Digite o numero da conta do cliente: ");
				int teste = e.nextInt();
				
				for (Cliente cliente : clientes) {
					if (cliente.getNumero_conta() == teste) {
	
						do{				
							switch(menu_Operacoes()){
							case 0: 
								System.out.println("Fechando menu");
								break;
							case 1: 
								while(true){
									
									System.out.println("Valor a ser depositado");
									Double valor = e.nextDouble();
							
									if (valor < 5) {
										System.out.println("Valor negativo ou muito baixo!");
									}
									else{
										cliente.deposito(valor);
										System.out.println("R$ "+valor+" depositado!");
										break;
									}	
								}
								break;
							case 2: 
								if(clientes.size() < 2){
									System.out.println("Sistema nao possui clientes suficientes!");
								}
								else{
									System.out.println("Digite o numero da conta do cliente: ");
									int teste1 = e.nextInt();
									
									for (Cliente cliente1 : clientes) {
										if (cliente1.getNumero_conta() == teste1) {
											while(true){
												
												System.out.println("Valor a ser transferido");
												Double valor1 = e.nextDouble();
										
												if (valor1 < 0) {
													System.out.println("Valor negativo!");
												}
												else{
													cliente.deposito(-valor1);
													cliente1.deposito(valor1);
													System.out.println("R$ "+valor1+" transferido!");
													
													testeSair=1;
													break;
												}	
											}
										}
									}
									if (testeSair == 0) {
										System.out.println("Cliente nao encontrado!");
									}
								}
								break;
							case 3:
								System.out.println("Seu saldo e de R$ "+cliente.getSaldo());
								break;
							default:
								System.out.println("Escolha invalida!");
							}
						}while(escolhaOp != 0);
						testeSair=1;
					}
				}
				if (testeSair == 0) {
					System.out.println("Cliente nao encontrado!");
				}
			}
		}
	}
	static void escolha_4(){
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
	}
	static void escolha_5(){
		do{				
			switch(menu_Relatorios()){
			case 0: 
				System.out.println("Fechando menu");
				break;
			case 1: 
				if(vendas.isEmpty()){
					System.out.println("Sistema nao possui vendas realizadas!");
				}
				else{
				System.out.println("Produtos vendidos");
					for (Venda venda : vendas) {
						System.out.println("Produto "+venda.getVenda());
					}
				}
				break;
			case 2: 
				if(vendas.isEmpty()){
					System.out.println("Sistema nao possui vendas realizadas!");
				}
				else{
					System.out.println("Compras feitas pelo cliente");
					for (Cliente cliente : clientes) {
						System.out.println("Cliente:"+cliente.getCliente());
					}
				}
				break;
			case 3:
				if(vendas.isEmpty()){
					System.out.println("Sistema nao possui vendas realizadas!");
				}
				else{
					System.out.println("Clientes que mais compram");
					for (Cliente cliente : clientes) {
						System.out.println("Cliente:"+cliente.getCliente());
					}
				}
				break;
			case 4:
				if(clientes.isEmpty()){
					System.out.println("Sistema nao possui clientes cadastrados!");
				}
				else{
					System.out.println("Clientes que mais realizam operacoes de monetizacao:");
					for (Cliente cliente : clientes) {
						System.out.println("Cliente:"+cliente.getCliente());
					}
				}
				break;
			default:
				System.out.println("Escolha invalida!");
			}
		}while(escolhaOp2 != 0);
	}
	static int menu_Operacoes(){
		System.out.println(MenuOperacoes.getOpcoes());
		escolhaOp = e.nextInt();
		return escolhaOp;
	}
	static int menu_Relatorios(){
		System.out.println(MenuRelatorios.getOpcoes());
		escolhaOp1 = e.nextInt();
		return escolhaOp1;
	}
}