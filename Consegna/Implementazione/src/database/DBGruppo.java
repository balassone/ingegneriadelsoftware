package database;

import java.util.ArrayList;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBGruppo {
	private int id;
	private String descrizione;
	private DBListaNumeriTelefonici lista;
	private ArrayList<DBCentralinista> centralinisti;
	
	public DBGruppo() {
		super();
		this.centralinisti = new ArrayList<DBCentralinista>();
	}
	
	public DBGruppo(int id) {
		this.id=id;
		this.centralinisti = new ArrayList<DBCentralinista>();
		caricaDaDB();
	}
	
	public void caricaDaDB() {
		String query = "SELECT * FROM gruppi where id='"+this.id+"';";
		try {
			ResultSet rs = DBConnectionManager.selectQuery(query);
			if(rs.next()) {
				this.descrizione=rs.getString("descrizione");
			}
		} catch (SQLException | ClassNotFoundException e){
			e.printStackTrace();
		}
	}
	
	public void caricaCentralinistiDaDB() {
		String query = "SELECT * FROM centralinisti WHERE gruppo='"+this.id+"';";
		try {
			ResultSet rs = DBConnectionManager.selectQuery(query);
			while(rs.next()) {
				DBCentralinista c = new DBCentralinista();
				c.setId(rs.getInt("id"));
				c.setNome(rs.getString("nome"));
				c.setCognome(rs.getString("cognome"));
				c.setEmail(rs.getString("email"));
				c.setGruppo(this);
				this.centralinisti.add(c);
			}
		} catch (SQLException | ClassNotFoundException e){
			e.printStackTrace();
		}
	}
	
	public void caricaListaDaDB() {
		String query = "SELECT * from listenumeritelefonici WHERE id IN (select lista from gruppi where id='"+this.id+"');";
		try {
			ResultSet rs = DBConnectionManager.selectQuery(query);
			if(rs.next()) {
				DBListaNumeriTelefonici l = new DBListaNumeriTelefonici();
				l.setId(rs.getInt("id"));
				l.setNome(rs.getString("nome"));
				l.setGruppo(this);
				this.setLista(l);
			}
		} catch (SQLException | ClassNotFoundException e){
			e.printStackTrace();
		}
	}
	
	public int SalvaInDB() {
		int ret = 0;
		
		String query = "INSERT INTO gruppi(id,descrizione) VALUES ( \'"+this.id+"\',"+"\'"+this.descrizione+"')"; 
		try {
			ret = DBConnectionManager.updateQuery(query);
			
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			ret = -1; //per segnalare l'errore di scrittura
		}
		
		return ret;
	}
	
	public int rimuoviDaDB(int id) {
		int ret = 0;
		
		String query = "DELETE FROM gruppi WHERE id='"+id+"';"; 
		
		try {
			ret = DBConnectionManager.updateQuery(query);
			
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			ret = -1; //per segnalare l'errore di scrittura
		}
		
		return ret;
	}
	
	public int assegnaLista(int idLista, int idGruppo) {
		int ret=0;
		
		String query = "UPDATE gruppi SET lista='"+idLista+"' WHERE id='"+idGruppo+"';";
		
		try {
			ret = DBConnectionManager.updateQuery(query);
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		return ret;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public DBListaNumeriTelefonici getLista() {
		return lista;
	}

	public void setLista(DBListaNumeriTelefonici lista) {
		this.lista = lista;
	}

	public ArrayList<DBCentralinista> getCentralinisti() {
		return centralinisti;
	}

	public void setCentralinisti(ArrayList<DBCentralinista> centralinisti) {
		this.centralinisti = centralinisti;
	}
	
	
	
}
