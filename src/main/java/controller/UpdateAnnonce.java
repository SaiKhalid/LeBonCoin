package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import entity.Annonce;
import entity.Utilisateur;
import services.AnnonceServices;
import services.UserServices;

/**
 * Servlet implementation class UpdateController
 */
@WebServlet("/updateannonce")
public class UpdateAnnonce extends HttpServlet {
	private static final long serialVersionUID = 1L;

	 AnnonceServices service;
	
    public UpdateAnnonce() {
        super();
        service = new  AnnonceServices();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		AnnonceServices service = new AnnonceServices();
		HttpSession session = request.getSession(true);
		int annonce_id =-1;
		
		annonce_id = (int) (session.getAttribute("annonce_id"));
		
		
		Annonce a = service.getById(annonce_id);
		
		request.setAttribute("annonce", a);
		
				
		request.getRequestDispatcher("UpdateAnnonceView.jsp").forward(request,response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			HttpSession session = request.getSession(true);
			int user_id1 = (int) session.getAttribute("id");
			System.out.println(user_id1);
			//int user_id = Integer.parseInt(request.getParameter("user_id"));
			String type = request.getParameter("type");
			String type_produit = request.getParameter("type_produit");
			String nom = request.getParameter("nom");
			String description = request.getParameter("description");
			int prix = Integer.parseInt(request.getParameter("prix"));
			String url_photos = request.getParameter("url_photos");
			
			
			session.setAttribute("nom", nom);
			session.setAttribute("description", description);
			session.setAttribute("type", type);
			session.setAttribute("type_produit", type_produit);
			session.setAttribute("user_id", user_id1);
			session.setAttribute("url_photos", url_photos);
			session.setAttribute("prix", prix);
			Annonce a = new Annonce(user_id1, type, type_produit, nom, description, prix,url_photos);

			
			
			   service.update(a);
			   response.setStatus(200);
			   request.getRequestDispatcher("/show").forward(request,response);

		   } catch (Exception e) {
			e.printStackTrace();
		   }
		
		
		
	}

}
