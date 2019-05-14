package es.upm.dit.isst.inube.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.SecurityUtils;

@WebServlet("/CompetenciaServlet")
public class CompetenciaServlet extends HttpServlet{
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getSession().setAttribute("username", SecurityUtils.getSubject().getPrincipal());
		getServletContext().getRequestDispatcher( "/jsp/competencia.jsp" ).forward( req, resp );
	}

	
}
