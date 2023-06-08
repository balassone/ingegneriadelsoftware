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
		this.telefonate = new ArrayList<EntityTelefonata>();
	}
	//Costruttore con PK
	public EntityCentralinista(int id) {
		super();
		this.id=id;
		DBCentralinista centralinista = new DBCentralinista(id);
		this.nome=centralinista.getNome();
		this.cognome=centralinista.getCognome();
		this.email=centralinista.getEmail();
		this.telefonate = new ArrayList<EntityTelefonata>();
		centralinista.caricaTelefonateDaDB();
		caricaTelefonate(centralinista);
		centralinista.caricaGruppoDaDB();
		caricaGruppo(centralinista);
	}
	//Costruttore con DB
	public EntityCentralinista(DBCentralinista centralinista) {
		this.id=centralinista.getId();
		this.nome=centralinista.getNome();
		this.cognome=centralinista.getCognome();
		this.email=centralinista.getEmail();
		this.telefonate = new ArrayList<EntityTelefonata>();
		centralinista.caricaTelefonateDaDB();
		caricaTelefonate(centralinista);
		centralinista.caricaGruppoDaDB();
		caricaGruppo(centralinista);
	}
	
	public void caricaTelefonate(DBCentralinista centralinista) {
		for(int i=0; i<centralinista.getTelefonate().size(); i++) {
			EntityTelefonata tel = new EntityTelefonata(centralinista.getTelefonate().get(i));
			this.telefonate.add(tel);
		}
	}
	
	public void caricaGruppo(DBCentralinista centralinista) {
		EntityGruppo g = new EntityGruppo(centralinista.getGruppo());
		this.gruppo=g;
	}
	
	public int assegnaGruppo(int idGruppo, int idCentralinista) {
		int ret = 0;
		DBCentralinista c = new DBCentralinista();
		ret = c.assegnaGruppo(idGruppo, idCentralinista);
		return ret;
	}
	/*
	public int liberaTutti(int idGruppo) {
		int ret = 0;
		DBCentralinista c = new DBCentralinista();
		ret = c.liberaTutti(idGruppo);
		return ret;
	}
	*/
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
	
	public EntityGruppo getGruppo() {
		return gruppo;
	}
	public void setGruppo(EntityGruppo gruppo) {
		this.gruppo = gruppo;
	}
	public ArrayList<EntityTelefonata> getTelefonate() {
		return telefonate;
	}
	public void setTelefonate(ArrayList<EntityTelefonata> telefonate) {
		this.telefonate = telefonate;
	}
	@Override
	public String toString() {
		return "EntityCentralinista [id="+id+", nome= "+nome+", cognome="+cognome+", email="+email+"]";
	}
	
}
