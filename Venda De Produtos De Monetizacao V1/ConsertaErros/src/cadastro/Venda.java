package cadastro;

import java.time.LocalDate;
import java.util.ArrayList;

public class Venda {
	
	private int vendaNumContaCliente;
	private LocalDate dataHoraAtual;
	private ArrayList<Produto> vendaCodProd = new ArrayList<>();
	private ArrayList<Integer> vendaQuantProd = new ArrayList<>();
	
	public Venda(int vendaNumContaCliente, LocalDate dataHoraAtual, Produto vendaCodProd, int vendaQuantProd) {
		this.vendaNumContaCliente = vendaNumContaCliente;
		this.dataHoraAtual = dataHoraAtual;
		this.vendaCodProd.add(vendaCodProd);
		this.vendaQuantProd.add(vendaQuantProd);
	}
	
	public String getVenda() {
		int teste=0;
		String str=""
				+ "\n-> Numero da conta do cliente: "+this.vendaNumContaCliente
				+ "\n	-> Data da venda: "+this.dataHoraAtual
				+ "\n	-> Produtos comprados: ";
				for (Produto produto: vendaCodProd) {
					str+= ""+produto.getProduto();
					str+= "	-> Quantidade: "+vendaQuantProd.get(teste)+"\n";
					teste++;
				}
		return str;
	}
}
