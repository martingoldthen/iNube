package es.upm.dit.isst.inube.dao;

import java.util.Collection;
import java.util.List;

import es.upm.dit.isst.inube.model.Movimiento;

public interface MovimientoDAO {
	public void create(Movimiento movimiento);
	public void delete(Movimiento movimiento);
	public void update(Movimiento movimiento);
	public Movimiento read(int idMovimiento);
	public List<Object[]> readByDay(String idNegocio, String fecha);
	public List<Object[]> competenciaByDay(String idNegocio, String fecha);
	public List<Object[]> readByWeek(String idNegocio, String fechaInicial, String fechaFinal);
	public List<Object[]> competenciaByWeek(String idNegocio, String fechaInicial, String fechaFinal);
	public List<Object[]> readByMonth(String idNegocio, String fecha);
	public List<Object[]> competenciaByMonth(String idNegocio, String fecha);
	public int getCountCompentencia(String idNegocio);
	public Collection<Movimiento> readAll();
	
	
	
	

}
