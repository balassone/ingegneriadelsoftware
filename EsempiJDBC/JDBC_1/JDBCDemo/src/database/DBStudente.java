package database;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DBStudente {
	
	private String nome;
	private String cognome;
	private String dataNascita;
	private String matricola;
	
	
	//costruttore che prende in ingresso la PK
	public DBStudente(String idMatricola) {
		
		this.matricola = idMatricola;
		caricaDaDB();
	}
	
	public void caricaDaDB() {
		
		String query = "SELECT * FROM studenti WHERE matricola='"+this.matricola+"';";
		
		System.out.println(query); //per debug
		
		try {
			
			ResultSet rs = DBConnectionManager.selectQuery(query);
			
			if(rs.next()) { //se ho un risultato
				
				//mi vado a prendere i dati, accedendo tramite il nome dell'attributo-colonna
				this.setNome(rs.getString("nome"));
				this.setCognome(rs.getString("cognome"));
				this.setDataNascita(rs.getString("nascita"));				
			}
		
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public DBStudente() {
		super();
		// TODO Auto-generated constructor stub
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
	public String getDataNascita() {
		return dataNascita;
	}
	public void setDataNascita(String dataNascita) {
		this.dataNascita = dataNascita;
	}
	public String getMatricola() {
		return matricola;
	}
	public void setMatricola(String matricola) {
		this.matricola = matricola;
	}
	
	

}
