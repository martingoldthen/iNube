package es.upm.dit.isst.inube.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.SecurityUtils;


@WebServlet("/MiActividadServlet")
public class MiActividadServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		/*NegocioDAO pdao = NegocioDAOImplementation.getInstance();
		req.getSession().setAttribute( "negocio_list", pdao.readAll() );
		MovimientoDAO tdao = MovimientoDAOImplementation.getInstance();
		req.getSession().setAttribute( "movimiento_list", tdao.readAll() );*/
		req.getSession().setAttribute("username", SecurityUtils.getSubject().getPrincipal());
		getServletContext().getRequestDispatcher( "/jsp/my_activity.jsp" ).forward( req, resp );
	}
	
}
