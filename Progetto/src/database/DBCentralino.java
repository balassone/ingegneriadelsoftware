package database;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DBCentralino {
	private ArrayList<DBGruppo> gruppi;
	private ArrayList<DBListaNumeriTelefonici> liste;
	private ArrayList<DBCentralinista> centralinisti;
	private ArrayList<DBAppuntamento> appuntamenti;
	private ArrayList<DBTelefonata> telefonate;
	
	public DBCentralino() {
		super();
	}
	
	public int trovaLista(int id) {
		int ret = 0;
		
		String query = "SELECT * FROM listenumeritelefonici where id='"+id+"';";
		
		try {
			ResultSet rs = DBConnectionManager.selectQuery(query);
			if(rs.next()) {
				ret=1;
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			ret = -1;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			ret = -1;
		}
		return ret;
	}
	
	public int ottieniLatestIDLista() {
		int ret = 0;
		
		String query = "SELECT MAX(id) FROM listenumeritelefonici;";
		
		try {
			ResultSet rs = DBConnectionManager.selectQuery(query);
			if(rs.next()) {
				ret=rs.getInt(1)+1;
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			ret = -1;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			ret = -1;
		}
		return ret;
	}
	
	public int trovaGruppo(int id) {
		int ret = 0;
		
		String query = "SELECT * FROM gruppi where id='"+id+"';";
		
		try {
			ResultSet rs = DBConnectionManager.selectQuery(query);
			if(rs.next()) {
				ret=1;
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			ret = -1;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			ret = -1;
		}
		return ret;
	}
	
	public int ottieniLatestIDGruppo() {
		int ret = 0;
		
		String query = "SELECT MAX(id) FROM gruppi;";
		
		try {
			ResultSet rs = DBConnectionManager.selectQuery(query);
			if(rs.next()) {
				ret=rs.getInt(1)+1;
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			ret = -1;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			ret = -1;
		}
		return ret;
	}
	
	public int liberaTutti(int idGruppo) {
		int ret=0;
		String query = "UPDATE centralinisti SET gruppo=NULL WHERE gruppo='"+idGruppo+"';";
		try {
			ret = DBConnectionManager.updateQuery(query);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ret;
	}
	
	public boolean checkListaAssegnata(int idLista) {
		boolean check = true;
		
		String query = "SELECT * FROM gruppi WHERE lista='"+idLista+"';";
		
		try {
			ResultSet rs = DBConnectionManager.selectQuery(query);
			if(!rs.next()) {
				check=false;
			}
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		return check;
	}
	
	public int trovaAppuntamento(int id) {
		int ret = 0;
		
		String query = "SELECT * FROM appuntamenti WHERE idappuntamenti='"+id+"';";
		
		try {
			ResultSet rs = DBConnectionManager.selectQuery(query);
			if(rs.next()) {
				ret=1;
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			ret = -1;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			ret = -1;
		}
		return ret;
	}
	
	public int ottieniLatestIDAppuntamento() {
		int ret = 0;
		
		String query = "SELECT MAX(idappuntamenti) FROM appuntamenti;";
		
		try {
			ResultSet rs = DBConnectionManager.selectQuery(query);
			if(rs.next()) {
				ret=rs.getInt(1)+1;
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			ret = -1;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			ret = -1;
		}
		return ret;
	}
	
	public int ottieniLatestIDTelefonata() {
		int ret = 0;
		
		String query = "SELECT MAX(id) FROM telefonate;";
		
		try {
			ResultSet rs = DBConnectionManager.selectQuery(query);
			if(rs.next()) {
				ret=rs.getInt(1)+1;
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			ret = -1;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			ret = -1;
		}
		return ret;
	}
	
	
	
}
