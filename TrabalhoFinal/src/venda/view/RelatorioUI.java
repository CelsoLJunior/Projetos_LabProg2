/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package venda.view;

import venda.util.Console;
import venda.view.menu.RelatorioMenu;
import java.util.InputMismatchException;


/**
 *
 * @author 691001155
 */
public class RelatorioUI {

    public void menu() {
        int opcao = -1;
        do {
            try {
                System.out.println(RelatorioMenu.getOpcoes());
                opcao = Console.scanInt("Digite sua opcao:");
                switch (opcao) {
                    case RelatorioMenu.OP_PRODVENDIDOS:
                        prodVendidos();
                        break;
                    case RelatorioMenu.OP_COMPRASCLIENTE:
                        comprasCliente();
                        break;
                    case RelatorioMenu.OP_TOPCLIENTESCOMPRAS:
                        topClientesCompras();
                        break;
                    case RelatorioMenu.OP_TOPCLIENTESMONETIZA:
                        topClientesMonetiza();
                        break;
                    case RelatorioMenu.OP_VOLTAR:
                        System.out.println("Retornando a aplicacao..");
                        break;
                    default:
                        System.out.println("Opcao invalida..");
                }
            } catch (InputMismatchException ex) {
                UIUtil.mostrarErro("Somente numeros sao permitidos!");
            }

        } while (opcao != RelatorioMenu.OP_VOLTAR);
    }

    private void prodVendidos() {
    	
    }

    public void comprasCliente() {
    	
    }

    private void topClientesCompras() {
        
    }

    private void topClientesMonetiza() {
    	
    }
}
