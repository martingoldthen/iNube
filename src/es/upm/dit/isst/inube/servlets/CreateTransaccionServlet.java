package es.upm.dit.isst.inube.servlets;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.crypto.hash.Sha256Hash;

import es.upm.dit.isst.inube.dao.ClienteDAO;
import es.upm.dit.isst.inube.dao.ClienteDAOImplementation;
import es.upm.dit.isst.inube.dao.MovimientoDAO;
import es.upm.dit.isst.inube.dao.MovimientoDAOImplementation;
import es.upm.dit.isst.inube.dao.NegocioDAO;
import es.upm.dit.isst.inube.dao.NegocioDAOImplementation;
import es.upm.dit.isst.inube.model.Cliente;
import es.upm.dit.isst.inube.model.Movimiento;
import es.upm.dit.isst.inube.model.Negocio;

@WebServlet("/CreateTransaccionServlet")
public class CreateTransaccionServlet extends HttpServlet {
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int idMovimiento = Integer.valueOf(req.getParameter( "idMovimiento" ));
		int idClienteNum = Integer.valueOf(req.getParameter( "idCliente" ));
		ClienteDAO cdao = ClienteDAOImplementation.getInstance();
		Cliente idCliente = cdao.read(idClienteNum);
		String idNegocio = req.getParameter( "idNegocio" );
		NegocioDAO ndao = NegocioDAOImplementation.getInstance();
		Negocio negocio = ndao.read(idNegocio);
		int cantidad = Integer.valueOf(req.getParameter( "valor" ));
		
		String startDateStr = req.getParameter("fecha");
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss dd/MM/yyyy");
		Date fecha = null;
		try {
			fecha = sdf.parse(startDateStr);
		} catch (ParseException e) {
			fecha = null;
		}
		
		Movimiento movimiento = new Movimiento();
		movimiento.setIdMovimiento(idMovimiento);
		movimiento.setIdCliente(idCliente); 
		movimiento.setIdNegocio(negocio);
		movimiento.setValor(cantidad);
		movimiento.setFecha(fecha);
		
		MovimientoDAO mdao = MovimientoDAOImplementation.getInstance();
		mdao.create(movimiento);
		
		resp.sendRedirect( req.getContextPath() + "/AdminServlet" );
	}

}
