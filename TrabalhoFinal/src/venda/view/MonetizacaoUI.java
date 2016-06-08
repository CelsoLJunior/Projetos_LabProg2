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
        
    }

    public void transferencia() {
        
    }

    private void vizualizarSaldo() {
       
    }
}
