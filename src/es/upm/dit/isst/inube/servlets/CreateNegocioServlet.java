package es.upm.dit.isst.inube.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.crypto.hash.Sha256Hash;

import es.upm.dit.isst.inube.dao.NegocioDAO;
import es.upm.dit.isst.inube.dao.NegocioDAOImplementation;
import es.upm.dit.isst.inube.model.Negocio;


@WebServlet("/CreateNegocioServlet")
public class CreateNegocioServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		/*NegocioDAO pdao = NegocioDAOImplementation.getInstance();
		req.getSession().setAttribute( "negocio_list", pdao.readAll() );*/
		getServletContext().getRequestDispatcher( "/jsp/registro.jsp" ).forward( req, resp );
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		/*String nif = req.getParameter( "nif" );
		String nombre = req.getParameter( "company" );
		String password = req.getParameter( "password" );
		int cp = Integer.valueOf(req.getParameter( "cp" ));
		String tipo = req.getParameter( "bussiness_type" );
		String nombreContacto = req.getParameter( "name");
		String apellidos = req.getParameter( "surname" );
		String email = req.getParameter( "email" );
		String telefono = req.getParameter( "phone" );
		
		Negocio negocio = new Negocio();
		negocio.setCif(nif);;
		negocio.setCp(cp);;
		negocio.setNombre(nombre);
		negocio.setTipo(tipo);
		negocio.setPassword( new Sha256Hash( password ).toString() );
		negocio.setApellidosContacto(apellidos);
		negocio.setEmailContacto(email);
		negocio.setNombreContacto(nombreContacto);
		negocio.setTelefonoContacto(telefono);
		
		NegocioDAO pdao = NegocioDAOImplementation.getInstance();
		pdao.create( negocio );*/
		
		
		resp.sendRedirect( req.getContextPath() + "/AdminServlet" );
	}
}
