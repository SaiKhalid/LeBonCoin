package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import entity.Utilisateur;
import services.UserServices;



@WebServlet("/generalcontroller")
public class GeneralController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       UserServices service;

    public GeneralController() {
        super();
       service = new  UserServices();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	int id =-1;
		
		try{
			id = Integer.parseInt(request.getParameter("id"));
		}catch (NumberFormatException e){
			
		}

		
		String characterToJson = "";
		response.setContentType("application/json");
		if (id != -1) {
			//characterToJson = new Gson().toJson(service.getByEmail(id));
						
		}else {
			characterToJson = new Gson().toJson(service.getAll().toArray());			
		}
		response.getWriter().write(characterToJson);
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
		//(int id, String username, String email, String password, int age, String url_photo)
		String username = request.getParameter("username");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		int age = Integer.parseInt(request.getParameter("age"));
		String url_photo = request.getParameter("url_photo");
		
		
		Utilisateur u = new Utilisateur(username,email, password, age,url_photo );
		service.create(u);
		response.setStatus(200);
		
		}catch (NumberFormatException e){
			response.setStatus(400);
		}
		
	}

	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		String username = request.getParameter("username");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		int age = Integer.parseInt(request.getParameter("age"));
		String url_photo = request.getParameter("url_photo");
		
		//Characters(int id,String name, int level, int size, String type)
		Utilisateur u = new Utilisateur(id,username,email, password, age,url_photo );
		service.update(u);
		response.setStatus(200);
	}

	/**
	 * @see HttpServlet#doDelete(HttpServletRequest, HttpServletResponse)
	 */
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		//service.delete(id);
		response.setStatus(200);
	}

}
