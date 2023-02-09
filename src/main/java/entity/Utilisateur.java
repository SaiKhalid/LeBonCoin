package entity;

public class Utilisateur {
	
	private int id;
	private String username;
	private String email;
	private String password;
	private int age;
	private String url_photo;
	
	
	
	public Utilisateur(int id, String username, String email, String password, int age, String url_photo) {
		super();
		this.id = id;
		this.username = username;
		this.email = email;
		this.password = password;
		this.age = age;
		this.url_photo = url_photo;
	}
	
	public Utilisateur(int id, String username, String email, int age, String url_photo) {
		super();
		this.id = id;
		this.username = username;
		this.email = email;
		this.age = age;
		this.url_photo = url_photo;
	}
	
	
	public Utilisateur(String username, String email, String password, int age, String url_photo) {
		super();
		this.username = username;
		this.email = email;
		this.password = password;
		this.age = age;
		this.url_photo = url_photo;
	}


	public Utilisateur() {
		super();
	}


	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getUrl_photo() {
		return url_photo;
	}
	public void setUrl_photo(String url_photo) {
		this.url_photo = url_photo;
	}
	
	

}
