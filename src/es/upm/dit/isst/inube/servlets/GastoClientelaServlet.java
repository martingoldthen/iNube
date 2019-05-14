package es.upm.dit.isst.inube.servlets;


import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.google.gson.Gson;
import es.upm.dit.isst.inube.dao.ClienteDAOImplementation;
import es.upm.dit.isst.inube.dao.MovimientoDAOImplementation;

@WebServlet("/GastoClientela/*")
public class GastoClientelaServlet extends HttpServlet{

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String usuario = req.getParameter("user");
		MovimientoDAOImplementation cdao = MovimientoDAOImplementation.getInstance();
		List<Object[]> datos = cdao.readGasto(usuario);
		double[] result = {0,0,0,0};
		for(Object[] datosCliente : datos){
			double media =(double)datosCliente[0]/Integer.parseUnsignedInt(datosCliente[1].toString());
			if(media <=20) {
				result[0] =result[0]+1;
			}else if(media >20 && media<=50) {
				result[1] =result[1]+1;
			}else if(media >50 && media<=100) {
				result[2] =result[2]+1;
			}else{
				result[3] =result[3]+1;
			}
		}
		
		int nClientes= (int)(result[0]+result[1]+result[2]+result[3]);
		for(int i =1;i<result.length;i++) {
			result[i]=result[i]/nClientes*100;
		}
	    String json = new Gson().toJson(result);
	    resp.setContentType("application/json");
	    resp.setCharacterEncoding("UTF-8");
	    resp.getWriter().write(json);
		}
	
}