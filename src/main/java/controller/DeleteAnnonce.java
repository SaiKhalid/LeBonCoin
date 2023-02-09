package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import services.AnnonceServices;
import services.UserServices;


@WebServlet("/deleteannonce")
public class DeleteAnnonce extends HttpServlet {
	private static final long serialVersionUID = 1L;

	   AnnonceServices service;
	   
	    public DeleteAnnonce() {
	        super();
	        service =new AnnonceServices();
	        
	    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		AnnonceServices service = new AnnonceServices();
		HttpSession session = request.getSession(true);

		int annonce_id = 0;			
			
			System.out.println("annonce id" + annonce_id);
			annonce_id = (int) (session.getAttribute("annonce_id"));
			System.out.println("annonce id" + annonce_id);
			
			int id = (int) (session.getAttribute("id"));
			System.out.println("id" + id);


		
		
		
		service.delete(annonce_id);
		response.setStatus(200);
		request.getRequestDispatcher("deleteaccount.jsp").forward(request,response);
	}







}
