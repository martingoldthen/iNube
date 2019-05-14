package es.upm.dit.isst.inube.dao;

import java.util.Collection;

import es.upm.dit.isst.inube.model.Negocio;

public interface NegocioDAO {
	public void create(Negocio negocio);
	public void delete(Negocio negocio);
	public void update(Negocio negocio);
	public Negocio read(String cif);
	public Collection<Negocio> readAll();
	
	

}
