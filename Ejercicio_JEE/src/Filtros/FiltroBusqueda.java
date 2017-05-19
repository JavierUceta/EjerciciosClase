package Filtros;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

/**
 * Servlet Filter implementation class FiltroBusqueda
 */
@WebFilter("/Buscar")
public class FiltroBusqueda implements Filter {

    /**
     * Default constructor. 
     */
    public FiltroBusqueda() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		ServletContext contexto=request.getServletContext();	
		
		String busqueda=request.getParameter("busqueda");
		if(busqueda==null || busqueda.trim().equals("")){	
			RequestDispatcher dispatcher=contexto.getRequestDispatcher("/errores.jsp");
			dispatcher.forward(request,response);
		}
		else{
			busqueda=busqueda.trim();
			//establecer como atributo resultante de la request y proseguir con la ejecución 
			request.setAttribute("busqueda",busqueda);
			chain.doFilter(request, response);
		}
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
