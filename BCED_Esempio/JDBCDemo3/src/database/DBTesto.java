package database;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DBTesto {

	private int idTesto;
	private String nome;
	
	
	
	public DBTesto() {
		super();
		
	}
	
	public DBTesto(int idTesto) {
		
		this.idTesto = idTesto;
		//caricaDaDB();
		
	}
	
	/*public void caricaDaDB() {
		
		String query = new String("select * from testi where idTesti="+idTesto);
		System.out.println(query);
		
		try {
			ResultSet rs = DBConnectionManager.selectQuery(query);
			
			if(rs.next()) {
				
				this.setIdTesto(rs.getInt("idTesti"));
				this.setNome(rs.getString("nome"));
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}*/
	public int getIdTesto() {
		return idTesto;
	}
	public void setIdTesto(int idTesto) {
		this.idTesto = idTesto;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public int salvaInDB(int idTesti, String nome, int idCorso) {
		
		int ret = 0;
		
		String query = "INSERT INTO testi(idTesti,nome, Corsi_idCorsi) VALUES ( \'"+idTesti+"\',"+"\'"+nome+"\','"+idCorso+"\')"; 

		
		try {
			
			ret = DBConnectionManager.updateQuery(query);
			
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			ret = -1;
		}
		
		
		
		return ret;
	}
	
	public int CercaTesto(int id) {
		
		int ret=0;
		
		String query = new String("select * from testi where idTesti="+id);
		
		try {
			ResultSet rs = DBConnectionManager.selectQuery(query);
			
			if(rs.next()) {
				
				ret=1;
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			ret = -1;
		}
		
		
		return ret;
	}
	
}
