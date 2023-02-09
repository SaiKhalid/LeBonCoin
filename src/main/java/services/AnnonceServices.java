package services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import DAO.UtileConnection;
import entity.Annonce;

public class AnnonceServices {
	
	public List<Annonce> getAll(){
		List<Annonce> annonces = new ArrayList<Annonce>();
		
		
		try {
			Connection con = UtileConnection.seConnecter();
			String query = "SELECT * FROM annonces;";
			Statement st = con.createStatement();
			ResultSet resultSet = st.executeQuery(query);
			
			while (resultSet.next()) {
				int id = resultSet.getInt("annonce_id");
				System.out.println(id);
				int user_id = resultSet.getInt("user_id");
				String type = resultSet.getString("type");
				String type_produit = resultSet.getString("type_produit");
				String nom = resultSet.getString("nom");
				String description = resultSet.getString("description");
				String url_photos = resultSet.getString("url_photos");
				int prix = resultSet.getInt("prix");
				
				//int id, int user_id, String type, String type_produit, String nom, String description, int prix,String url_photos
				Annonce a = new Annonce(id, user_id, type, type_produit, nom, description, prix,url_photos );
				
				annonces.add(a);
			}

			con.close();		
		} catch (SQLException e) {
				e.printStackTrace();
		}
		
				
		return annonces;
		
	}
	
	public Annonce getById(int id) {
		try {
			Connection con = UtileConnection.seConnecter();
			String query = "SELECT * FROM annonces WHERE id= ?;";
			   PreparedStatement stmt = con.prepareStatement(query);
			   stmt.setInt(1, id);
			   stmt.executeQuery();
			ResultSet resultSet = stmt.executeQuery();
			while (resultSet.next()) {
				int user_id = resultSet.getInt("user_id");
				String type = resultSet.getString("type");
				String type_produit = resultSet.getString("type_produit");
				String nom = resultSet.getString("nom");
				String description = resultSet.getString("description");
				String url_photos = resultSet.getString("url_photos");
				int prix = resultSet.getInt("prix");
				Annonce a = new Annonce(id,user_id, type, type_produit, nom, description, prix,url_photos);
			   return a;
			}
			resultSet.close();
	        stmt.close();
	        con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
		
	}
	
	public Annonce getByUser_id(int user_id) {
		try {
			Connection con = UtileConnection.seConnecter();
			String query = "SELECT * FROM annonces WHERE user_id= ?;";
			   PreparedStatement stmt = con.prepareStatement(query);
			   stmt.setInt(1, user_id);
			   stmt.executeQuery();
			ResultSet resultSet = stmt.executeQuery();
			while (resultSet.next()) {
				//int id = resultSet.getInt("id");
				String type = resultSet.getString("type");
				String type_produit = resultSet.getString("type_produit");
				String nom = resultSet.getString("nom");
				String description = resultSet.getString("description");
				String url_photos = resultSet.getString("url_photos");
				int prix = resultSet.getInt("prix");
				Annonce a = new Annonce(user_id, type, type_produit, nom, description, prix,url_photos);
			   return a;
			}
			resultSet.close();
	        stmt.close();
	        con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
		
	}
	
	public void create(Annonce a) {
		try {
		    Connection con = UtileConnection.seConnecter();
		    String query = "INSERT INTO annonces (user_id, type, type_produit, nom, description, prix,url_photos) VALUES (?,?,?,?,?,?,?);";
		    PreparedStatement st = con.prepareStatement(query);
		    st.setInt(1, a.getUser_id());
		    st.setString(2, a.getType());
		    st.setString(3, a.getType_produit());
		    st.setString(4, a.getNom());
		    st.setString(5, a.getDescription());
		    st.setInt(6, a.getPrix());
		    st.setString(7, a.getUrl_photos());
		    
		    st.executeUpdate();
	     	con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void update(Annonce a) {
		try {
		        Connection con = UtileConnection.seConnecter();
		        String query =  "UPDATE annonces SET user_id=?,type=?,type_produit=?,nom=?,description=?,prix=?,url_photos=? Where id=?;";
		        
		        PreparedStatement st = con.prepareStatement(query);
			    st.setInt(1, a.getUser_id());
			    st.setString(2, a.getType());
			    st.setString(3, a.getType_produit());
			    st.setString(4, a.getNom());
			    st.setString(5, a.getDescription());
			    st.setInt(6, a.getPrix());
			    st.setString(7, a.getUrl_photos());
			    st.setInt(8, a.getId());
		        st.executeUpdate();
			
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void delete(int id) {
		try {
			Connection con = UtileConnection.seConnecter();
			String query = "DELETE FROM annonces WHERE id=?;";
			PreparedStatement st = con.prepareStatement(query);
			st.setInt(1, id);
			st.executeUpdate();
			
			con.close();
		}catch (SQLException e) {
			System.out.print("issue");
			e.printStackTrace();
		}
		
	}
	

}
