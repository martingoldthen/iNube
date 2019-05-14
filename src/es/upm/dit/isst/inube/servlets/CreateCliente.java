package es.upm.dit.isst.inube.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.upm.dit.isst.inube.dao.ClienteDAOImplementation;
import es.upm.dit.isst.inube.model.Cliente;

@WebServlet("/CreateCliente")
public class CreateCliente extends HttpServlet {

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int idCliente = Integer.parseInt(req.getParameter("idCliente"));
		int codigoPostalCliente = Integer.parseInt(req.getParameter("cp"));
		Cliente cliente = new Cliente();
		cliente.setIdCliente(idCliente);
		cliente.setCp(codigoPostalCliente);
		
		ClienteDAOImplementation cdao = ClienteDAOImplementation.getInstance();
		cdao.create(cliente);
		
		resp.sendRedirect(req.getContextPath() + "/AdminServlet");
	}

}
