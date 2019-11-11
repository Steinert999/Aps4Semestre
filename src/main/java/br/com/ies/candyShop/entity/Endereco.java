package br.com.ies.candyShop.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "endereco")
public class Endereco implements Serializable{
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_endereco")
	private Long idEndereco;
	
	@ManyToOne
	@JoinColumn(referencedColumnName = "cd_estado", name = "cd_estado")
	private Estados estado;
	
	@Column(name = "nm_bairro")
	private String nmBairro;
	
	@Column(name = "nu_cep", length = 8)
	private String nuCep;
	
	@Column(name = "nm_rua", length = 50)
	private String nmRua;
	
	@Column(name = "nu_logradouro")
	private Integer nuLogradouro;
	
	@OneToMany(mappedBy = "endereco", targetEntity = Usuario.class)
	private List<Usuario> usuarios;

	public Long getIdEndereco() {
		return idEndereco;
	}

	public void setIdEndereco(Long idEndereco) {
		this.idEndereco = idEndereco;
	}

	public Estados getEstado() {
		return estado;
	}

	public void setEstado(Estados estado) {
		this.estado = estado;
	}

	public String getNmBairro() {
		return nmBairro;
	}

	public void setNmBairro(String nmBairro) {
		this.nmBairro = nmBairro;
	}

	public String getNuCep() {
		return nuCep;
	}

	public void setNuCep(String nuCep) {
		this.nuCep = nuCep;
	}

	public String getNmRua() {
		return nmRua;
	}

	public void setNmRua(String nmRua) {
		this.nmRua = nmRua;
	}

	public List<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	public Integer getNuLogradouro() {
		return nuLogradouro;
	}

	public void setNuLogradouro(Integer nuLogradouro) {
		this.nuLogradouro = nuLogradouro;
	}

}
