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
 * Servlet implementation class CreateAccountController
 */
@WebServlet("/create")
public class CreateAccountController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	UserServices service;

    public CreateAccountController() {
        super();
        service = new  UserServices();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("create.jsp").forward(request,response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		int age = Integer.parseInt(request.getParameter("age"));
		String url_photo = request.getParameter("url_photo");
		HttpSession session = request.getSession(true);
		session.setAttribute("username", username);
		session.setAttribute("email", email);
		session.setAttribute("password", password);
		session.setAttribute("age", age);
		session.setAttribute("url_photo", url_photo);
		
		boolean erreur = false;
		String usernameError = "";
		String lastNameError = "";
		String emailError = "";
		String passwordError = "";
		String confirmationError = "";
		
		if (username == null || "".equals(username )) {
			erreur = true;
			usernameError = "username  not fill";
		}

		if( email == null || !email.contains("@")) {
			erreur = true;
			emailError = "email does not contain '@'";
		}
		if (password == null || password.length() < 8) {
			passwordError = "Password length < 8";
			erreur = true;
		}
		
		if (erreur) {
			session.setAttribute("usernameError", usernameError);
			session.setAttribute("emailError", emailError);
			session.setAttribute("passwordError", passwordError);

			doGet(request, response);			
		} else {
			try {
				Utilisateur u = new Utilisateur(username, email,password, age, url_photo);
				service.create(u);
				response.setStatus(200);
				request.getRequestDispatcher("/show").forward(request,response);
				
				}catch (NumberFormatException e){
					response.setStatus(400);
					doGet(request, response);
				}
		}


	}

}
