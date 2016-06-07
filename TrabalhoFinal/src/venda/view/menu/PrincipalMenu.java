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
public class PrincipalMenu {
    public static final int OP_CADASTRARCLIENTE = 1;
    public static final int OP_CADASTRARPROD = 2;
    public static final int OP_MONETIZA = 3;
    public static final int OP_VENDA = 4;
    public static final int OP_RELATORIO = 5;
    public static final int OP_SAIR = 0;

    public static String getOpcoes() {
        return ("\n--------------------------------------\n"
                + "1- Cadastro de clientes\n"
                + "2- Cadastro de produtos\n"
                + "3- Operacoes de monetizacao\n"
                + "4- Venda de produtos com monetizacao\n"
                + "5- Relatorios de vendas\n"
                + "0- Finaliza o programa"
                + "\n--------------------------------------");
    }    
}

