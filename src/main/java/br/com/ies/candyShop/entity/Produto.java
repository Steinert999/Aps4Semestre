package br.com.ies.candyShop.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "produto")
public class Produto implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_produto")
	private Long idProduto;
	
	@Column(name = "nm_produto", length = 60)
	private String nmProduto;
	
	@Column(name = "preco_produto")
	private BigDecimal precoProduto;
	
	@Column(name = "desc_produto", length = 280)
	private String descProduto;
	
	@Lob
	@Column(name = "img_produto")
	private byte[] img_produto;
	
	@ManyToMany(mappedBy = "produtos", targetEntity = Fornecedor.class)
	private List<Fornecedor> fornecedores;
	
	@ManyToMany(mappedBy = "produtos", targetEntity = Pedido.class)
	private List<Pedido> pedidos;

	public Long getIdProduto() {
		return idProduto;
	}

	public void setIdProduto(Long idProduto) {
		this.idProduto = idProduto;
	}

	public String getNmProduto() {
		return nmProduto;
	}

	public void setNmProduto(String nmProduto) {
		this.nmProduto = nmProduto;
	}

	public BigDecimal getPrecoProduto() {
		return precoProduto;
	}

	public void setPrecoProduto(BigDecimal precoProduto) {
		this.precoProduto = precoProduto;
	}

	public String getDescProduto() {
		return descProduto;
	}

	public void setDescProduto(String descProduto) {
		this.descProduto = descProduto;
	}

	public byte[] getImg_produto() {
		return img_produto;
	}

	public void setImg_produto(byte[] img_produto) {
		this.img_produto = img_produto;
	}

	public List<Fornecedor> getFornecedores() {
		return fornecedores;
	}

	public void setFornecedores(List<Fornecedor> fornecedores) {
		this.fornecedores = fornecedores;
	}

	public List<Pedido> getPedidos() {
		return pedidos;
	}

	public void setPedidos(List<Pedido> pedidos) {
		this.pedidos = pedidos;
	}
}
