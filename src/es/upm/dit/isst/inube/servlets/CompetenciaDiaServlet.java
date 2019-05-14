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

import es.upm.dit.isst.inube.dao.MovimientoDAO;
import es.upm.dit.isst.inube.dao.MovimientoDAOImplementation;

@WebServlet("/CompetenciaDiaServlet/*")
public class CompetenciaDiaServlet extends HttpServlet{
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String dia = req.getParameter("dia");
		String usuario = req.getParameter("username");
		Subject currentUser = SecurityUtils.getSubject();
		if(currentUser.isAuthenticated() && currentUser.getPrincipal().equals(usuario)) {
			MovimientoDAO pdao = MovimientoDAOImplementation.getInstance();
			List<Object[]> listCompetenciaHora = pdao.competenciaByDay(usuario, dia);
			List<Object[]> listFacturacionHora = pdao.readByDay(usuario, dia);

			int count = pdao.getCountCompentencia(usuario);
			double[] datosGraficaCompetencia = new double[24];
			double[] datosGrafica = new double[24];
			
			for(Object[] par : listFacturacionHora) {
				Date fecha=(Date)par[0];
				SimpleDateFormat sdf = new SimpleDateFormat("HH");
				int hora = Integer.valueOf(sdf.format(fecha));
				double importe = (double) par[1];
				datosGrafica[hora]+=(importe);
			}
					
			for(Object[] par : listCompetenciaHora) {
				Date fecha=(Date)par[0];
				SimpleDateFormat sdf = new SimpleDateFormat("HH");
				int hora = Integer.valueOf(sdf.format(fecha));
				double importe = (double) par[1];
				datosGraficaCompetencia[hora]+=(importe/count);
			}
			
			for(int i =0 ;i<datosGrafica.length;i++) {
				datosGrafica[i] =(double) Math.round(datosGrafica[i]*100d)/100d;
			}
			
			for(int i =0 ;i<datosGraficaCompetencia.length;i++) {
				datosGraficaCompetencia[i] =(double) Math.round(datosGraficaCompetencia[i]*100d)/100d;
			}
			
			double datos[][]={datosGrafica, datosGraficaCompetencia};
	
		    String jsonFacturacion = new Gson().toJson(datos);
		    resp.setContentType("application/json");
		    resp.setCharacterEncoding("UTF-8");
		    resp.getWriter().write(jsonFacturacion);
		}
	}
}