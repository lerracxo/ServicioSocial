package com.ipn.esca.serviciosocial.sb;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.ipn.esca.serviciosocial.bs.ProfesorIService;
import com.ipn.esca.serviciosocial.entities.Profesor;

/**
 * Servlet implementation class ProfesorServlet
 */
@WebServlet(name="profesor", urlPatterns={"/profesor","/profesor/*"})
public class ProfesorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private final Gson gson = new Gson();
	
	@EJB(lookup="java:module/ProfesorServiceBean!com.ipn.esca.serviciosocial.bs.ProfesorServiceLocal")
	private ProfesorIService service;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProfesorServlet() {
        super();
        // TODO Auto-generated constructor stub
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