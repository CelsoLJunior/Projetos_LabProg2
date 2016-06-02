/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package venda.dominio;

/**
 *
 * @author 691001155
 */
public class Produto {
	private int id, codigo;
	private String nomeProd;
	private Double preco;
	
	public Produto(int codigo, String nomeProd, double preco) {
		this.codigo = codigo;
		this.nomeProd = nomeProd;
		this.preco = preco;
	}
	public Produto(int id, int codigo, String nomeProd, double preco) {
		this.id = id;
		this.codigo = codigo;
		this.nomeProd = nomeProd;
		this.preco = preco;
	}
	public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
	public int getCodigo() {
		return codigo;
	}
	public String getNomeProd() {
        return nomeProd;
	}
    public void setNomeProd(String nomeProd) {
        this.nomeProd = nomeProd;
    }
	public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }    
}
