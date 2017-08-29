package com.register.controllers;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.register.beans.VehicleBean;
import com.register.entities.Vehicle;

/**
 * Servlet implementation class AddVehicle
 */
@WebServlet("/AddVehicle")
public class AddVehicleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@EJB
	VehicleBean vb;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddVehicleServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		Vehicle v = new Vehicle();
		
		String brand = request.getParameter("brand");
		
		v.setBrand(brand);
		
		String model = request.getParameter("model");
		
		v.setModel(model);
		
		String typeDesignation = request.getParameter("typeDesignation");
		
		v.setModel(typeDesignation);

		String VIN = request.getParameter("VIN");
		
		v.setModel(VIN);
		
		String comment = request.getParameter("comment");
		
		v.setModel(comment);
		
		vb.addVehicle(v);
		
		response.sendRedirect("");
		
	}

}
