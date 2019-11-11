package br.com.ies.candyShop.enums;

import br.com.ies.candyShop.entity.Cliente;
import br.com.ies.candyShop.entity.Fornecedor;
import br.com.ies.candyShop.entity.Usuario;

public enum PerfilAcesso {
	FORNECEDOR(new Fornecedor()), 
	CLIENTE(new Cliente());

	private Usuario perfilAcesso;

	PerfilAcesso(Usuario perfilAcesso) {
		this.perfilAcesso = perfilAcesso;
	}

	public Usuario getPerfilAcesso() {
		return perfilAcesso;
	}

	public void setPerfilAcesso(Usuario perfilAcesso) {
		this.perfilAcesso = perfilAcesso;
	}
}
