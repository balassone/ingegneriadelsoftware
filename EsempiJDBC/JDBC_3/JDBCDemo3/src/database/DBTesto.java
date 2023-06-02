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
	
	
}
