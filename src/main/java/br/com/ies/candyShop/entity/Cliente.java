package br.com.ies.candyShop.entity;

import java.io.Serializable;
import java.util.Calendar;
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
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Email;

@Entity
@Table(name = "cliente")
public class Cliente implements Serializable{
	
	private static final long serialVersionUID = -2650952962414970810L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "id_cliente")
	private Integer idCliente;
	
	@Column(name = "email_cliente")
	@Email
	private String emailCliente;
	
	@Column(name = "senha_cliente")
	private String senhaCliente;
	
	@Column(name = "nm_cliente", length = 80)
	private String nmCliente;
	
	@Column(name = "tel_cliente", length = 10)
	private String telCliente;
		
	@Temporal(TemporalType.DATE)
	@Column(name = "dt_virou_cliente")
	private Calendar dtVirouCliente;
	
	@ManyToOne
	@JoinColumn(referencedColumnName = "id_endereco", name = "id_endereco")
	private Endereco endereco;
	
	
	@OneToMany(mappedBy = "cliente", targetEntity = Pedido.class, cascade = CascadeType.ALL)
	private List<Pedido> pedidos;


	public Integer getIdCliente() {
		return idCliente;
	}


	public void setIdCliente(Integer idCliente) {
		this.idCliente = idCliente;
	}


	public String getEmailCliente() {
		return emailCliente;
	}


	public void setEmailCliente(String emailCliente) {
		this.emailCliente = emailCliente;
	}


	public String getSenhaCliente() {
		return senhaCliente;
	}


	public void setSenhaCliente(String senhaCliente) {
		this.senhaCliente = senhaCliente;
	}


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


	public Calendar getDtVirouCliente() {
		return dtVirouCliente;
	}


	public void setDtVirouCliente(Calendar dtVirouCliente) {
		this.dtVirouCliente = dtVirouCliente;
	}


	public Endereco getEndereco() {
		return endereco;
	}


	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}


	public List<Pedido> getPedidos() {
		return pedidos;
	}


	public void setPedidos(List<Pedido> pedidos) {
		this.pedidos = pedidos;
	}	
}
