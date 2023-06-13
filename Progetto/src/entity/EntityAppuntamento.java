package entity;

import database.DBAppuntamento;
import database.DBTelefonata;
import exceptions.DataNonValida;
import exceptions.NoteNonValide;
import exceptions.OraNonValida;
import exceptions.EsitoAppuntamentoNonValido;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

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
		a.setEsito(this.esito);
		ret = a.aggiornaSuDB();
		return ret;
	}
	
	public int referenziaInDB() {
		int ret=0;
		
		DBAppuntamento a = new DBAppuntamento();
		a.setId(this.id);
		a.setPrecedente(this.precedente);
		
		ret = a.referenziaInDB();
		
		return ret;
	}
	
	// SETTERS: stessi controlli presenti nel Boundary, inseriti ai fini di test jUnit
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) throws DataNonValida{
		DateFormat formatoData = new SimpleDateFormat("dd/MM/yyyy");
        formatoData.setLenient(false); // Impedisce la conversione di date non valide

        try {
            formatoData.parse(data);
            this.data=data;
        } catch (ParseException e) {
            throw new DataNonValida();
        }
	}

	public String getOra() {
		return ora;
	}

	public void setOra(String ora) throws OraNonValida{
		DateFormat formatoOra = new SimpleDateFormat("HH:mm");
        formatoOra.setLenient(false); // Impedisce la conversione di orari non validi

        try {
            formatoOra.parse(ora);
            this.ora=ora;
        } catch (ParseException e) {
            throw new OraNonValida();
        }
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) throws NoteNonValide{
		if(note.length()<=1000) {
			this.note=note;
		} else {
			throw new NoteNonValide();
		}
	}

	public int getEsito() {
		return esito;
	}

	public void setEsito(int esito) throws EsitoAppuntamentoNonValido{
		if(esito==0 || esito==1) {
			this.esito=esito;
		} else {
			throw new EsitoAppuntamentoNonValido();
		}
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
		if(esito==0) {
			s=s+"\nesito: OK!";
		} else if (esito==1) {
			s=s+"\nesito: Fallito!";
		}
		if(this.precedente>0) {
			s = s+"\nPRECEDENTE: "+precedente;
		}
		s=s+"\n\n";
		return s;
	}
	
	
	
}
