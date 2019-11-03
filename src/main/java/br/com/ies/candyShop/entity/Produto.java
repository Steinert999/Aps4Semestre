package br.com.ies.candyShop.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Produto implements Serializable{
	
	private static final long serialVersionUID = -6581829544617302253L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Integer idProduto;
	
	@ManyToMany(mappedBy = "produtos")
	private List<Fornecedor> fornecedores;
	
	@Column(name = "nm_produto", length = 60)
	private String nmProduto;
	
	@Column(name = "preco_produto", precision = 4, scale = 2)
	private Double precoProduto;
	
	@Column(name = "desc_produto", length = 280)
	private String descProduto;

	public Integer getIdProduto() {
		return idProduto;
	}

	public void setIdProduto(Integer idProduto) {
		this.idProduto = idProduto;
	}

	public List<Fornecedor> getFornecedores() {
		return fornecedores;
	}

	public void setFornecedores(List<Fornecedor> fornecedores) {
		this.fornecedores = fornecedores;
	}

	public String getNmProduto() {
		return nmProduto;
	}

	public void setNmProduto(String nmProduto) {
		this.nmProduto = nmProduto;
	}

	public Double getPrecoProduto() {
		return precoProduto;
	}

	public void setPrecoProduto(Double precoProduto) {
		this.precoProduto = precoProduto;
	}

	public String getDescProduto() {
		return descProduto;
	}

	public void setDescProduto(String descProduto) {
		this.descProduto = descProduto;
	}	
}
