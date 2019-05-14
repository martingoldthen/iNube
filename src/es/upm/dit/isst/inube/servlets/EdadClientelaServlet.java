package es.upm.dit.isst.inube.servlets;


import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;

import com.google.gson.Gson;

import es.upm.dit.isst.inube.dao.ClienteDAOImplementation;

@WebServlet("/EdadClientela/*")
public class EdadClientelaServlet extends HttpServlet{

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String usuario = req.getParameter("user");
		ClienteDAOImplementation cdao = ClienteDAOImplementation.getInstance();
		List<double[]> datos = cdao.readByEdad(usuario);

		
	    String json = new Gson().toJson(datos);
	    resp.setContentType("application/json");
	    resp.setCharacterEncoding("UTF-8");
	    resp.getWriter().write(json);
		}
	
}