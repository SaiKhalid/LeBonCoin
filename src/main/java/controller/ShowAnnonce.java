package controller;

import java.io.IOException;
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



@WebServlet("/showannonce")
public class ShowAnnonce extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public ShowAnnonce() {
        super();

    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		AnnonceServices service = new AnnonceServices();
		
		HttpSession session = request.getSession(true);
		int annonce_id =-1;
		
		annonce_id = (int) (session.getAttribute("id"));
		System.out.println("annonce id "+annonce_id);
		//int id = Integer.parseInt(request.getParameter("id"));
		
		try {
			Annonce a = service.getById(annonce_id);
			 //HttpSession session = request.getSession();
			 session.setAttribute("user_id", a.getUser_id());
			  session.setAttribute("type", a.getType());
			  session.setAttribute("type_produit", a.getType_produit());
			  session.setAttribute("nom",a.getNom());
			  session.setAttribute("prix",a.getPrix());
			  session.setAttribute("description",a.getDescription());
			  session.setAttribute("url_photos", a.getUrl_photos());

			  //Integer id = (Integer) session1.getAttribute("id1");
			  //String username = (String) session1.getAttribute("username1");
			  //String email1 = (String) session1.getAttribute("email1");
			 // Integer age = (Integer) session1.getAttribute("age1");
			 // String photoUrl = (String) session1.getAttribute("url_photo1");
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
