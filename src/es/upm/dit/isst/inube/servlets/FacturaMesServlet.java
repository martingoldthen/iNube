package es.upm.dit.isst.inube.servlets;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import es.upm.dit.isst.inube.dao.MovimientoDAO;
import es.upm.dit.isst.inube.dao.MovimientoDAOImplementation;

@WebServlet("/FacturaMes/*")
public class FacturaMesServlet extends HttpServlet{

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String fecha = req.getParameter("dia");
		String[] anoMes = fecha.split("-");
		String cif = req.getParameter("user");
		String[] params = selectMonth(anoMes[1]);
		MovimientoDAO mdao = MovimientoDAOImplementation.getInstance();
		List<Object[]> movimientos = mdao.readByMonth(cif,anoMes[0]+"-"+params[0]);
		double[] datosGrafica = new double[Integer.valueOf(params[1])];
		for(Object[] par : movimientos) {
			Date fechaS=(Date)par[0];
			SimpleDateFormat sdf = new SimpleDateFormat("dd");
			int dia = Integer.valueOf(sdf.format(fechaS));
			double importe = (double) par[1];
			datosGrafica[dia-1] = datosGrafica[dia-1] + importe;
		}
		for(int i =0 ;i<datosGrafica.length;i++) {
			datosGrafica[i] =(double) Math.round(datosGrafica[i]*100d)/100d;
		}
	    String json = new Gson().toJson(datosGrafica);
	    
	    resp.setContentType("application/json");
	    resp.setCharacterEncoding("UTF-8");
	    resp.getWriter().write(json);

	}
	
	private String[] selectMonth(String fecha) {
		String[] resultado=new String[2];
		switch(fecha) {
		  case "Enero":
		   	resultado[0]="01";
		   	resultado[1]="31";
		    break;
		  case "Febrero":
			  resultado[0]="02";
			   resultado[1]="28";
		    break;
		  case "Marzo":
			  resultado[0]="03";
			   	resultado[1]="31";
			    break;
		  case "Abril":
			  resultado[0]="04";
			   	resultado[1]="30";
			    break;
		  case "Mayo":
			  resultado[0]="05";
			   	resultado[1]="31";
			    break;
		  case "Junio":
			  resultado[0]="06";
			   	resultado[1]="30";
			    break;
		  case "Julio":
			  resultado[0]="07";
			   	resultado[1]="31";
			    break;
		  case "Agosto":
			  resultado[0]="08";
			   	resultado[1]="31";
			    break;
		  case "Septiembre":
			  resultado[0]="09";
			   	resultado[1]="30";
			    break;
		  case "Octubre":
			  resultado[0]="10";
			   	resultado[1]="31";
			    break;
		  case "Noviembre":
			  resultado[0]="11";
			   	resultado[1]="30";
			    break;
		  case "Diciembre":
			  resultado[0]="12";
			   	resultado[1]="31";
			    break;
		  default:
		}
		return resultado;
		
	}
}