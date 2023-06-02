package database;

import java.util.ArrayList;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBListaNumeriTelefonici {
	private int id;
	private String nome;
	private ArrayList<DBNumeroTelefonico> numeri;
	private DBGruppo gruppo;
	
	
	public DBListaNumeriTelefonici() {
		super();
		this.numeri = new ArrayList<DBNumeroTelefonico>();
	}
	
	public DBListaNumeriTelefonici(int id) {
		this.id=id;
		numeri = new ArrayList<DBNumeroTelefonico>();
		caricaDaDB();
	}
	
	
	public void caricaDaDB() {
		String query = "SELECT * FROM listenumeritelefonici WHERE id='"+this.id+"';";
		
		try {
			ResultSet rs = DBConnectionManager.selectQuery(query);
			
			if(rs.next()) {
				this.setNome(rs.getString("nome"));
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void caricaNumeriDaDB() {
		String query = "SELECT * FROM numeritelefonici WHERE lista='"+this.id+"';";
		
		try {
			ResultSet rs = DBConnectionManager.selectQuery(query);
			while(rs.next()) {
				DBNumeroTelefonico num = new DBNumeroTelefonico();
				num.setNumero(rs.getString("numero"));
				num.setLista(this);
				this.numeri.add(num);
				
			}
		} catch(ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void caricaGruppoDaDB() {
		String query = "SELECT * from gruppi WHERE lista='"+this.id+"';";
		try {
			ResultSet rs = DBConnectionManager.selectQuery(query);
			if(rs.next()) {
				DBGruppo gr = new DBGruppo();
				gr.setId(rs.getInt("id"));
				gr.setDescrizione(rs.getString("descrizione"));
				gr.setLista(this);
				this.gruppo=gr;
			}
		} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
		}
	}
	
	public int salvaInDB(int id, String nome) {
		String query = "INSERT INTO listenumeritelefonici (id,nome) VALUES (\'"+id+"\',\'"+nome+"\')";
		int ret=0;
		try {
			
			ret = DBConnectionManager.updateQuery(query);
			
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			ret = -1;
		}
		
		
		
		return ret;
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
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public ArrayList<DBNumeroTelefonico> getNumeri() {
		return numeri;
	}
	public void setNumeri(ArrayList<DBNumeroTelefonico> numeri) {
		this.numeri = numeri;
	}
	public DBGruppo getGruppo() {
		return gruppo;
	}
	public void setGruppo(DBGruppo gruppo) {
		this.gruppo = gruppo;
	}
	@Override
	public String toString() {
		return "DBListaNumeriTelefonici [id=" + id + ", numeri=" + numeri + ", gruppo=" + gruppo + "]";
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	
	
	
	
}
