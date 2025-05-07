package projeto_final_bloco_01.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import projeto_final_bloco_01.model.Produto;
import projeto_final_bloco_01.repository.ProdutoRepository;


public class ProdutoController implements ProdutoRepository{
	private ArrayList<Produto> bdProdutos = new ArrayList<Produto>(); // funcionará como se fosse nosso banco de dados.

		
	
	int numero = 0;
	
	public int gerarID() {
		return ++numero;
	}

	@Override
	public void procurarPorId(int numero) {
		
		Optional<Produto> verifyExistence = buscarProdutoNoBd(numero);
		if (verifyExistence.isPresent()) {
			verifyExistence.get().visualizarDadosDoProduto();
		}
	}

	@Override
	public void listarTodas() {
		bdProdutos.stream()
			.forEach(e -> e.visualizarDadosDoProduto());	;
	}

	@Override
	public void cadastrar(Produto Produto) {
		bdProdutos.add(Produto);
		System.out.println("Novo Produto cadastrado com sucesso!");
	}

	@Override
	public void atualizar(int numero, Produto Produto) {
		Optional<Produto> verifyExistence = buscarProdutoNoBd(numero);
		if (verifyExistence.isPresent()) {
			bdProdutos.set(bdProdutos.indexOf(verifyExistence.get()), Produto);
			System.out.println("Dados atualizados com sucesso!");
		}
	}

	@Override
	public void deletar(int numero) {
		Optional<Produto> verifyExistence = buscarProdutoNoBd(numero);
		if (verifyExistence.isPresent()) {
			bdProdutos.remove(bdProdutos.indexOf(verifyExistence.get()));
			System.out.println("Produto com id" + numero + "foi removido do catalogo!");
		}
		
	}

	@Override
	public void listarPorMarca(String marca) {
		List<Produto> found = bdProdutos.stream()
				.filter(p -> p.getmarca().toUpperCase().contains(marca.toUpperCase()))
				.collect(Collectors.toList());
				
				if(found.isEmpty()) {
					System.out.println("Não foi identificado nenhum produto com o id especificado.");
				}
				found.forEach(e -> e.visualizarDadosDoProduto());
		
	}

	
	@Override
	public void listarPorCategoria(String categoria) {
		List<Produto> found = bdProdutos.stream()
				.filter(p -> p.getmarca().toUpperCase().contains(categoria.toUpperCase()))
				.collect(Collectors.toList());
				
				if(found.isEmpty()) {
					System.out.println("Não foi identificado nenhum produto com o id especificado.");
				}
				found.forEach(e -> e.visualizarDadosDoProduto());
		
	}
	
	@Override
	public Optional<Produto> buscarProdutoNoBd(int num) {
		Optional<Produto> found = bdProdutos.stream()
				.filter(p -> p.getId() == numero)
				.findAny();
				
				if(found.isEmpty()) {
					System.out.println("Não foi identificado nenhum produto com o id especificado.");
					return Optional.empty();
				}
				return found;
	}

}
