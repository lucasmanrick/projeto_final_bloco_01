package projeto_final_bloco_01.model;


public abstract class Produto {
	private int id;
	private String marca;
	private String categoria;
	private String caracteristicas;
	private int preco;
	
	public Produto(int id,int preco,String marca, String categoria, String caracteristicas) {
		this.id = id;
		this.preco = preco;
		this.marca = marca;
		this.categoria = categoria;
		this.caracteristicas = caracteristicas;
		
	}
	public int getPreco() {
		return preco;
	}
	public void setPreco(int preco) {
		this.preco = preco;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getmarca() {
		return marca;
	}
	public void setmarca(String marca) {
		this.marca = marca;
	}
	public String getcategoria() {
		return categoria;
	}
	public void setcategoria(String categoria) {
		this.categoria = categoria;
	}
	public String getcaracteristicas() {
		return caracteristicas;
	}
	public void setcaracteristicas(String caracteristicas) {
		this.caracteristicas = caracteristicas;
	}
	
	
	public void visualizarDadosDoProduto () {
		
		System.out.println("******************************");
		System.out.println("        DADOS DO PRODUTO      ");
		System.out.println("******************************");
		System.out.println("Código unico do produto: " + this.id);
		System.out.println("marca do produto: " + this.marca);
		System.out.println("categoria do produto: " + this.categoria);
		System.out.println("Preço do produto: " + this.preco);
		System.out.println("caracteristicas do produto:" + this.caracteristicas);
		
	}
}
