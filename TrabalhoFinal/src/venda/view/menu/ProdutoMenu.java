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
public class ProdutoMenu {
    public static final int OP_CADASTRAR = 1;
    public static final int OP_DELETAR = 2;
    public static final int OP_ATUALIZAR = 3;
    public static final int OP_LISTAR = 4;
    public static final int OP_CONSULTAR = 5;
    public static final int OP_SAIR = 0;

    public static String getOpcoes() {
        return ("\n--------------------------------------\n"
                + "1- Cadastrar Produtos\n"
                + "2- Deletar Produto\n"
                + "3- Atualizar dados do Produto\n"
                + "4- Listar Produtos\n"
                + "5- Consultar Produtos por Nome\n"
                + "0- Voltar"
                + "\n--------------------------------------");
    }    
}

