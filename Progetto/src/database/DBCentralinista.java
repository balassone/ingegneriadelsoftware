package database;

public class DBCentralinista {
	private int id;
	private String nome;
	private String cognome;
	private String email;
	
	public DBCentralinista() {
		super();
	}
	
	public DBCentralinista(int id) {
		super();
		this.id=id;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCognome() {
		return cognome;
	}
	public void setCognome(String cognome) {
		this.cognome = cognome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
}
