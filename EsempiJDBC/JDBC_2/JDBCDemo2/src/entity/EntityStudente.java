package entity;

import java.util.ArrayList;

import database.DBStudente;

public class EntityStudente {

	private String nome;
	private String cognome;
	private String dataNascita;
	private String matricola;
	private EntityBadge badge;
	private ArrayList<EntityCorso> corsi;
	
	
	
	
	public EntityStudente() {
		super();
		this.corsi = new ArrayList<EntityCorso>();
	}
	
	//costruttore con la PK
		public EntityStudente(String matricola){
			
			DBStudente studente = new DBStudente(matricola); //carico lo studente dal DB col costruttore
			
			this.cognome = studente.getCognome(); //mi prendo gli attributi dall'oggetto DBStudente
			this.nome = studente.getNome();
			this.dataNascita = studente.getDataNascita();
			this.matricola = matricola;
			this.corsi = new ArrayList<EntityCorso>(); //creato array vuoti per contenere oggetti di tipo corso
			
			//System.out.println("EntityStudente: "+studente.toString());
			
			//LO STUDENTE SI DEVE PREOCCUPARE DI CARICARE DAL DB
			//ANCHE GLI OGGETTI A CUI è "COLLEGATO" OVVERO IL BADGE E I CORSI
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
			
			studente.caricaCorsiStudenteDaDB(); //chiamata 2
			caricaCorsi(studente);
			studente.caricaBadgeStudenteDaDB(); //chiamata 3
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
		
		//System.out.println("[CaricaBadge]: "+studente.getBadge());
		EntityBadge badge = new EntityBadge(studente.getBadge());		
		this.badge = badge;
		//System.out.println("this.badge"+this.badge);
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

	public EntityBadge getBadge() {
		return badge;
	}

	public void setBadge(EntityBadge badge) {
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
