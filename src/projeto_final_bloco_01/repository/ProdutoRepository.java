package projeto_final_bloco_01.repository;

import projeto_final_bloco_01.model.Produto;

public interface ProdutoRepository {
	public void procurarPorNumero (int numero);
	public void listarTodas ();
	public void cadastrar(Produto Produto);
	public void atualizar(Produto Produto);
	public void deletar	 (int numero);
	public void listarPorMarca (String marca);
	
}
