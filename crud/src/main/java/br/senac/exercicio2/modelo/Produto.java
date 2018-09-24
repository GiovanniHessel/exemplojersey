package br.senac.exercicio2.modelo;

public class Produto {
	
	private int id;
	private String nome;
	private String marca;
	private String estoque;
	private double valorVenda;
	
	
	public Produto() {
		this.id = 0;
		this.nome = "";
		this.marca = "";
		this.estoque = "";
		this.valorVenda = 0;
	}
	
	
	public Produto(int id, String nome, String marca, String estoque, double valorVenda) {
		this.id = id;
		this.nome = nome;
		this.marca = marca;
		this.estoque = estoque;
		this.valorVenda = valorVenda;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public String getEstoque() {
		return estoque;
	}
	public void setEstoque(String estoque) {
		this.estoque = estoque;
	}
	public double getValorVenda() {
		return valorVenda;
	}
	public void setValorVenda(double valorVenda) {
		this.valorVenda = valorVenda;
	}
	public void setProduto(Produto produto) {
		this.id = produto.getId();
		this.nome = produto.getNome();
		this.marca = produto.getMarca();
		this.estoque = produto.getEstoque();
		this.valorVenda = produto.getValorVenda();
	}
	
}
