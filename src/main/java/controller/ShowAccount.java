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



@WebServlet("/show")
public class ShowAccount extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public ShowAccount() {
        super();

    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserServices service = new UserServices();
		
		String email = request.getParameter("email");
		
		try {
			Utilisateur u = service.getByEmail(email);
			 HttpSession session = request.getSession(true);
			  session.setAttribute("id", u.getId());
			  System.out.println(u.getId());
			  session.setAttribute("username", u.getUsername());
			  session.setAttribute("email", email);
			  System.out.println(email);
			  session.setAttribute("age", u.getAge());
			  session.setAttribute("url_photo", u.getUrl_photo());

			  //Integer id = (Integer) session1.getAttribute("id1");
			  //String username = (String) session1.getAttribute("username1");
			  //String email1 = (String) session1.getAttribute("email1");
			 // Integer age = (Integer) session1.getAttribute("age1");
			 // String photoUrl = (String) session1.getAttribute("url_photo1");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		request.getRequestDispatcher("welcome1.jsp").forward(request,response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
