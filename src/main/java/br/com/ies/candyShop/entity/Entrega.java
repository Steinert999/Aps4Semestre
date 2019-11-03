	package br.com.ies.candyShop.entity;

import java.io.Serializable;
import java.util.Calendar;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "entrega")
public class Entrega implements Serializable{
	
	private static final long serialVersionUID = 6145471655632093685L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE )
	@Column(name = "id_entrega")
	private Integer idEntrega;
	
	@ManyToOne
	@JoinColumn(referencedColumnName = "id_empregado", name = "id_empregado")
	private Empregado empregado;
	
	@OneToMany(mappedBy = "entrega", targetEntity = Pedido.class)
	private List<Pedido> pedidos;
	
	@Column(name = "st_entregue")
	private Boolean stEntregue;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "dt_entrega")
	private Calendar dtEntrega;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "prz_entrega")
	private Calendar przEntrega;

	public Integer getIdEntrega() {
		return idEntrega;
	}

	public void setIdEntrega(Integer idEntrega) {
		this.idEntrega = idEntrega;
	}

	public Empregado getEmpregado() {
		return empregado;
	}

	public void setEmpregado(Empregado empregado) {
		this.empregado = empregado;
	}

	public List<Pedido> getPedido() {
		return pedidos;
	}

	public void setPedido(List<Pedido> pedidos) {
		this.pedidos = pedidos;
	}

	public Boolean getStEntregue() {
		return stEntregue;
	}

	public void setStEntregue(Boolean stEntregue) {
		this.stEntregue = stEntregue;
	}

	public Calendar getDtEntrega() {
		return dtEntrega;
	}

	public void setDtEntrega(Calendar dtEntrega) {
		this.dtEntrega = dtEntrega;
	}

	public Calendar getPrzEntrega() {
		return przEntrega;
	}

	public void setPrzEntrega(Calendar przEntrega) {
		this.przEntrega = przEntrega;
	}
}
