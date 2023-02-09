package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import entity.Utilisateur;
import services.UserServices;

/**
 * Servlet implementation class LoginContoller
 */
@WebServlet("/login")
public class LoginContoller extends HttpServlet {
	private static final long serialVersionUID = 1L;

	 UserServices service;
	 
    public LoginContoller() {
        super();
        service = new  UserServices();
    }

protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	UserServices userService = new UserServices();
	
	String email = request.getParameter("email");
	String password = request.getParameter("password");
	request.getRequestDispatcher("login.jsp").forward(request, response);
	
}
protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	UserServices service = new UserServices();
	
	String email = request.getParameter("email");
	String password = request.getParameter("password");

	
	if (email == null || password == null) {
		request.getRequestDispatcher("login.jsp").forward(request, response);
		return;
	}
	
	try {
		if (!UserServices.isValidUser(email, password)) {
			request.setAttribute("errorMessage", "Invalid email or password");
			request.getRequestDispatcher("login.jsp").forward(request, response);
			return;
		}
	} catch (ServletException | IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	 	
	request.getRequestDispatcher("/show").forward(request, response);
	
}



}
