package services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import DAO.UtileConnection;
import entity.Utilisateur;

public class UserServices {
	
	public List<Utilisateur> getAll(){
		List<Utilisateur> users = new ArrayList<Utilisateur>();
		
		
		try {
			Connection con = UtileConnection.seConnecter();
			String query = "SELECT * FROM utilisateurs;";
			Statement st = con.createStatement();
			ResultSet resultSet = st.executeQuery(query);
			
			while (resultSet.next()) {
				int id = resultSet.getInt("id");
				int age = resultSet.getInt("age");
				String username = resultSet.getString("username");
				String email = resultSet.getString("email");
				String password = resultSet.getString("password");
				String url_photo = resultSet.getString("url_photo");
				
				//(int id, String username, String email, String password, int age, String url_photo)
				Utilisateur u = new Utilisateur(id,username,email, password, age,url_photo );
				
				users.add(u);
			}

			con.close();		
		} catch (SQLException e) {
				e.printStackTrace();
		}
		
				
		return users;
		
	}
	
	public Utilisateur getByEmail(String email) {
		try {
			Connection con = UtileConnection.seConnecter();
			String query = "SELECT * FROM utilisateurs WHERE email = ?;";
			   PreparedStatement stmt = con.prepareStatement(query);
			   stmt.setString(1, email);
			   stmt.executeQuery();
			ResultSet resultSet = stmt.executeQuery();
			while (resultSet.next()) {
				int id = resultSet.getInt("id");
				int age = resultSet.getInt("age");
				String username = resultSet.getString("username");
				String password = resultSet.getString("password");
				String url_photo = resultSet.getString("url_photo");
				Utilisateur u = new Utilisateur(id,username,email, password, age,url_photo);
			   return u;
			}
			resultSet.close();
	        stmt.close();
	        con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
		
	}
	
	public void create(Utilisateur u) {
		try {
		    Connection con = UtileConnection.seConnecter();
		    String query = "INSERT INTO utilisateurs (username,email,password,age,url_photo) VALUES (?, ?, ?, ?, ?);";
		    PreparedStatement st = con.prepareStatement(query);
		    st.setString(1, u.getUsername());
		    st.setString(2, u.getEmail());
		    st.setString(3, u.getPassword());
		    st.setInt(4, u.getAge());
		    st.setString(5, u.getUrl_photo());
		    
		    st.executeUpdate();
	     	con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void update(Utilisateur u) {
		try {
		        Connection con = UtileConnection.seConnecter();
		        String query =  "UPDATE utilisateurs SET username=?,email=?,password=?,age=?,url_photo=? Where email=?;";
		        
		        PreparedStatement st = con.prepareStatement(query);
		        st.setString(1, u.getUsername());
			    st.setString(2, u.getEmail());
			    st.setString(3, u.getPassword());
			    st.setInt(4, u.getAge());
			    st.setString(5, u.getUrl_photo());
			    st.setString(6, u.getEmail());
		        st.executeUpdate();
			
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void delete(String email) {
		try {
			Connection con = UtileConnection.seConnecter();
			String query = "DELETE FROM utilisateurs WHERE email=?;";
			PreparedStatement st = con.prepareStatement(query);
			st.setString(1, email);
			st.executeUpdate();
			
			con.close();
		}catch (SQLException e) {
			System.out.print("issue");
			e.printStackTrace();
		}
		
	}
	public static boolean isValidUser(String email, String password) {
		Utilisateur user = getUserByEmailPassword(email, password);
		return user != null;
		}
	
	public static Utilisateur getUserByEmailPassword(String email, String password) {
	    try {
	        Connection con = UtileConnection.seConnecter();
	        String query = "SELECT * FROM utilisateurs WHERE email = ? AND password = ?;";
	        PreparedStatement st = con.prepareStatement(query);
	        st.setString(1, email);
	        st.setString(2, password);
	        ResultSet resultSet = st.executeQuery();
	        while (resultSet.next()) {
	            int id = resultSet.getInt("id");
	            int age = resultSet.getInt("age");
	            String username = resultSet.getString("username");
	            String url_photo = resultSet.getString("url_photo");
	            Utilisateur u = new Utilisateur(id, username, email, password, age, url_photo);
	            return u;
	        }
	        con.close();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return null;
	}
	

}
