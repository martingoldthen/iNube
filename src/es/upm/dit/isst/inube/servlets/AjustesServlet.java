package es.upm.dit.isst.inube.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.SecurityUtils;

import es.upm.dit.isst.inube.dao.NegocioDAO;
import es.upm.dit.isst.inube.dao.NegocioDAOImplementation;
import es.upm.dit.isst.inube.model.Negocio;

/**
 * Servlet implementation class AjustesServlet
 */
@WebServlet("/AjustesServlet")
public class AjustesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AjustesServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String cif = (String)req.getSession().getAttribute("username");
		NegocioDAO ndao= NegocioDAOImplementation.getInstance();
		Negocio negocio =  new Negocio();
		negocio = ndao.read(cif);
		req.getSession().setAttribute("negocio", negocio);
		getServletContext().getRequestDispatcher( "/jsp/Configuracion.jsp" ).forward( req, resp );
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
