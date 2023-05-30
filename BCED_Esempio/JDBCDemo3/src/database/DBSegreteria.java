package database;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DBSegreteria {
	
	private ArrayList<DBStudente> studenti;
	private ArrayList<DBTesto> testi;
	
	public DBSegreteria() {
		
		
	}
	
public static ArrayList<String> getListaMatricole(){ //accesso al DB per prelevare la lista di matricole
		
		ArrayList<String> ret = new ArrayList<String>();
		
		try {
			
			ResultSet rs = DBConnectionManager.selectQuery("select matricola from studenti;");
			
			while(rs.next()) {
				
				ret.add(rs.getString("matricola"));
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return ret;
		
	
	}
	

}
