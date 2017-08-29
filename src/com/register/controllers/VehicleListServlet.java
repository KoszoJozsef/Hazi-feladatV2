package com.register.controllers;

import java.io.IOException;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.register.beans.VehicleBean;
import com.register.entities.Vehicle;

/**
 * Servlet implementation class Vehicles
 */
@WebServlet("/Vehicles")
public class VehicleListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@EJB
	VehicleBean vb;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VehicleListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<Vehicle> vList = (List<Vehicle>) vb.getVehicles();
		
		request.setAttribute("vehicle_list", vList);
		
		RequestDispatcher view = request.getRequestDispatcher("WEB-INF/views/vehicle_list");
		
		view.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
