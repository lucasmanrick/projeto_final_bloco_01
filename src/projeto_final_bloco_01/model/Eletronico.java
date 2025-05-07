package projeto_final_bloco_01.model;

public class Eletronico extends Produto {
	String finalidade;
	String usabilidade;
	
	public Eletronico(int id, int preco, String marca, String categoria, String caracteristicas,String finalidade,String usabilidade) {
		super(id, preco, marca, categoria, caracteristicas);
		this.finalidade = finalidade;
		this.usabilidade = usabilidade;
	}

	public String getFinalidade() {
		return finalidade;
	}

	public void setFinalidade(String finalidade) {
		this.finalidade = finalidade;
	}

	public String getUsabilidade() {
		return usabilidade;
	}

	public void setUsabilidade(String usabilidade) {
		this.usabilidade = usabilidade;
	}

	@Override
	public void visualizarDadosDoProduto() {
		super.visualizarDadosDoProduto();
		System.out.println("dados eletronicos: ");
		System.out.println("finalidade:" + this.finalidade);
		System.out.println("usabilidade:" + this.usabilidade);
		System.out.println("******************************");
	}

	
}
