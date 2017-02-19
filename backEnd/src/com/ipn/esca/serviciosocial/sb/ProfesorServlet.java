package com.ipn.esca.serviciosocial.sb;

import com.google.gson.Gson;
import com.ipn.esca.serviciosocial.bs.ProfesorIService;

import javax.ejb.EJB;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class ProfesorServlet
 */
@WebServlet(name="profesor", urlPatterns={"/profesor","/profesor/*"})
@Deprecated
public class ProfesorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private final Gson gson = new Gson();
	
	@EJB(lookup="java:module/ProfesorServiceBean!com.ipn.esca.serviciosocial.bs.ProfesorIService")
	@Inject
	private ProfesorIService service;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProfesorServlet() {
        super();
    }

	/**
	 * This method is for 
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		response.getWriter().print(gson.toJson(service.getProfesoresByFilter(new String())));
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	

}
