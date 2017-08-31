package com.register.controllers;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.register.beans.UserBean;
import com.register.entities.Role;
import com.register.entities.ApplicationUser;
import com.register.entities.Vehicle;

/**
 * Servlet implementation class AddUser
 */
@WebServlet("/AddUserServlet")
public class AddUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@EJB
	UserBean ub;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddUserServlet() {
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
		
		request.setAttribute("user-errors", false);

		ApplicationUser u = new ApplicationUser();
		
		String username = request.getParameter("username");

		if (username.length() == 0) {
			request.setAttribute("user-errors", true);
			request.setAttribute("username-error", true);
			request.setAttribute("username", "");
		} else {
			u.setUsername(username);
			request.setAttribute("username", username);
		}
		
		String password = request.getParameter("password");

		if (password.length() == 0) {
			request.setAttribute("user-errors", true);
			request.setAttribute("password-error", true);
			request.setAttribute("password", "");
		} else {
			u.setPassword(password);
			request.setAttribute("password", password);
		}

		String firstname = request.getParameter("firstname");

		if (firstname.length() == 0) {
			request.setAttribute("user-errors", true);
			request.setAttribute("firstname-error", true);
			request.setAttribute("firstname", "");
		} else {
			u.setFirstname(firstname);
			request.setAttribute("firstname", firstname);
		}
		

		String lastname = request.getParameter("lastname");

		if (lastname.length() == 0) {
			request.setAttribute("user-errors", true);
			request.setAttribute("lastname-error", true);
			request.setAttribute("lastname", "");
		} else {
			u.setLastname(lastname);
			request.setAttribute("lastname", lastname);
		}

		String role = request.getParameter("role");

		u.setRole(Role.valueOf(role));
		request.setAttribute("role", role);


		if ((Boolean) request.getAttribute("user-errors")) {

			RequestDispatcher view = request
					.getRequestDispatcher("WEB-INF/views/vehicle_form.jsp");

			view.forward(request, response);
		}
		else {

			ub.addUser(u);
	
			response.sendRedirect("UserListServlet");
			
		}
		
	}

}
