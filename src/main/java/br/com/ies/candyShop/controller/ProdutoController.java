package br.com.ies.candyShop.controller;

import org.ocpsoft.rewrite.annotation.Join;
import org.ocpsoft.rewrite.el.ELBeanName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import br.com.ies.candyShop.entity.Produto;
import br.com.ies.candyShop.services.ProdutoService;

@Scope(value = "session")
@Component(value = "controlProduto")
@ELBeanName(value = "controlProduto")
@Join(path = "/produto", to = "/formProduto.jsf")
public class ProdutoController {
	
	@Autowired
	private ProdutoService produtoService;
	
	private Produto produto = new Produto();
	
	public String save() {
		produtoService.save(produto);
		produto = new Produto();
		return "/listaProduto.xhtml?faces-redirect=true";
	}
	
	public Produto getProduto() {
		return produto;
	}

}
