package es.upm.dit.isst.inube.dao;



import java.util.Collection;

import org.hibernate.Session;

import es.upm.dit.isst.inube.model.Negocio;

public class NegocioDAOImplementation implements NegocioDAO {
	private static  NegocioDAOImplementation instance = null;
	private NegocioDAOImplementation() {}
	public static NegocioDAOImplementation getInstance() {
		if( null == instance ) {
			 instance = new NegocioDAOImplementation();
		  }
		  return instance;
	}
	public void create(Negocio negocio) {
			Session session = SessionFactoryService.get().openSession();
			session.beginTransaction();
			session.save(negocio);
			session.getTransaction().commit();
			session.close();
			
	}
	public Negocio read(String cif) {
			Session session = SessionFactoryService.get().openSession();
			session.beginTransaction();
			Negocio negocio = session.get( Negocio.class, cif );
			session.getTransaction().commit();
			session.close();
			return negocio;
	}
	public void update(Negocio negocio) {
			Session session = SessionFactoryService.get().openSession();
			session.beginTransaction();
			session.saveOrUpdate( negocio );
			session.getTransaction().commit();
			session.close();
			
	}
	public void delete(Negocio negocio) {
			Session session = SessionFactoryService.get().openSession();
			session.beginTransaction();
			session.delete(negocio);
			session.getTransaction().commit();
			session.close();
			
	}
	public Collection<Negocio> readAll(){
			Session session = SessionFactoryService.get().openSession();
			session.beginTransaction();
			Collection<Negocio> negocios = session.createQuery( "from Negocio" ).list();
			session.getTransaction().commit();
			session.close();
			return negocios;
	}
		
	}


