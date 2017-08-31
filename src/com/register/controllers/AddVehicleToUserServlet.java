package com.register.controllers;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.register.beans.UserBean;
import com.register.beans.VehicleBean;

/**
 * Servlet implementation class AddVehicleToUserServlet
 */
@WebServlet("/AddVehicleToUserServlet")
public class AddVehicleToUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@EJB
	VehicleBean vb;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddVehicleToUserServlet() {
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

		String vid = request.getParameter("vid");
		String uid = request.getParameter("uid");
		
		vb.addVehicleToUser(vid, uid);
	
	}

}
