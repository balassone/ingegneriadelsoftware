package database;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DBCorso {
	
	public int idCorso;
	public String nome;
	private ArrayList<DBTesto> testi;
	
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
		
		String query = new String("select * from corsi where codice="+this.idCorso);
		
		try {
			ResultSet rs = DBConnectionManager.selectQuery(query);
			
			while(rs.next()) {
				
				this.setIdCorso(rs.getInt(idCorso));
				this.setNome(rs.getString("nome"));
				
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
	
	public void caricaTestiCorsoDaDB() {
		
		testi = new ArrayList<DBTesto>();
		
		String query = new String("select * from testi where idTesti="+this.idCorso);
		
		try {
			ResultSet rs = DBConnectionManager.selectQuery(query);
			
			while(rs.next()) {
				
				DBTesto testo = new DBTesto();				
				testo.setIdTesto(rs.getInt("idTesti"));
				testo.setNome(rs.getString("nome"));
				testi.add(testo);
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
		
	public ArrayList<DBTesto> getTesti() {
		return testi;
	}

	public void setTesti(ArrayList<DBTesto> testi) {
		this.testi = testi;
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
