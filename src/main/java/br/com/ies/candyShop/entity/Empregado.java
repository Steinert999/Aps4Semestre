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
@Table(name = "empregado")
public class Empregado implements Serializable{
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_empregado")
	private Long idEmpregado;
	
	@ManyToOne
	@JoinColumn(referencedColumnName = "id_endereco", name = "id_endereco")
	private Endereco endereco;
	
	@Column(name = "nm_empregado", length = 80)
	private String nmEmpregado;
	
	@Column(name = "tel_empregado", length = 10)
	private String telEmpregado;
	
	@OneToMany(mappedBy = "empregado", targetEntity = Entrega.class)
	private List<Entrega> entregas;

	public Long getIdEmpregado() {
		return idEmpregado;
	}

	public void setIdEmpregado(Long idEmpregado) {
		this.idEmpregado = idEmpregado;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public String getNmEmpregado() {
		return nmEmpregado;
	}

	public void setNmEmpregado(String nmEmpregado) {
		this.nmEmpregado = nmEmpregado;
	}

	public String getTelEmpregado() {
		return telEmpregado;
	}

	public void setTelEmpregado(String telEmpregado) {
		this.telEmpregado = telEmpregado;
	}

	public List<Entrega> getEntregas() {
		return entregas;
	}

	public void setEntregas(List<Entrega> entregas) {
		this.entregas = entregas;
	}	
}
