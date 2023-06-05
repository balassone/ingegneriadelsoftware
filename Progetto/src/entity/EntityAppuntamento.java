package entity;

import database.DBAppuntamento;
import database.DBTelefonata;
import database.DBAgentediVendita;

public class EntityAppuntamento {
	private int id;
	private String data;
	private String ora;
	private String note;
	private int esito;
	private EntityTelefonata telefonata;
	private EntityAgentediVendita agente;
	private int precedente;
	
	public EntityAppuntamento() {
		super();
	}
	
	public EntityAppuntamento(int id) {
		super();
		DBAppuntamento a = new DBAppuntamento(id);
		this.id=id;
		this.data=a.getData();
		this.ora=a.getOra();
		this.note=a.getNote();
		this.esito=a.getEsito();
		if(a.getPrecedente()>0) {
			this.precedente=a.getPrecedente();
		} else {
			this.precedente=-1;
		}
		a.caricaTelefonataDaDB();
		caricaTelefonata(a);
		//a.caricaAgenteDaDB();
		//caricaAgente(a);
		
	}
	
	
	public EntityAppuntamento(DBAppuntamento a) {
		this.id=a.getId();
		this.data=a.getData();
		this.ora=a.getOra();
		this.note=a.getNote();
		this.esito=a.getEsito();
		if(a.getPrecedente()>0) {
			this.precedente=a.getPrecedente();
		}
		a.caricaTelefonataDaDB();
		caricaTelefonata(a);
		//a.caricaAgenteDaDB();
		//caricaAgente(a);
	}
	
	public void caricaTelefonata(DBAppuntamento a) {
		EntityTelefonata tel = new EntityTelefonata(a.getTelefonata());
		this.telefonata=tel;
	}
	
	public void caricaAgente(DBAppuntamento a) {
		EntityAgentediVendita ag = new EntityAgentediVendita(a.getAgente());
		this.agente=ag;
	}
	
	public int salvaInDB() {
		int ret=0;
		DBAppuntamento a = new DBAppuntamento();
		a.setId(this.id);
		a.setData(data);
		a.setOra(ora);
		a.setNote(this.note);
		a.setEsito(esito);
		a.setAgente(new DBAgentediVendita(this.agente.getCodicefiscale()));
		a.setTelefonata(new DBTelefonata(this.telefonata.getId()));
		ret = a.scriviSuDB();
		return ret;
	}
	
	public int aggiornaSuDB() {
		int ret=0;
		DBAppuntamento a = new DBAppuntamento();
		a.setId(this.id);
		a.setNote(this.note);
		ret = a.aggiornaSuDB();
		return ret;
	}
	
	public int ottieniLatestID() {
		int id=0;
		DBTelefonata t = new DBTelefonata();
		id=t.ottieniLatestID();
		return id;
	}
	
	public int referenziaInDB() {
		int ret=0;
		
		DBAppuntamento a = new DBAppuntamento();
		a.setId(this.id);
		a.setPrecedente(this.precedente);
		
		ret = a.referenziaInDB();
		
		return ret;
	}
	
	public int trovaAppuntamento(int id) {
		int ret=0;
		DBAppuntamento a = new DBAppuntamento();
		ret=a.trovaAppuntamento(id);
		return ret;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String getOra() {
		return ora;
	}

	public void setOra(String ora) {
		this.ora = ora;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public int getEsito() {
		return esito;
	}

	public void setEsito(int esito) {
		this.esito = esito;
	}

	public EntityTelefonata getTelefonata() {
		return telefonata;
	}

	public void setTelefonata(EntityTelefonata telefonata) {
		this.telefonata = telefonata;
	}

	public EntityAgentediVendita getAgente() {
		return agente;
	}

	public void setAgente(EntityAgentediVendita agente) {
		this.agente = agente;
	}

	public int getPrecedente() {
		return precedente;
	}

	public void setPrecedente(int precedente) {
		this.precedente = precedente;
	}

	@Override
	public String toString() {
		String s = "Appuntamento " + id + ": \ndata: " + data + ", \nora: " + ora + ", \nnote: " + note + ", \ntelefonata: "+telefonata.getId();
		if(this.precedente>0) {
			s = s+"\nPRECEDENTE: "+precedente;
		}
		s=s+"\n\n";
		return s;
	}
	
	
	
}
