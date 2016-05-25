package cadastro;

public class Cliente {
	
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
	
	public int getNumero_conta() {
		return numero_conta;
	}

	public double getSaldo() {
		return saldo;
	}
	public void deposito(Double valor) {
		this.saldo += valor;
	}
	public String getCliente() {
		String str=""
				+ "-> CPF: "+this.cpf
				+ "\n	-> Nome: "+this.nome
				+ "\n	-> E-mail: "+this.email
				+ "\n	-> Numero da conta: "+this.numero_conta
				+ "\n	-> Saldo: R$ "+this.saldo+"\n";
		return str;
	}
}
