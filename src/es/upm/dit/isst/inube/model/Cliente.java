package es.upm.dit.isst.inube.model;

import java.util.Collection;


import javax.persistence.*;

@Entity
public class Cliente {

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + cp;
		result = prime * result + edad;
		result = prime * result + idCliente;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cliente other = (Cliente) obj;
		if (cp != other.cp)
			return false;
		if (edad != other.edad)
			return false;
		if (idCliente != other.idCliente)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Cliente [idCliente=" + idCliente + ", cp=" + cp + ", edad=" + edad + "]";
	}

	@Id
	private int idCliente;
	private int cp;
	private int edad;
	@OneToMany (mappedBy="idCliente", fetch = FetchType.LAZY)
	private Collection<Movimiento> movimientosCliente;
	
	public Cliente() {}

	public int getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}

	public int getCp() {
		return cp;
	}

	public void setCp(int cp) {
		this.cp = cp;
	}

	public Collection<Movimiento> getMovimientosCliente() {
		return movimientosCliente;
	}

	public void setMovimientosCliente(Collection<Movimiento> movimientosCliente) {
		this.movimientosCliente = movimientosCliente;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}
	
}
