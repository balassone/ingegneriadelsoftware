package database;

import java.util.ArrayList;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBCentralinista {
	private int id;
	private String nome;
	private String cognome;
	private String email;
	private DBGruppo gruppo;
	private ArrayList<DBTelefonata> telefonate;
	
	public DBCentralinista() {
		super();
		this.telefonate = new ArrayList<DBTelefonata>();
	}
	
	public DBCentralinista(int id) {
		this.id=id;
		this.telefonate = new ArrayList<DBTelefonata>();
		caricaDaDB();
	}
	
	public void caricaDaDB() {
		String query = "SELECT * FROM centralinisti WHERE id='"+this.id+"';";
		try {
			
			ResultSet rs = DBConnectionManager.selectQuery(query);
			
			if(rs.next()) { //se ho un risultato
				
				//mi vado a prendere i dati, accedendo tramite il nome dell'attributo-colonna
				this.setNome(rs.getString("nome"));
				this.setCognome(rs.getString("cognome"));
				this.setEmail(rs.getString("email"));				
			}
		
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void caricaTelefonateDaDB() {
		
		String query = new String("select * from telefonate where idCentralinista ='"+this.id+"')" );
		//System.out.println(query); //stampo query per controllo in fase di DEBUG, poi posso commentare
		
		try {
			
			ResultSet rs = DBConnectionManager.selectQuery(query);
			
			while(rs.next()) {	//while perch� mi aspetto pi� risultati			
							
				//NB: non dimenticare di istanziare l'oggetto Corso
				//altrimenti non potremmo salvare i suoi dati				
				DBTelefonata corso = new DBTelefonata();
				//corso.setIdCorso(rs.getInt("idCorsi"));
				//corso.setNome(rs.getString("nome"));				
				
				//corso.caricaTestiCorsoDaDB(); //****NB :CARICAMENTO IN CASCATA****
				//this.corsi.add(corso); //salvo l'oggetto corso appena caricato
				//come attributo dell'oggetto StudenteDB in questione
				
				
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	
}
