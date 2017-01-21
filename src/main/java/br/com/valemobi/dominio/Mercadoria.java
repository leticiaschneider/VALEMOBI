package br.com.valemobi.dominio;

public class Mercadoria {
	private int codigo;
	private String tipoMercad;
	private String nome;
	private int qtde;
	private double preco;
	private String tipoNegoc;
	
	
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getTipoMercad() {
		return tipoMercad;
	}
	public void setTipoMercad(String tipoMercad) {
		this.tipoMercad = tipoMercad;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getQtde() {
		return qtde;
	}
	public void setQtde(int qtde) {
		this.qtde = qtde;
	}
	public double getPreco() {
		return preco;
	}
	public void setPreco(double preco) {
		this.preco = preco;
	}
	public String getTipoNegoc() {
		return tipoNegoc;
	}
	public void setTipoNegoc(String tipoNegoc) {
		this.tipoNegoc = tipoNegoc;
	}
}
