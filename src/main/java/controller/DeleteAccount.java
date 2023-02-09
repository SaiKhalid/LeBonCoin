package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import services.UserServices;


@WebServlet("/delete")
public class DeleteAccount extends HttpServlet {
	private static final long serialVersionUID = 1L;

	   UserServices service;
	   
	    public DeleteAccount() {
	        super();
	        service =new UserServices();
	        
	    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String email = request.getParameter("email");
		service.delete(email);
		response.setStatus(200);
		request.getRequestDispatcher("deleteaccount.jsp").forward(request,response);
	}







}
