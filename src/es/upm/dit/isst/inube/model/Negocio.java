package es.upm.dit.isst.inube.model;

import java.util.Collection;

import javax.persistence.*;
@Entity
public class Negocio {

		@Id
		private String cif;	
		private String nombre;
		private String password;
		private int cp;
		private String tipo;
		@OneToMany (mappedBy="idNegocio", fetch = FetchType.LAZY)
		private Collection<Movimiento> movimientosNegocio; 
		private String nombreContacto;
		private String apellidosContacto;
		private String emailContacto;
		private String telefonoContacto;
		
		public Negocio() {}

		public String getNombre() {
			return nombre;
		}

		public void setNombre(String nombre) {
			this.nombre = nombre;
		}

		public String getCif() {
			return cif;
		}

		public void setCif(String cif) {
			this.cif = cif;
		}

		public int getCp() {
			return cp;
		}

		public void setCp(int cp) {
			this.cp = cp;
		}

		public String getTipo() {
			return tipo;
		}

		public void setTipo(String tipo) {
			this.tipo = tipo;
		}

		public Collection<Movimiento> getMovimientosNegocio() {
			return movimientosNegocio;
		}

		public void setMovimientosNegocio(Collection<Movimiento> movimientosNegocio) {
			this.movimientosNegocio = movimientosNegocio;
		}

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}

		public String getNombreContacto() {
			return nombreContacto;
		}

		public void setNombreContacto(String nombreContacto) {
			this.nombreContacto = nombreContacto;
		}

		public String getApellidosContacto() {
			return apellidosContacto;
		}

		public void setApellidosContacto(String apellidosContacto) {
			this.apellidosContacto = apellidosContacto;
		}

		public String getEmailContacto() {
			return emailContacto;
		}

		public void setEmailContacto(String emailContacto) {
			this.emailContacto = emailContacto;
		}

		public String getTelefonoContacto() {
			return telefonoContacto;
		}

		public void setTelefonoContacto(String telefonoContacto) {
			this.telefonoContacto = telefonoContacto;
		}
	

}