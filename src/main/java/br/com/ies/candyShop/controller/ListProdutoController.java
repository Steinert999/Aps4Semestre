package br.com.ies.candyShop.controller;

import java.util.List;

import org.ocpsoft.rewrite.annotation.Join;
import org.ocpsoft.rewrite.annotation.RequestAction;
import org.ocpsoft.rewrite.el.ELBeanName;
import org.ocpsoft.rewrite.faces.annotation.Deferred;
import org.ocpsoft.rewrite.faces.annotation.IgnorePostback;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import br.com.ies.candyShop.entity.Produto;
import br.com.ies.candyShop.services.ProdutoService;

@Scope(value = "session")
@Component(value = "listaProduto")
@ELBeanName(value = "listaProduto")
@Join(path = "/", to = "/listaProduto.jsf")
public class ListProdutoController {
	
	@Autowired
	private ProdutoService produtoService;
	
	private List<Produto> produtos;
	
	@Deferred
	@RequestAction
	@IgnorePostback
	public void loadData() {
		produtos = produtoService.findAll();
	}
	
	public String deleteById(Long id) {
		produtos.forEach(p -> {
			if(p.getIdProduto().equals(id)) {
				produtoService.delete(p.getIdProduto());
			}
		});
		return "/listaProduto.xhtml?faces-redirect=true";
	}
	public List<Produto> getProdutos(){
		return produtos;
	}
}
