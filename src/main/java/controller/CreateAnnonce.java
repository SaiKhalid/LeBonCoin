package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import entity.Annonce;

import services.AnnonceServices;



@WebServlet("/createannonce")
public class CreateAnnonce extends HttpServlet {
	private static final long serialVersionUID = 1L;
       AnnonceServices service;
 
    public CreateAnnonce() {
        super();
        service = new AnnonceServices();
        
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession(true);
		AnnonceServices service = new AnnonceServices();
		int user_id =-1;
		
		user_id = (int) (session.getAttribute("id"));
		System.out.println(user_id);
		System.out.println("user id in CreateController doGet1 : " +user_id);
		

		
		//String email = request.getParameter("email");
		
		
		Annonce a = service.getByUser_id(user_id);
		
		request.setAttribute("annonce", a);
		request.setAttribute("user_id", user_id);
		System.out.println("user id in CreateController doGet2 : " +user_id);
		request.getRequestDispatcher("createAnnonce.jsp").forward(request,response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(true);
		int user_id1 = (int) session.getAttribute("id");
		System.out.println("user id1 in CreateController doPost: " +user_id1);
		//int user_id = Integer.parseInt(request.getParameter("user_id"));
		String type = request.getParameter("type");
		String type_produit = request.getParameter("type_produit");
		String nom = request.getParameter("nom");
		String description = request.getParameter("description");
		int prix = Integer.parseInt(request.getParameter("prix"));
		String url_photos = request.getParameter("url_photos");
		
		
		session.setAttribute("nom", nom);
		System.out.println("nom " + nom);
		session.setAttribute("description", description);
		System.out.println("description"+ description);
		session.setAttribute("type", type);
		System.out.println("type"+ type);
		session.setAttribute("type_produit", type_produit);
		System.out.println("type_produit"+ type_produit);
		session.setAttribute("user_id", user_id1);
		System.out.println("user_id"+ user_id1);
		session.setAttribute("url_photos", url_photos);
		System.out.println("url_photos"+ url_photos);
		session.setAttribute("prix", prix);
		System.out.println("prix"+ prix);
		try {
			Annonce a = new Annonce(user_id1, type, type_produit, nom, description, prix,url_photos);
			service.create(a);
			response.setStatus(200);
			System.out.println("status 200");
			int annonce_id = a.getId();
			session.setAttribute("annonce_id", annonce_id);
			System.out.println("new annonce : " +annonce_id);
			request.getRequestDispatcher("/showannonce").forward(request,response);
			
			}catch (NumberFormatException e){
				response.setStatus(400);
				doGet(request, response);
			}
	}

}
