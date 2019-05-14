package es.upm.dit.isst.inube.model;

import java.util.Date;

import javax.persistence.*;

@Entity
public class Movimiento {
	
	@Id
	private int idMovimiento;
	@ManyToOne
	private Cliente idCliente;
	@ManyToOne
	private Negocio idNegocio;
	private double valor;
	private Date fecha;
	
	public Movimiento() {}
	
	public int getIdMovimiento() {
		return idMovimiento;
	}
	public void setIdMovimiento(int idMovimiento) {
		this.idMovimiento = idMovimiento;
	}
	public Cliente getIdCliente() {
		return idCliente;
	}
	public void setIdCliente(Cliente idCliente) {
		this.idCliente = idCliente;
	}
	public Negocio getIdNegocio() {
		return idNegocio;
	}
	public void setIdNegocio(Negocio idNegocio) {
		this.idNegocio = idNegocio;
	}
	public double getValor() {
		return valor;
	}
	public void setValor(double valor) {
		this.valor = valor;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	
	
	
	
	
	
	
}		
