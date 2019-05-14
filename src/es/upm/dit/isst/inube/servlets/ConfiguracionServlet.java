package es.upm.dit.isst.inube.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.upm.dit.isst.inube.dao.NegocioDAO;
import es.upm.dit.isst.inube.dao.NegocioDAOImplementation;
import es.upm.dit.isst.inube.model.Negocio;

/**
 * Servlet implementation class ConfiguracionServlet
 */
@WebServlet("/ConfiguracionServlet")
public class ConfiguracionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ConfiguracionServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException {
		String cif = req.getParameter("cif");
		int cp = Integer.valueOf(req.getParameter( "cp" ));
		String tipo = req.getParameter("bussiness_type");
		String nombre = req.getParameter("nombre");
		String nombreContacto = req.getParameter("name");
		String apellidosContacto = req.getParameter("surname");
		String email = req.getParameter("email");;
		String password = req.getParameter("password");
		String telefonoContacto = req.getParameter("phone");

		//Lostao sabe comparar ocntraseñas o a lo mejor hau codigo pa copiar
		if (password==password) {
			getServletContext().getRequestDispatcher("Configuracion.jsp").forward(req, response);
		}
		else {
			NegocioDAO ndao= NegocioDAOImplementation.getInstance();
			Negocio negocio =  ndao.read(cif);
			negocio.setCp(cp);
			negocio.setTipo(tipo);
			negocio.setPassword(password);
			negocio.setTelefonoContacto(telefonoContacto);
			negocio.setEmailContacto(email);
			negocio.setNombreContacto(nombreContacto);
			negocio.setApellidosContacto(apellidosContacto);
			negocio.setCif(cif);
			ndao.update(negocio);
		}
		getServletContext().getRequestDispatcher("my_activity.jsp").forward(req, response);
		
	}

}
