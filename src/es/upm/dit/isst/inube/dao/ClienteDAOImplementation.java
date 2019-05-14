package es.upm.dit.isst.inube.dao;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;

import es.upm.dit.isst.inube.model.Cliente;


public class ClienteDAOImplementation implements ClienteDAO {
	private static  ClienteDAOImplementation instance = null;
	private ClienteDAOImplementation() {}
	public static ClienteDAOImplementation getInstance() {
		if( null == instance ) {
			 instance = new ClienteDAOImplementation();
		  }
		  return instance;
	}
	public void create(Cliente cliente) {
		Session session = SessionFactoryService.get().openSession();
		session.beginTransaction();
		session.save(cliente);
		session.getTransaction().commit();
		session.close();
		
	}
	public Cliente read(int idCliente) {
		Session session = SessionFactoryService.get().openSession();
		session.beginTransaction();
		Cliente cliente = session.load( Cliente.class, idCliente );
		session.getTransaction().commit();
		session.close();
		return cliente;
	}
	public void update(Cliente cliente) {
		Session session = SessionFactoryService.get().openSession();
		session.beginTransaction();
		session.saveOrUpdate( cliente );
		session.getTransaction().commit();
		session.close();
		
	}
	public void delete(Cliente cliente) {
		Session session = SessionFactoryService.get().openSession();
		session.beginTransaction();
		session.delete(cliente);
		session.getTransaction().commit();
		session.close();
		
	}
	public Collection<Cliente> readAll(){
		Session session = SessionFactoryService.get().openSession();
		session.beginTransaction();
		Collection<Cliente> clientes = session.createQuery( "from Cliente" ).list();
		session.getTransaction().commit();
		session.close();
		return clientes;
	}
	
	public List<double[]> readByEdad(String idNegocio) {
		Session session = SessionFactoryService.get().openSession();
		int rango1 = ((Number)session.createSQLQuery("SELECT count(*) FROM cliente INNER JOIN negocio ON negocio.cif = '"+idNegocio+"' and cliente.edad <=25").getSingleResult()).intValue();
		int rango2 = ((Number)session.createSQLQuery("SELECT count(*) FROM cliente INNER JOIN negocio ON negocio.cif = '"+idNegocio+"' and cliente.edad >=25 and cliente.edad <=36").getSingleResult()).intValue();
		int rango3 = ((Number)session.createSQLQuery("SELECT count(*) FROM cliente INNER JOIN negocio ON negocio.cif = '"+idNegocio+"' and cliente.edad >=37 and cliente.edad <=50").getSingleResult()).intValue();
		int rango4 = ((Number)session.createSQLQuery("SELECT count(*) FROM cliente INNER JOIN negocio ON negocio.cif = '"+idNegocio+"' and cliente.edad >=51").getSingleResult()).intValue();
		double[] valores = new double[4];
		valores[0]=(double)rango1;
		valores[1]=(double)rango2;
		valores[2]=(double)rango3;
		valores[3]=(double)rango4;
		
		double totalClientes= valores[0]+ valores[1]+valores[2]+valores[3];
		double rango1perc = valores[0]/totalClientes;
		double rango2perc = valores[1]/totalClientes;
		double rango3perc = valores[2]/totalClientes;
		double rango4perc = valores[3]/totalClientes;
		double[] porcentajerangos= new double[4];
		porcentajerangos[0]= rango1perc*100;
		porcentajerangos[1]= rango2perc*100;
		porcentajerangos[2]= rango3perc*100;
		porcentajerangos[3]= rango4perc*100;
		List<double[]> lista= new ArrayList<>();
		lista.add(valores);
		lista.add(porcentajerangos);
		return lista;
	
	}	

	/*public List<Object[]> readByVisitas(String idNegocio){
		Session session = SessionFactoryService.get().openSession();
		Query query = session.createSQLQuery("select count(*) from movimiento inner join cliente on movimiento.idnegocio_cif='"+idNegocio+"' and fecha like '2019-01%' group by idcliente_idcliente");
		session.beginTransaction();
		List<Object[]> out= query.getResultList();
		session.getTransaction().commit();
		session.close();
		return  out;
		
	}*/
	public List<Object[]> readByVisitas(String idNegocio){
		Session session = SessionFactoryService.get().openSession();
		Query query = session.createSQLQuery("select count(*) from MOVIMIENTO where IDNEGOCIO_CIF ='"+idNegocio+"'  group by IDCLIENTE_IDCLIENTE");
		session.beginTransaction();
		List<Object[]> out= query.getResultList();
		session.getTransaction().commit();
		session.close();
		return  out;
		
	}

}


