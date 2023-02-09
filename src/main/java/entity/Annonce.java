package entity;

public class Annonce {
	
	private int id;
	private int user_id;
	private String type;
	private String type_produit;
	private String nom;
	private String description;
	private int prix;
	private String url_photos;
	
	
	public Annonce(int id, int user_id, String type, String type_produit, String nom, String description, int prix,
			String url_photos) {
		super();
		this.id = id;
		this.user_id = user_id;
		this.type = type;
		this.type_produit = type_produit;
		this.nom = nom;
		this.description = description;
		this.prix = prix;
		this.url_photos = url_photos;
	}
	
	
	
	public Annonce(int user_id, String type, String type_produit, String nom, String description, int prix,
			String url_photos) {
		super();
		this.user_id = user_id;
		this.type = type;
		this.type_produit = type_produit;
		this.nom = nom;
		this.description = description;
		this.prix = prix;
		this.url_photos = url_photos;
	}



	public Annonce() {
		super();
	}


	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getType_produit() {
		return type_produit;
	}
	public void setType_produit(String type_produit) {
		this.type_produit = type_produit;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getPrix() {
		return prix;
	}
	public void setPrix(int prix) {
		this.prix = prix;
	}
	public String getUrl_photos() {
		return url_photos;
	}
	public void setUrl_photos(String url_photos) {
		this.url_photos = url_photos;
	}
	
	
	

}
