package es.upm.dit.isst.inube.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;

@WebServlet("/NegocioServlet")
public class NegocioServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		/*NegocioDAO pdao = NegocioDAOImplementation.getInstance();
		req.getSession().setAttribute( "negocio_list", pdao.readAll() );
		MovimientoDAO tdao = MovimientoDAOImplementation.getInstance();
		req.getSession().setAttribute( "movimiento_list", tdao.readAll() );*/
		req.getSession().setAttribute("username", SecurityUtils.getSubject().getPrincipal());
		getServletContext().getRequestDispatcher( "/jsp/menu.jsp" ).forward( req, resp );
	}
	
}