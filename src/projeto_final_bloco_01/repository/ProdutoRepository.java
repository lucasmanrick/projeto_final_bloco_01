package projeto_final_bloco_01.repository;

import java.util.Optional;

import projeto_final_bloco_01.model.Produto;

public interface ProdutoRepository {
	public void procurarPorId (int numero);
	public void listarTodas ();
	public void cadastrar(Produto Produto);
	public void atualizar(int numero, Produto Produto);
	public void deletar	 (int numero);
	public void listarPorMarca (String marca);
	public void listarPorCategoria (String categoria);
	
	
	public Optional<Produto> buscarProdutoNoBd (int num);
}
