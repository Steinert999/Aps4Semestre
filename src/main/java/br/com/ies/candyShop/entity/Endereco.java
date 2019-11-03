package br.com.ies.candyShop.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "endereco")
public class Endereco implements Serializable{
	
	private static final long serialVersionUID = -7357340241870698796L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "id_endereco")
	private Integer idEndereco;
	
	@ManyToOne
	@JoinColumn(referencedColumnName = "cd_estado", name = "cd_estado")
	private Estados estado;
	
	@Column(name = "nm_bairro")
	private String nmBairro;
	
	@Column(name = "nu_cep", length = 8)
	private String nuCep;
	
	@Column(name = "nm_rua", length = 50)
	private String nmRua;
	
	@Column(name = "nu_casa")
	private Integer nuCasa;

	public Integer getIdEndereco() {
		return idEndereco;
	}

	public void setIdEndereco(Integer idEndereco) {
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

	public Integer getNuCasa() {
		return nuCasa;
	}

	public void setNuCasa(Integer nuCasa) {
		this.nuCasa = nuCasa;
	}
}
