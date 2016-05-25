package cadastro;

public class Produto {

	private int codigo;
	private String nomeProd;
	private Double preco;
	
	public Produto(int codigo, String nomeProd, double preco) {
		this.codigo = codigo;
		this.nomeProd = nomeProd;
		this.preco = preco;
	}
	
	public String getProduto() {
		String str=""
				+ "\n   -> Codigo: "+this.codigo
				+ "\n	-> Nome: "+this.nomeProd
				+ "\n	-> Preco: R$ "+this.preco+"\n";
		return str;
	}
	
	public int getCodigo() {
		return codigo;
	}
}
