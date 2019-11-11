package br.com.ies.candyShop.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "cliente")
@PrimaryKeyJoinColumn(referencedColumnName = "id_usuario")
public class Cliente extends Usuario {
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Column(name = "nm_cliente", length = 80)
	private String nmCliente;
	
	@Column(name = "tel_cliente", length = 11)
	private String telCliente;
		
	@Temporal(TemporalType.DATE)
	@Column(name = "dt_virou_cliente")
	private Date dtVirouCliente;
	
	
	@OneToMany(mappedBy = "cliente", targetEntity = Pedido.class, cascade = CascadeType.ALL)
	private List<Pedido> pedidos;


	public String getNmCliente() {
		return nmCliente;
	}


	public void setNmCliente(String nmCliente) {
		this.nmCliente = nmCliente;
	}


	public String getTelCliente() {
		return telCliente;
	}


	public void setTelCliente(String telCliente) {
		this.telCliente = telCliente;
	}


	public Date getDtVirouCliente() {
		return dtVirouCliente;
	}


	public void setDtVirouCliente(Date date) {
		this.dtVirouCliente = date;
	}


	public List<Pedido> getPedidos() {
		return pedidos;
	}


	public void setPedidos(List<Pedido> pedidos) {
		this.pedidos = pedidos;
	}
	
}
