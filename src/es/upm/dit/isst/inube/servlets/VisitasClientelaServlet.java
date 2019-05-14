package es.upm.dit.isst.inube.servlets;


import java.io.IOException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import es.upm.dit.isst.inube.dao.ClienteDAOImplementation;

@WebServlet("/VisitasClientela/*")
public class VisitasClientelaServlet extends HttpServlet{

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String usuario = req.getParameter("user");
		ClienteDAOImplementation cdao = ClienteDAOImplementation.getInstance();
		List<Object[]> query_data = cdao.readByVisitas(usuario);
		
		//ArrayList<Integer> datos = new ArrayList<Integer>();
		double[] result = {0,0,0,0};
		for(Object e:query_data) {
			int nVeces = Integer.parseUnsignedInt(e.toString());
			if(nVeces<2) {
				result[0]++;
			}else if(nVeces==2) {
				result[1]++;
			}else if(nVeces==3) {
				result[2]++;
			}else{
				result[3]++;
			}
		}
		int nTotal = (int)(result[0]+result[1]+result[2]+result[3]);
		for(int i=0;i<4;i++) {
			result[i]=result[i]/nTotal*100;
		}
		/*
		int una = 0;
		int dos = 0;
		int tres = 0;
		int cuatroomas = 0;
	    for (Integer n:datos) {
	        if(n<=1) {
	        	una++;
	        }else if(n==2) {
	        	dos++;
	        }else if(n==3) {
	        	tres++;
	        }else if(n>=4) {
	        	cuatroomas++;
	        }
	        }
	    
	    int total = una+dos+tres+cuatroomas;
	    double prcntUna = (una/total)*100;
	    double prcntDos = (dos/total)*100;
	    double prcntTres = (tres/total)*100;
	    double prcntCuatro = (cuatroomas/total)*100;*/
	    
		/*double[] finaldata = new double[4];
		finaldata[0] = prcntUna;
		finaldata[1] = prcntDos;
		finaldata[2] = prcntTres;
		finaldata[3] = prcntCuatro;*/
	    String json = new Gson().toJson(result);
	    resp.setContentType("application/json");
	    resp.setCharacterEncoding("UTF-8");
	    resp.getWriter().write(json);
		}
	
}