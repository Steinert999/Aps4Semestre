package br.com.ies.candyShop.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import br.com.ies.candyShop.entity.Produto;
import br.com.ies.candyShop.repository.ProdutoRepository;

@Service
public class ProdutoService {
	
	@Autowired
	private ProdutoRepository produtoRepository;
	
	public Produto FindProdutoById(Long id) {
		return produtoRepository.findById(id).get();
	}
	
	public List<Produto> findAll(){
		return produtoRepository.findAll();
	}
	

	public void save(Produto cliente) {
		produtoRepository.save(cliente);
	}
	
	public Long countProdutos() {
		return produtoRepository.count();
	}
	
	public boolean exists(Example<Produto> clienteExemplo) {
		if(produtoRepository.exists(clienteExemplo)) {
			return true;
		}
		return false;
	}
	
	public void delete(Long id) {
		produtoRepository.deleteById(id);
	}
	
	public void deleteCliente(Produto cliente) {
		produtoRepository.delete(cliente);
	}
}
