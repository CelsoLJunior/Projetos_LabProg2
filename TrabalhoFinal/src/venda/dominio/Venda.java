/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package venda.dominio;

/**
 *
 * @author texugo
 */
import java.time.LocalDate;
import java.util.ArrayList;

public class Venda {
	
    private int vendaNumContaCliente, id;
    private LocalDate dataHoraAtual;
    private ArrayList<Produto> vendaCodProd = new ArrayList<>();
    private ArrayList<Integer> vendaQuantProd = new ArrayList<>();

    public Venda(int vendaNumContaCliente, LocalDate dataHoraAtual, Produto vendaCodProd, int vendaQuantProd) {
            this.vendaNumContaCliente = vendaNumContaCliente;
            this.dataHoraAtual = dataHoraAtual;
            this.vendaCodProd.add(vendaCodProd);
            this.vendaQuantProd.add(vendaQuantProd);
    }
    public Venda(int id, int vendaNumContaCliente, LocalDate dataHoraAtual, Produto vendaCodProd, int vendaQuantProd) {
            this.id = id;
            this.vendaNumContaCliente = vendaNumContaCliente;
            this.dataHoraAtual = dataHoraAtual;
            this.vendaCodProd.add(vendaCodProd);
            this.vendaQuantProd.add(vendaQuantProd);
    }
}