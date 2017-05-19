package controladores;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.DAOViaje;
import modelos.Viaje;

/**
 * Servlet implementation class Favoritos
 */
@WebServlet("/Favoritos")
public class Favoritos extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Favoritos() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServletContext contexto=request.getServletContext();
		HttpSession sesion=request.getSession();
		ArrayList<Viaje> favoritos=(ArrayList<Viaje>) sesion.getAttribute("favoritos");
		if(favoritos==null){
			favoritos=new ArrayList<Viaje>();
			sesion.setAttribute("favoritos", favoritos);
		}
		String stId=request.getParameter("id");
		int id=Integer.parseInt(stId);
		DAOViaje dao=new DAOViaje();
		Viaje viaje=dao.getViaje(id);
		
		boolean exis=false;
		for(Viaje v:favoritos){
			if(v.equals(viaje))exis=true;
			break;
		}if(!exis){
			favoritos.add(viaje);
		}
		RequestDispatcher dispatcher=contexto.getRequestDispatcher("/favorito.jsp");
		dispatcher.forward(request,response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
