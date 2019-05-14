package es.upm.dit.isst.inube.servlets;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
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

@WebServlet("/CompetenciaSemanaServlet/*")
public class CompetenciaSemanaServlet extends HttpServlet{
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Subject currentUser = SecurityUtils.getSubject();
		String dia = req.getParameter("dia");
		String usuario = req.getParameter("username");
		if(currentUser.isAuthenticated() && currentUser.getPrincipal().equals(usuario)) {
			String[] fechas = calcularFechas(dia);
			MovimientoDAO pdao = MovimientoDAOImplementation.getInstance();
			int count = pdao.getCountCompentencia(usuario);
			List<Object[]> listHoraValor = pdao.readByWeek(usuario, fechas[0], fechas[1]);
			List<Object[]> listHoraValorCompetencia = pdao.competenciaByWeek(usuario,fechas[0],fechas[1]);
			
			double[] datosGrafica = new double[7];
			double[] datosGraficaCompetencia = new double[7];
			for(Object[] par : listHoraValor) {
				Date fecha=(Date)par[0];
				Calendar c = Calendar.getInstance();
			    c.setTime(fecha);
			    int dayOfWeek=c.get(Calendar.DAY_OF_WEEK); 
			    if(dayOfWeek==1) {
			    	dayOfWeek=6;
			    }
			    else {
			    	dayOfWeek-=2;
			    }
				double importe = (double) par[1];
				datosGrafica[dayOfWeek]+=(importe);
			}
			
			for(Object[] par : listHoraValorCompetencia) {
				Date fecha=(Date)par[0];
				Calendar c = Calendar.getInstance();
			    c.setTime(fecha);
			    int dayOfWeek=c.get(Calendar.DAY_OF_WEEK); 
			    if(dayOfWeek==1) {
			    	dayOfWeek=6;
			    }
			    else {
			    	dayOfWeek-=2;
			    }
				double importe = (double) par[1];
				datosGraficaCompetencia[dayOfWeek]+=(importe/count);
			}
			
			for(int i =0 ;i<datosGrafica.length;i++) {
				datosGrafica[i] =(double) Math.round(datosGrafica[i]*100d)/100d;
			}
			
			for(int i =0 ;i<datosGraficaCompetencia.length;i++) {
				datosGraficaCompetencia[i] =(double) Math.round(datosGraficaCompetencia[i]*100d)/100d;
			}
			
			double datos[][]={datosGrafica, datosGraficaCompetencia};
		    String jsonCompetencia = new Gson().toJson(datos);
		    
		    resp.setContentType("application/json");
		    resp.setCharacterEncoding("UTF-8");
		    resp.getWriter().write(jsonCompetencia);
		}
	}
	
	private String[] calcularFechas(String fecha) {
		String[] anoMesDia = fecha.split("-");
		int[] anoMesDiaInt = new int[3];
		for(int i = 0; i<3;i++) {
			anoMesDiaInt[i]=Integer.valueOf(anoMesDia[i]);
		}
		int week = anoMesDiaInt[1]; 
		int year = anoMesDiaInt[0]; 
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		Date date=null;
		try {
			 date = df.parse(fecha);
		} catch (Exception e) {
			 System.err.println("No se ha podido parsear la fecha.");
			 e.printStackTrace();
		}
		cal.setTime(date);
		int numWeek = cal.get(Calendar.WEEK_OF_YEAR);
		cal.clear(); 
		cal.set(Calendar.WEEK_OF_YEAR, numWeek); 
		cal.set(Calendar.YEAR, year);  
		String dateInicial = df.format(cal.getTime()); 
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(cal.getTime());
		calendar.add(Calendar.DAY_OF_YEAR, 7);
		String dateFinal = df.format(calendar.getTime());
		String[] resultado = {dateInicial,dateFinal};
		return resultado;
	}
}

