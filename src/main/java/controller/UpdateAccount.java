package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import entity.Utilisateur;
import services.UserServices;

/**
 * Servlet implementation class UpdateController
 */
@WebServlet("/update")
public class UpdateAccount extends HttpServlet {
	private static final long serialVersionUID = 1L;

	 UserServices service;
	
    public UpdateAccount() {
        super();
        service = new  UserServices();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		UserServices service = new UserServices();
		String email = request.getParameter("email");
		
		
		Utilisateur u = service.getByEmail(email);
		
		request.setAttribute("user", u);
		
				
		request.getRequestDispatcher("UpdateView.jsp").forward(request,response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
		//int id = Integer.parseInt(request.getParameter("id"));
		String username = request.getParameter("username");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		int age = Integer.parseInt(request.getParameter("age"));
		String url_photo = request.getParameter("url_photo");
		
		Utilisateur u = new Utilisateur( username, email,password, age, url_photo);
		service.update(u);
		response.setStatus(200);
		request.getRequestDispatcher("/show").forward(request,response);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
	}

}
