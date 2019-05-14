package es.upm.dit.isst.inube.dao;

import java.util.Collection;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.SQLQuery;
import org.hibernate.Session;

import es.upm.dit.isst.inube.model.Movimiento;
import es.upm.dit.isst.inube.model.Negocio;

public class MovimientoDAOImplementation implements MovimientoDAO {
	private static  MovimientoDAOImplementation instance = null;
	private MovimientoDAOImplementation() {}
	public static MovimientoDAOImplementation getInstance() {
		if( null == instance ) {
			 instance = new MovimientoDAOImplementation();
		  }
		  return instance;
	}
	public void create(Movimiento movimiento) {
		Session session = SessionFactoryService.get().openSession();
		session.beginTransaction();
		session.save(movimiento);
		session.getTransaction().commit();
		session.close();
		
	}
	public Movimiento read(int idMovimiento) {
		Session session = SessionFactoryService.get().openSession();
		session.beginTransaction();
		Movimiento movimiento = session.load( Movimiento.class, idMovimiento );
		session.getTransaction().commit();
		session.close();
		return  movimiento;
	}
	
	public List<Object[]> readByDay(String idNegocio, String fecha) {
		Session session = SessionFactoryService.get().openSession();
		Query query = session.createSQLQuery("select fecha, valor from movimiento where idnegocio_cif='"+idNegocio+"' and fecha like '"+fecha+"%'");
		session.beginTransaction();
		List<Object[]> out= query.getResultList();
		session.getTransaction().commit();
		session.close();
		return  out;
	}
	
	public List<Object[]> competenciaByDay(String idNegocio, String fecha){
		Session session = SessionFactoryService.get().openSession();
		List<Object[]> lista = null;
		NegocioDAO mdao = NegocioDAOImplementation.getInstance();
		Negocio n = mdao.read(idNegocio);
		String q = "SELECT fecha, valor FROM movimiento INNER JOIN negocio ON negocio.cp = '"+n.getCp()+"' and movimiento.fecha like '"+fecha+"%' and negocio.cif = movimiento.idnegocio_cif ";
		try {
			session.beginTransaction();
			lista = session.createSQLQuery(q).list();
			session.getTransaction().commit();
		}catch(Exception e) {
			System.out.print(e);
		}finally {
			session.close();
		}
		return lista;
	}
	
	public List<Object[]> readByWeek(String idNegocio, String fechaInicial, String fechaFinal) {
		Session session = SessionFactoryService.get().openSession();
		Query query = session.createSQLQuery("select fecha, valor from movimiento where idnegocio_cif='"+idNegocio+"' and fecha >= '"+fechaInicial+"' and fecha <= '"+fechaFinal+"'");
		session.beginTransaction();
		List<Object[]> out= query.getResultList();
		session.getTransaction().commit();
		session.close();
		return  out;
	}
	
	public List<Object[]> competenciaByWeek(String idNegocio, String fechaInicial, String fechaFinal) {
		Session session = SessionFactoryService.get().openSession();
		List<Object[]> lista = null;
		NegocioDAO mdao = NegocioDAOImplementation.getInstance();
		Negocio n = mdao.read(idNegocio);
		String q = "SELECT fecha, valor FROM movimiento INNER JOIN negocio ON negocio.cp = '"+n.getCp()+"' and movimiento.fecha >= '"+fechaInicial+"' and movimiento.fecha <= '"+fechaFinal+"'and negocio.cif = movimiento.idnegocio_cif";
		try {
			session.beginTransaction();
			lista = session.createSQLQuery(q).getResultList();
			session.getTransaction().commit();
		}catch(Exception e) {
			System.out.print(e);
		}finally {
			session.close();
		}
		return lista;
	}
	
	public List<Object[]> readByMonth(String idNegocio, String fecha) {
		Session session = SessionFactoryService.get().openSession();
		Query query = session.createSQLQuery("select fecha, valor from movimiento where idnegocio_cif='"+idNegocio+"' and fecha like '"+fecha+"%' ");
		session.beginTransaction();
		List<Object[]> out= query.getResultList();
		session.getTransaction().commit();
		session.close();
		return  out;
	}
	
	public List<Object[]> competenciaByMonth(String idNegocio, String fecha) {
		Session session = SessionFactoryService.get().openSession();
		List<Object[]> lista = null;
		NegocioDAO mdao = NegocioDAOImplementation.getInstance();
		Negocio n = mdao.read(idNegocio);
		String q = "SELECT fecha, valor FROM movimiento INNER JOIN negocio ON negocio.cp = '"+n.getCp()+"' and movimiento.fecha like '"+fecha+"%' and negocio.cif = movimiento.idnegocio_cif ";		
		try {
			session.beginTransaction();
			lista = session.createSQLQuery(q).getResultList();
			session.getTransaction().commit();
		}catch(Exception e) {
			System.out.print(e);
		}finally {
			session.close();
		}
		return lista;
		
	}
	
	public int getCountCompentencia(String idNegocio) {
		Session session = SessionFactoryService.get().openSession();
		int count = 0;
		NegocioDAO ndao = NegocioDAOImplementation.getInstance();
		Negocio n = ndao.read(idNegocio);
		String q = "select count (*) from Negocio where cp = '"+n.getCp()+"'";
		
		try {
			session.beginTransaction();
			count = ((Number)session.createQuery(q).getSingleResult()).intValue();
			session.getTransaction().commit();
		}catch (Exception e) {
			System.out.print(e);
		}finally {
			session.close();
		}
		return count;
	}
	
	public List<Object[]> readGasto(String idNegocio){
		Session session = SessionFactoryService.get().openSession();
		Query query = session.createSQLQuery("select sum(valor),count(*) from MOVIMIENTO  where IDNEGOCIO_CIF ='"+idNegocio+"' group by IDCLIENTE_IDCLIENTE");
		session.beginTransaction();
		List<Object[]> out= query.getResultList();
		session.getTransaction().commit();
		session.close();
		return  out;
		
	}
	
	public void update(Movimiento movimiento) {
		Session session = SessionFactoryService.get().openSession();
		session.beginTransaction();
		session.saveOrUpdate(movimiento);
		session.getTransaction().commit();
		session.close();
		
	}
	public void delete(Movimiento movimiento) {
		Session session = SessionFactoryService.get().openSession();
		session.beginTransaction();
		session.delete(movimiento);
		session.getTransaction().commit();
		session.close();
		
	}
	public Collection<Movimiento> readAll(){
		Session session = SessionFactoryService.get().openSession();
		session.beginTransaction();
		Collection<Movimiento> movimientos = session.createQuery( "from Movimiento" ).list();
		session.getTransaction().commit();
		session.close();
		return movimientos;
	}
	
	











}
