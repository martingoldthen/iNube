package es.upm.dit.isst.inube.dao;

import java.util.Collection;

import es.upm.dit.isst.inube.model.Cliente;

public interface ClienteDAO {
	public void create(Cliente cliente);
	public void delete(Cliente cliente);
	public void update(Cliente cliente);
	public Cliente read(int idCliente);
	public Collection<Cliente> readAll();
	

}
