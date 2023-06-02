package entity;

import java.util.ArrayList;

import database.DBStudente;

public class EntityStudente {

	private String nome;
	private String cognome;
	private String dataNascita;
	private String matricola;
	private ArrayList<EntityBadge> badge;
	private ArrayList<EntityCorso> corsi;
	
	
	
	
	public EntityStudente() {
		super();
		this.corsi = new ArrayList<EntityCorso>();
		this.badge = new ArrayList<EntityBadge>();
	}
	
	//costruttore con la PK
		public EntityStudente(String matricola){
			
			DBStudente studente = new DBStudente(matricola); //carico lo studente dal DB col costruttore
			
			this.cognome = studente.getCognome(); //mi prendo gli attributi dall'oggetto DBStudente
			this.nome = studente.getNome();
			this.dataNascita = studente.getDataNascita();
			this.matricola = matricola;
			this.corsi = new ArrayList<EntityCorso>(); //creato array vuoti per contenere oggetti di tipo corso
			this.badge = new ArrayList<EntityBadge>();
			
			//System.out.println("EntityStudente: "+studente.toString());
			studente.caricaBadgeStudenteDaDB();
			//System.out.println("EntityStudente ->:"+studente.toString());
			caricaBadge(studente);
			
			//System.out.println("Studente: "+studente.getBadge());
			studente.caricaCorsiStudenteDaDB();
			//System.out.println("StudenteCorsi: "+studente.getCorsi());
			caricaCorsi(studente);
			
			
		}
		
		//costruttore che opera in maniera analoga al precedente
		//ma che invece di caricare dal DB l'oggetto studente
		//lo prende direttamente in ingresso
		
		public EntityStudente(DBStudente studente) {
			
			this.cognome = studente.getCognome(); //mi prendo gli attributi dall'oggetto DBStudente
			this.nome = studente.getNome();
			this.dataNascita = studente.getDataNascita();
			this.matricola = studente.getMatricola();
			this.corsi = new ArrayList<EntityCorso>(); //creato array vuoti per contenere oggetti di tipo corso
			this.badge = new ArrayList<EntityBadge>();
			studente.caricaCorsiStudenteDaDB();
			caricaCorsi(studente);
			studente.caricaBadgeStudenteDaDB();
			caricaBadge(studente);
		}
	

	public void caricaCorsi(DBStudente studente) {
		
		//System.out.println("prova"+studente.getCorsi().get(0).getNome());
		for(int i=0;i<studente.getCorsi().size();i++) {
			
			EntityCorso corso = new EntityCorso(studente.getCorsi().get(i));
			this.corsi.add(corso);
		}
	}
	
	public void caricaBadge(DBStudente studente) {
		
		for(int i=0;i<studente.getBadge().size();i++) {
			
			//devo passare in ingresso al costruttore del badge lo studente stesso!
			EntityBadge badge = new EntityBadge(studente.getBadge().get(i),this);
			this.badge.add(badge);
		}
		//System.out.println("[CaricaBadge]: "+studente.getBadge());
		
		//System.out.println("this.badge"+this.badge);
	}
	
	public int scriviSuDB(String matricola) {
		
		DBStudente s= new DBStudente(); //DAO
		
		s.setNome(this.nome);
		s.setCognome(this.cognome);
		s.setDataNascita(this.dataNascita);
		int i = s.SalvaInDB(matricola);
		
		return i;
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

	

	public ArrayList<EntityBadge> getBadge() {
		return badge;
	}

	public void setBadge(ArrayList<EntityBadge> badge) {
		this.badge = badge;
	}

	public ArrayList<EntityCorso> getCorsi() {
		return corsi;
	}

	public void setCorsi(ArrayList<EntityCorso> corsi) {
		this.corsi = corsi;
	}
	
	

	@Override
	public String toString() {
		return "EntityStudente [nome=" + nome + ", cognome=" + cognome + ", dataNascita=" + dataNascita + ", matricola="
				+ matricola + ", badge=" + badge + ", corsi=" + corsi + "]";
	}

	
	
	
	
	
	
	
	
}
