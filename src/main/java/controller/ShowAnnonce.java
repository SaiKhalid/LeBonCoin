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




@WebServlet("/showannonce")
public class ShowAnnonce extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public ShowAnnonce() {
        super();

    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession(true);
		AnnonceServices service = new AnnonceServices();
		int annonce_id = 0;
		try {
			
			
			System.out.println("annonce id" + annonce_id);
			annonce_id = (int) (session.getAttribute("annonce_id"));
				System.out.println("annonce id" + annonce_id);
		}catch (NumberFormatException e){
			response.setStatus(400);
			System.out.println(" issues mane");
		}


		
		//int id = (int) (session.getAttribute("annonce_id"));
		//System.out.println("id" + id);
		//int what_id = Integer.parseInt(request.getParameter("id"));
		//System.out.println("what_id" + what_id);
		
		try {
			Annonce a = service.getById(annonce_id);
			 session.setAttribute("user_id", a.getUser_id());
			  session.setAttribute("type", a.getType());
			  session.setAttribute("type_produit", a.getType_produit());
			  session.setAttribute("nom",a.getNom());
			  session.setAttribute("prix",a.getPrix());
			  session.setAttribute("description",a.getDescription());
			  session.setAttribute("url_photos", a.getUrl_photos());


		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		request.getRequestDispatcher("welcome.jsp").forward(request,response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
		
	}

}
