package database;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DBStudente {
	
	private String nome;
	private String cognome;
	private String dataNascita;
	private String matricola;
	private ArrayList<DBCorso> corsi;
	private DBBadge badge;
	
	
	public DBStudente() {
		
		super();
		this.corsi = new ArrayList<DBCorso>();
	}
	
	//costruttore che prende in ingresso la PK
	public DBStudente(String idMatricola) {
		
		this.matricola = idMatricola;
		this.corsi = new ArrayList<DBCorso>();
		caricaDaDB(); //accedo solo alla tabella studente
	}
	
	public void caricaDaDB() {
		
		String query = "SELECT * FROM studenti WHERE matricola='"+this.matricola+"';";
		try {
			
			ResultSet rs = DBConnectionManager.selectQuery(query);
			
			if(rs.next()) { //se ho un risultato
				
				//mi vado a prendere i dati, accedendo tramite il nome dell'attributo-colonna
				this.setNome(rs.getString("nome"));
				this.setCognome(rs.getString("cognome"));
				this.setDataNascita(rs.getString("nascita"));				
			}
		
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public void caricaCorsiStudenteDaDB() {
		
		//devo caricare i CORSI (che a loro volta sono un oggetto)
		//a cui uno studente è scritto
		//per farlo faccio query con la FK
		
		String query = new String("select * from corsi where idCorsi IN (select Corsi_idCorsi from studenti_has_corsi where studenti_matricola=\'"+this.matricola+"')" );
		//System.out.println(query); //stampo query per controllo in fase di DEBUG, poi posso commentare
		
		try {
			
			ResultSet rs = DBConnectionManager.selectQuery(query);
			
			while(rs.next()) {	//while perché mi aspetto più risultati			
							
				//NB: non dimenticare di istanziare l'oggetto Corso
				//altrimenti non potremmo salvare i suoi dati				
				DBCorso corso = new DBCorso();
				corso.setIdCorso(rs.getInt("idCorsi"));
				corso.setNome(rs.getString("nome"));				
				this.corsi.add(corso); //salvo l'oggetto corso appena caricato
				//come attributo dell'oggetto StudenteDB in questione
				
				
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	
				
		
	}
	
	public void caricaBadgeStudenteDaDB() {
		
		String query = new String("select * from badge where studenti_matricola =\'"+this.matricola+"'");
		//System.out.println("[QUERY]: "+query);
		
		try {
			
			ResultSet rs1 = DBConnectionManager.selectQuery(query);
			
			if(rs1.next()) {
				
				DBBadge badge = new DBBadge();				
				badge.setIdBadge(rs1.getInt("idBadge"));
				badge.setTipo(rs1.getString("tipo"));
				//System.out.println("[RESULT_QUERY]: "+badge);
				this.badge = badge; //NON DIMENTICARE DI SALVARE IL RISULTATO
				
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public String getDataNascita() {
		return dataNascita;
	}

	public void setDataNascita(String dataNascita) {
		this.dataNascita = dataNascita;
	}

	public String getMatricola() {
		return matricola;
	}

	public void setMatricola(String matricola) {
		this.matricola = matricola;
	}

	public ArrayList<DBCorso> getCorsi() {
		return corsi;
	}

	public void setCorsi(ArrayList<DBCorso> corsi) {
		this.corsi = corsi;
	}

	public DBBadge getBadge() {
		return badge;
	}

	public void setBadge(DBBadge badge) {
		this.badge = badge;
	}

	@Override
	public String toString() {
		return "DBStudente [nome=" + nome + ", cognome=" + cognome + ", dataNascita=" + dataNascita + ", matricola="
				+ matricola + ", corsi=" + corsi + ", badge=" + badge + "]";
	}
	
	
	

}
