package es.upm.dit.isst.inube.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.upm.dit.isst.inube.dao.ClienteDAO;
import es.upm.dit.isst.inube.dao.ClienteDAOImplementation;
import es.upm.dit.isst.inube.dao.MovimientoDAO;
import es.upm.dit.isst.inube.dao.MovimientoDAOImplementation;
import es.upm.dit.isst.inube.dao.NegocioDAO;
import es.upm.dit.isst.inube.dao.NegocioDAOImplementation;


@WebServlet("/AdminServlet")
public class AdminServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		NegocioDAO pdao = NegocioDAOImplementation.getInstance();
		req.getSession().setAttribute( "negocio_list", pdao.readAll() );
		/*MovimientoDAO tdao = MovimientoDAOImplementation.getInstance();
		req.getSession().setAttribute( "movimiento_list", tdao.readAll() );*/
		ClienteDAO cdao = ClienteDAOImplementation.getInstance();
		req.getSession().setAttribute( "cliente_list", cdao.readAll() );
		
		getServletContext().getRequestDispatcher( "/AdminView.jsp" ).forward( req, resp );
	}
}
