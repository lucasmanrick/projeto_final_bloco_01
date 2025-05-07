package projeto_final_bloco_01.model;

public class Mobilia extends Produto{

	private double largura;
	private double altura;
	private double profundidade;
	private double peso;
	
	
	public Mobilia(int id, double preco, String marca, String categoria, String caracteristicas,int tipoProd, double largura, double altura, double profundidade, double peso) {
		super(id, preco, marca, categoria, caracteristicas, tipoProd);
		this.largura = largura;
		this.altura = altura;
		this.profundidade = profundidade;
		this.peso = peso;
	}


	
	
	public double getLargura() {
		return largura;
	}

	public void setLargura(double largura) {
		this.largura = largura;
	}

	public double getAltura() {
		return altura;
	}

	public void setAltura(double altura) {
		this.altura = altura;
	}

	public double getProfundidade() {
		return profundidade;
	}

	public void setProfundidade(double profundidade) {
		this.profundidade = profundidade;
	}

	public double getPeso() {
		return peso;
	}

	public void setPeso(double peso) {
		this.peso = peso;
	}

	@Override
	public void visualizarDadosDoProduto() {
		super.visualizarDadosDoProduto();
		
		System.out.println("Dados Técnicos");
		System.out.println("altura: " + this.altura);
		System.out.println("largura: " + this.largura);
		System.out.println("profundidade: " + this.profundidade);
		System.out.println("peso: " + this.peso);
		System.out.println("******************************");
	}
	

}
