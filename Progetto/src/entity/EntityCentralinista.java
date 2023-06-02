package entity;

import java.util.ArrayList;
import database.DBCentralinista;

public class EntityCentralinista {
	private int id;
	private String nome;
	private String cognome;
	private String email;
	private EntityGruppo gruppo;
	private ArrayList<EntityTelefonata> telefonate;
	
	
	public EntityCentralinista() {
		super();
	}
	//Costruttore con PK
	public EntityCentralinista(int id) {
		super();
		this.id=id;
		
		DBCentralinista centralinista = new DBCentralinista(id);
		//this.nome=centralinista.getNome();
		//this.cognome=centralinista.getCognome();
		//this.email=centralinista.getEmail();
	}
	//Costruttore con DB
	public EntityCentralinista(DBCentralinista centralinista) {
		//this.id=centralinista.getId();
		//this.nome=centralinista.getNome();
		//this.cognome=centralinista.getCognome();
		//this.email=centralinista.getEmail();
	}
	
	public int scriviSuDB(String id) {
		DBCentralinista c = new DBCentralinista();
		int i=0;
		//c.setNome(this.nome);
		//c.setCognome(this.cognome);
		//c.setEmail(this.email);
		//i = c.SalvaInDB(id);
		return i;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	@Override
	public String toString() {
		return "EntityCentralinista [id="+id+", nome= "+nome+", cognome="+cognome+", email="+email+"]";
	}
	
}
