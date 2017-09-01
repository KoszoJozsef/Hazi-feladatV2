package com.register.controllers;

import java.io.IOException;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
 * Servlet implementation class EditVehicleServlet
 */
@WebServlet("/EditVehicleServlet")
public class EditVehicleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@EJB
	VehicleBean vb;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditVehicleServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		RequestDispatcher view = request.getRequestDispatcher("WEB-INF/views/edit_vehicle.jsp");
		
		view.forward(request, response);
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setAttribute("errors", false);

		
		/*

		Vehicle v = vb.getVehicle(Integer.parseInt(request.getParameter("")));
		
		*/

		String brand = request.getParameter("brand");

		if (brand.length() == 0) {
			request.setAttribute("errors", true);
			request.setAttribute("brand-error", true);
			request.setAttribute("brand", "");
		} else {
			v.setBrand(brand);
			request.setAttribute("brand", brand);
		}
		

		String model = request.getParameter("model");

		if (model.length() == 0) {
			request.setAttribute("errors", true);
			request.setAttribute("model-error", true);
			request.setAttribute("model", "");
		} else {
			v.setModel(model);
			request.setAttribute("model", model);
		}

		String typeDesignation = request.getParameter("typeDesignation");

		if (typeDesignation.length() == 0) {
			request.setAttribute("errors", true);
			request.setAttribute("typeDesignation-error", true);
			request.setAttribute("typeDesignation", "");
		} else {
			v.setTypeDesignation(typeDesignation);
			request.setAttribute("typeDesignation", typeDesignation);
		}

		String VIN = request.getParameter("VIN");

		String pattern = "^(([a-h,A-H,j-n,J-N,p-z,P-Z,0-9]{9})([a-h,A-H,j-n,J-N,p,P,r-t,R-T,v-z,V-Z,0-9])([a-h,A-H,j-n,J-N,p-z,P-Z,0-9])(\\d{6}))$";

		Pattern r = Pattern.compile(pattern);

		Matcher m = r.matcher(VIN);

		if (m.find()) {
			v.setVIN(VIN);
			request.setAttribute("VIN", VIN);
			
		} else {
			request.setAttribute("errors", true);
			request.setAttribute("VIN-error", true);
		}

		String comment = request.getParameter("comment");

		v.setComment(comment);
		request.setAttribute("comment", comment);

		String[] langs = request.getParameterValues("extra");

		if(langs != null){
		
			for (String tempLang : langs) {
	
				if (tempLang.equals("seatHeating")) {
					v.setSeatHeating(true);
				}
				if (tempLang.equals("airbags")) {
					v.setAirbags(true);
				}
				if (tempLang.equals("overturningSystem")) {
					v.setOverturningSystem(true);
				}
			}
		}
		
		String idUser = request.getParameter("idUser");		

		if ((Boolean) request.getAttribute("errors")) {

			RequestDispatcher view = request
					.getRequestDispatcher("WEB-INF/views/vehicle_form.jsp");

			view.forward(request, response);
		}
		else {

			vb.addNewVehicleToUser(v, idUser);
	
			response.sendRedirect("VehicleListServlet");
			
		}

		response.sendRedirect("VehicleListServlet");
	
	}

}
