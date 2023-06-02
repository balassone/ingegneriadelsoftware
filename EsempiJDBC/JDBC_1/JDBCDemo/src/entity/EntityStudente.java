package entity;

import database.DBStudente;

public class EntityStudente {

	private String nome;
	private String cognome;
	private String dataNascita;
	private String matricola;//PK
	
	
	//costruttore con la PK
	public EntityStudente(String matricola){
		
		DBStudente studente = new DBStudente(matricola); //carico lo studente dal DB col costruttore
		//accedo al database
		this.cognome = studente.getCognome(); //mi prendo gli attributi dall'oggetto DBStudente
		this.nome = studente.getNome();
		this.dataNascita = studente.getDataNascita();
		this.matricola = matricola;
		
	}
	
	//costruttore che opera in maniera analoga al precedente
	//ma che invece di caricare dal DB l'oggetto studente
	//lo prende direttamente in ingresso
	
	public EntityStudente(DBStudente studente) {
		
		
		this.cognome = studente.getCognome(); //mi prendo gli attributi dall'oggetto DBStudente
		this.nome = studente.getNome();
		this.dataNascita = studente.getDataNascita();
		this.matricola = studente.getMatricola();
	}
	
	public EntityStudente() {
		super();
		// TODO Auto-generated constructor stub
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

	@Override
	public String toString() {
		return "EntityStudente [nome=" + nome + ", cognome=" + cognome + ", dataNascita=" + dataNascita + ", matricola="
				+ matricola + "]";
	}
	
	
	
	
}
