package database;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DBBadge {
	
	private int idBadge;
	private String tipo;
	private DBStudente studente;
	
	
	public DBBadge() {
		super();
	}

	
	public DBBadge(int idBadge) {
		
		this.idBadge = idBadge;
		caricaDaDB();
	}
	
	//costruttore che prende in ingresso lo studente chiamante
	public DBBadge(int idBadge, DBStudente studente) {
		
		this.studente = studente;
		this.idBadge = idBadge;
		caricaDaDB();
	}

	public DBBadge(DBBadge badge) {
		
		this.idBadge = badge.getIdBadge();
		this.tipo = badge.getTipo();
	}
	
	public void caricaDaDB() {
		
		String query = new String("select * from badge where idBadge ="+this.idBadge);
		
		try {
			ResultSet rs = DBConnectionManager.selectQuery(query);
			
			if(rs.next()) {
				
				this.setTipo(rs.getString("tipo"));
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	public int getIdBadge() {
		return idBadge;
	}


	public void setIdBadge(int idBadge) {
		this.idBadge = idBadge;
	}


	public String getTipo() {
		return tipo;
	}


	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	

	public DBStudente getStudente() {
		return studente;
	}


	public void setStudente(DBStudente studente) {
		this.studente = studente;
	}


	@Override
	public String toString() {
		return "DBBadge [idBadge=" + idBadge + ", tipo=" + tipo + "]";
	}
	
	
	
	
	
	
	

}
