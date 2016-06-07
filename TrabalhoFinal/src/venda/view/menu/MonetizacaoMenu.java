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
public class MonetizacaoMenu {
    public static final int OP_DEPOSITO = 1;
    public static final int OP_TRANSFERENCIA = 2;
    public static final int OP_VISUALIZASALDO = 3;
    public static final int OP_VOLTAR = 0;

    public static String getOpcoes() {
        return ("\n--------------------------------------\n"
                + "1- Deposito\n"
                + "2- Trasferencia\n"
                + "3- Visualizar saldo\n"
                + "0- Voltar"
                + "\n--------------------------------------");
    }    
}

