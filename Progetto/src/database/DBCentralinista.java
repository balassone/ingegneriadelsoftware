package database;

import java.util.ArrayList;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBCentralinista {
	private int id;
	private String nome;
	private String cognome;
	private String email;
	private DBGruppo gruppo;
	private ArrayList<DBTelefonata> telefonate;
	
	// Costruttore vuoto
	public DBCentralinista() {
		super();
		this.gruppo = new DBGruppo();
		this.telefonate = new ArrayList<DBTelefonata>();
	}
	// Costruttore con ID
	public DBCentralinista(int id) {
		this.id=id;
		this.gruppo = new DBGruppo();
		this.telefonate = new ArrayList<DBTelefonata>();
		caricaDaDB();
	}
	
	public DBCentralinista(int id, DBGruppo gruppo) {
		this.id=id;
		this.telefonate = new ArrayList<DBTelefonata>();
		this.gruppo=gruppo;
	}
	
	public DBCentralinista(DBCentralinista centr) {
		this.id=centr.getId();
		this.nome=centr.getNome();
		this.cognome=centr.getCognome();
		this.email=centr.getEmail();
	}
	
	// Caricamento
	public void caricaDaDB() {
		String query = "SELECT * FROM centralinisti WHERE id='"+this.id+"';";
		try {
			
			ResultSet rs = DBConnectionManager.selectQuery(query);
			
			if(rs.next()) { 
				
				this.setNome(rs.getString("nome"));
				this.setCognome(rs.getString("cognome"));
				this.setEmail(rs.getString("email"));
				
			}
		
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	// Caricamento Gruppo
	
	public void caricaTelefonateDaDB() {
		String query = new String("SELECT * FROM telefonate WHERE centralinisti_id='"+this.id+"';");
		
		try {
			ResultSet rs = DBConnectionManager.selectQuery(query);
			
			while(rs.next()) {
				DBTelefonata tel = new DBTelefonata();
				tel.setId(rs.getInt("id"));
				tel.setData(rs.getString("data"));
				tel.setOra(rs.getString("ora"));
				tel.setNote(rs.getString("note"));
				tel.setEsito(rs.getInt("esito"));
				tel.setCentralinista(this);
				this.telefonate.add(tel);
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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

	public DBGruppo getGruppo() {
		return gruppo;
	}

	public void setGruppo(DBGruppo gruppo) {
		this.gruppo = gruppo;
	}

	public ArrayList<DBTelefonata> getTelefonate() {
		return telefonate;
	}

	public void setTelefonate(ArrayList<DBTelefonata> telefonate) {
		this.telefonate = telefonate;
	}
	
	@Override
	public String toString() {
		return "DBCentralinista [id=" + id + ", nome=" + nome + ", cognome=" + cognome + ", email=" + email
				+ ", gruppo=" + gruppo + ", telefonate=" + telefonate + "]";
	}
	
	

}
