package br.com.ies.candyShop.controller;

import java.io.IOException;

import javax.faces.context.FacesContext;

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
	
	public Produto findProduto (Long id) {
		this.produto = produtoService.FindProdutoById(id);
		if(this.produto != null) {
			try {
				FacesContext.getCurrentInstance().getExternalContext().redirect("/formProduto.jsf");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return this.produto;
		}
		return null;	
	}

}
