package br.com.ies.candyShop.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.validation.constraints.Email;

@Entity
@Table(name = "fornecedor")
@ PrimaryKeyJoinColumn(referencedColumnName = "id_usuario")
public class Fornecedor extends Usuario {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@ManyToMany
	@JoinColumn(referencedColumnName = "id_endereco")
	@Column(name = "id_endereco")
	private List<Endereco> enderecos;
	
	@Column(name = "nm_fornecedor", length = 80)
	private String nmFornecedor;
	
	@Column(name = "tel_fornecedor", length = 10)
	private String telFornecedor;
	
	@Column(name = "email_fornecedor")
	@Email
	private String emailFornecedor;
	
	@Column(name = "senha_fornecedor")
	private String senhaFornecedor;
	
	@Column(name = "nm_contato")
	private String nmContato;
	
	@ManyToMany
	@JoinColumn(referencedColumnName = "id_produtos", name = "id_produtos")
	private List<Produto> produtos;
	

	public String getSenhaFornecedor() {
		return senhaFornecedor;
	}

	public void setSenhaFornecedor(String senhaFornecedor) {
		this.senhaFornecedor = senhaFornecedor;
	}

	public List<Endereco> getEnderecos() {
		return enderecos;
	}

	public void setEnderecos(List<Endereco> enderecos) {
		this.enderecos = enderecos;
	}

	public String getNmFornecedor() {
		return nmFornecedor;
	}

	public void setNmFornecedor(String nmFornecedor) {
		this.nmFornecedor = nmFornecedor;
	}

	public String getTelFornecedor() {
		return telFornecedor;
	}

	public void setTelFornecedor(String telFornecedor) {
		this.telFornecedor = telFornecedor;
	}

	public String getEmailFornecedor() {
		return emailFornecedor;
	}

	public void setEmailFornecedor(String emailFornecedor) {
		this.emailFornecedor = emailFornecedor;
	}

	public String getNmContato() {
		return nmContato;
	}

	public void setNmContato(String nmContato) {
		this.nmContato = nmContato;
	}

	public List<Produto> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}
}
