/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package venda.view;

import venda.util.Console;
import venda.view.menu.MonetizacaoMenu;
import java.util.InputMismatchException;

/**
 *
 * @author 691001155
 */
public class MonetizacaoUI {

    public void menu() {
        int opcao = -1;
        do {
            try {
                System.out.println(MonetizacaoMenu.getOpcoes());
                opcao = Console.scanInt("Digite sua opcao:");
                switch (opcao) {
                    case MonetizacaoMenu.OP_DEPOSITO:
                        deposito();
                        break;
                    case MonetizacaoMenu.OP_TRANSFERENCIA:
                        transferencia();
                        break;
                    case MonetizacaoMenu.OP_VISUALIZASALDO:
                        vizualizarSaldo();
                        break;
                    case MonetizacaoMenu.OP_VOLTAR:
                        System.out.println("Retornando a aplicacao..");
                        break;
                    default:
                        System.out.println("Opcao invalida..");
                }
            } catch (InputMismatchException ex) {
                UIUtil.mostrarErro("Somente numeros sao permitidos!");
            }

        } while (opcao != MonetizacaoMenu.OP_VOLTAR);
    }

    private void deposito() {
        /*
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
    

    
                                                  
*/
    }

    public void transferencia() {
        /*
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
        */
    }

    private void vizualizarSaldo() {
       //System.out.println("Seu saldo e de R$ "+cliente.getSaldo());
    }
}
