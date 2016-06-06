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
public class Cliente {

    private int id;
    private String cpf;
    private String nome;
    private String email;
    private int numero_conta;
    private double saldo;

    public Cliente(String cpf, String nome, String email, int numero_conta, double saldo) {
            this.cpf = cpf;
            this.nome = nome;
            this.email = email;
            this.numero_conta = numero_conta;
            this.saldo = saldo;
    }
    public Cliente(int id, String cpf, String nome, String email, int numero_conta, double saldo) {
            this.id = id;
            this.cpf = cpf;
            this.nome = nome;
            this.email = email;
            this.numero_conta = numero_conta;
            this.saldo = saldo;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    public String getCpf() {
        return cpf;
    }
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    public int getNumconta() {
        return numero_conta;
    }

    public void setNumconta(int numconta) {
        this.numero_conta = numconta;
    }
    public Double getSaldo() {
        return saldo;
    }

    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }
}
