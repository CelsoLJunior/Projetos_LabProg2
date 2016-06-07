/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package venda.view.menu;

/**
 *
 * @author 691001155
 */
public class RelatorioMenu {
    public static final int OP_PRODVENDIDOS = 1;
    public static final int OP_COMPRASCLIENTE = 2;
    public static final int OP_TOPCLIENTESCOMPRAS = 3;
    public static final int OP_TOPCLIENTESMONETIZA = 4;
    public static final int OP_SAIR = 0;

    public static String getOpcoes() {
        return ("\n--------------------------------------\n"
                + "1- Produtos vendidos\n"
                + "2- Compras feitas pelo cliente\n"
                + "3- Clientes que mais compram\n"
                + "4- Clientes que mais realizam operacoes de monetizacao\n"
                + "0- Sair"
                + "\n--------------------------------------");
    }    
}

