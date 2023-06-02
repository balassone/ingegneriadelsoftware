package database;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DBCorso {
	
	public int idCorso;
	public String nome;
	
	
	public DBCorso() {
		super();
		
	}
	
	public DBCorso(int idCorso) {
		
		this.idCorso = idCorso;
		caricaDaDB();
	}
	
	public DBCorso(DBCorso corso) {
		
		this.idCorso = corso.getIdCorso();
		this.nome = corso.getNome();
	}
	
	public void caricaDaDB() {
		
		String query = new String("select * from corsi where codice ='\\\"+this.codice+\\\"';");
		
		try {
			ResultSet rs = DBConnectionManager.selectQuery(query);
			
			if(rs.next()) {
				
				this.setIdCorso(rs.getInt(idCorso));
				this.setNome(rs.getString("nome"));
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
		
	public int getIdCorso() {
		return idCorso;
	}
	public void setIdCorso(int idCorso) {
		this.idCorso = idCorso;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}

	
	
}
