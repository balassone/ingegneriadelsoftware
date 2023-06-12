package entity;

import java.util.ArrayList;

import database.DBCentralino;

public class EntityCentralino {
	
	private static EntityCentralino instance=null;
	
	private ArrayList<EntityGruppo> gruppi;
	private ArrayList<EntityListaNumeriTelefonici> liste;
	private ArrayList<EntityCentralinista> centralinisti;
	private ArrayList<EntityAppuntamento> appuntamenti;
	private ArrayList<EntityTelefonata> telefonate;
	private ArrayList<EntityAppuntamento> falliti;
	
	public EntityCentralino() {
		super();
	}
	
	public static EntityCentralino getInstance() {
		if(instance==null) {
			instance = new EntityCentralino();
		}
		return instance;
	}
	
	
	
	public int trovaLista(int id) {
		int ret = 0;
		
		ret = DBCentralino.trovaLista(id);
		
		return ret;
	}
	
	// Stampa a video Nome e Cognome del centralinista una volta effettuato il Login
	
	public String datiCentralinista(int id) {
		EntityCentralinista c = new EntityCentralinista(id);
		return c.getNome()+" "+c.getCognome();
	}
	
	// In fase di creazione delle Liste, restituisce l'ID immediatamente successivo all'ultimo.
	
	private int ottieniLatestIDLista() {
		int ret=0;
		ret = DBCentralino.ottieniLatestIDLista();
		return ret;
	}
	
	public int trovaGruppo(int id) {
		int ret=0;
		ret = DBCentralino.trovaGruppo(id);
		return ret;
	}
	
	// In fase di creazione dei Gruppi, restituisce l'ID immediatamente successivo all'ultimo.
	
	private int ottieniLatestIDGruppo() {
		int id=0;
		id = DBCentralino.ottieniLatestIDGruppo();
		return id;
	}
	
	public int trovaCentralinista(int id) {
		int ret=0;
		ret = DBCentralino.trovaCentralinista(id);
		return ret;
	}
	
	
	
	private int liberaTutti(int idGruppo) {
		int ret = 0;
		ret = DBCentralino.liberaTutti(idGruppo);
		return ret;
	}
	
	public int trovaAgente(String CF) {
		int ret=0;
		ret = DBCentralino.trovaAgente(CF);
		return ret;
	}
	
	public String[] agentiDisponibili() {
		ArrayList<String> agenti = DBCentralino.agentiDisponibili();
		String[] agentiParsed = new String[agenti.size()];
		for(int i=0; i<agenti.size(); i++) {
			agentiParsed[i] = agenti.get(i);
		}
		return agentiParsed;
	}
	
	// Crea Lista: Tipo di ritorno è 0 in caso di fallitmento, ID della nuova lista in caso di successo.
	
	public int creaLista(String nome) {
		int ret = 0;
		int id = this.ottieniLatestIDLista();
		EntityListaNumeriTelefonici lista = new EntityListaNumeriTelefonici();
		ret = lista.ScriviSuDB(id, nome);
		if(ret>0) {
			ret=id;
		}
		return ret;
	}
	
	// Aggiungi Numero: Tipo di ritorno è 0 in caso di fallimento, >0 in caso di successo.
	
	public int aggiungiNumero(int idLista, String numero) {
		int ret=0;
		EntityListaNumeriTelefonici l = new EntityListaNumeriTelefonici(idLista);
		EntityNumeroTelefonico n = new EntityNumeroTelefonico(numero);
		if(!l.verificaPresenza(n)) {
			ret = n.aggiungiNumero(idLista, numero);
		}
		return ret;
	}
	
	// Rimuovi Numero: Tipo di ritorno è 0 in caso di fallimento, >0 in caso di successo.
	
	public int rimuoviNumero(int idLista, String numero) {
		int ret=0;
		
		EntityListaNumeriTelefonici l = new EntityListaNumeriTelefonici(idLista);
		EntityNumeroTelefonico n = new EntityNumeroTelefonico(numero);
			
		if(l.verificaPresenza(n)) {
			ret = n.rimuoviNumero();
		}
		
		return ret;
	}
	
	public boolean checkListaAssegnata(int id) {
		boolean assegnata=true;
		assegnata = DBCentralino.checkListaAssegnata(id);
		return assegnata;
	}
	
	// Crea Gruppo: Tipo di ritorno è 0 in caso di fallitmento, ID del nuovo gruppo in caso di successo.
	
	public int creaGruppo(String descrizione) {
		int ret=0;
		int id=0;
		id = ottieniLatestIDGruppo();
		
		EntityGruppo g = new EntityGruppo();
		
		ret = g.scriviSuDB(id,descrizione);
		
		if(ret>0) {
			ret=id;
		}
		
		return ret;
	}
	
	// Inserisci Centralinista nel Gruppo: Tipo di ritorno è 0 in caso di fallitmento, >0 in caso di successo.
	
	public int inserisciCentralinistaGruppo(int idGruppo, int idCentralinista) {
		int ret=0;
		EntityCentralinista c = new EntityCentralinista();
		ret = c.assegnaGruppo(idGruppo, idCentralinista);
		return ret;
	}
	
	public int trovaAppuntamento(int id) {
		int ret=0;
		ret = DBCentralino.trovaAppuntamento(id);
		return ret;
	}
	
	public int ottieniLatestIDAppuntamento() {
		int id=0;
		id = DBCentralino.ottieniLatestIDAppuntamento();
		return id;
	}
	public int ottieniLatestIDTelefonata() {
		int id=0;
		id = DBCentralino.ottieniLatestIDTelefonata();
		return id;
	}
	
	// Rimuovi Gruppo: per evitare inconsistenze lato DB,
		// 1. Viene chiamata una funzione responsabile di rimuovere i centralinisti dal gruppo che si vuole eliminare;
		// 2. Una volta completato, viene effettivamente rimosso il gruppo.
	
	public int rimuoviGruppo(int id) {
		int ret=0;
		if(liberaTutti(id)>0) {
			EntityGruppo g = new EntityGruppo();
			ret = g.rimuoviDaDB(id);
		}
		
		return ret;
	}
	
	// Assegna Lista a Gruppo:
		// Centralino verifica che la lista non sia stata precedentemente assegnata ad un altro gruppo.
	
	public int assegnaListaGruppo(int idLista, int idGruppo) {
		int ret=0;

		EntityGruppo g = new EntityGruppo();
		
		if(!(checkListaAssegnata(idLista))) {
			ret=g.assegnaLista(idLista, idGruppo);
		}
		
		return ret;
	}
	
	public String stampaAppuntamenti(String cf) {
		String s = new String();
		ArrayList<EntityAppuntamento> a = ottieniAppuntamenti(cf);
		for(int i=0; i<a.size(); i++) {
			s=s+a.get(i).toString();
		}
		return s;
	}
	
	private ArrayList<EntityAppuntamento> ottieniAppuntamenti(String cf) {
		EntityAgentediVendita a = new EntityAgentediVendita(cf);
		return a.getAppuntamenti();
	}
	
	// Come l'agente ha accesso ad i suoi appuntamenti, essendo un appuntamento mappato uno a uno con una telefonata, è possibile
		// accedere in molto semplice all'oggetto Telefonata relativa all'Appuntamento.
	
	public String visualizzaNoteChiamata(String cf, int idChiamata) {
		ArrayList<EntityAppuntamento> l = ottieniAppuntamenti(cf);
		for(int i=0; i<l.size(); i++) {
			if(l.get(i).getTelefonata().getId()==idChiamata) {
				return l.get(i).getTelefonata().getNote();
			}
		}
		return "Chiamata non trovata";
	}
	
	// Agente visualizza tutte le informazioni relative ad i propri appuntamenti.
	
	public String visualizzaDettagliAppuntamento(String cf, int idAppuntamento) {
		ArrayList<EntityAppuntamento> l = ottieniAppuntamenti(cf);
		for(int i=0; i<l.size(); i++) {
			if(l.get(i).getId()==idAppuntamento) {
				return l.get(i).toString();
			}
		}
		return "Non Trovato";
		
	}
	
	// Agente visualizza solo le note, sarà utile come punto di partenza per una eventuale modifica delle note.
	
	public String ottieniNoteAppuntamento(String cf, int idAppuntamento) {
		
		String s="";
		ArrayList<EntityAppuntamento> l = ottieniAppuntamenti(cf);
		for(int i=0; i<l.size(); i++) {
			if(l.get(i).getId()==idAppuntamento) {
				s = l.get(i).getNote();
				return s;
			} 
		}
		
		return "APPUNTAMENTO INESISTENTE";
	}
	
	public String ottieniEsitoAppuntamento(String cf, int idAppuntamento) {
		String s="";
		ArrayList<EntityAppuntamento> l = ottieniAppuntamenti(cf);
		for(int i=0; i<l.size(); i++) {
			if(l.get(i).getId()==idAppuntamento) {
				s = String.valueOf(l.get(i).getEsito());
			}
		}
		return s;
	}
	
	// Chiama il metodo Setter dell'entità appuntamento, da poi aggiornare su DB.
	
	public int modificaNoteAppuntamento(String cf, int idAppuntamento, String nuoveNote, int esito) {
		int ret=0;
		ArrayList<EntityAppuntamento> l = ottieniAppuntamenti(cf);
		for(int i=0; i<l.size(); i++) {
			if(l.get(i).getId()==idAppuntamento) {
				l.get(i).setEsito(esito);
				l.get(i).setNote(nuoveNote);
				ret = l.get(i).aggiornaSuDB();
			}
		}
		
		return ret;
	}
	
	// Il centralinista appartiene ad un gruppo che a sua volta ha una lista assegnata. In tal caso visualizza i numeri da chiamare.
	
	public ArrayList<String> numeriDaChiamare(int idCentralinista) {
		EntityCentralinista c = new EntityCentralinista(idCentralinista);
		EntityListaNumeriTelefonici l = new EntityListaNumeriTelefonici(c.getGruppo().getLista().getId());
		ArrayList<EntityNumeroTelefonico> nums = l.getNumeri();
		ArrayList<String> numeri = new ArrayList<String>();
		for(int i=0; i<nums.size(); i++) {
			numeri.add(nums.get(i).getNumero());
		}
		return numeri;
	}
	
	// Form di inserimento telefonata. In caso positivo ne ritorna l'ID.
	
	public int registraEsitoChiamata(String data, String ora, String note, int esito, int idCentralinista) {
		
		int ret=0;
		
		int id = ottieniLatestIDTelefonata();
		EntityTelefonata t = new EntityTelefonata();
		t.setId(id);
		t.setData(data);
		t.setOra(ora);
		t.setNote(note);
		t.setEsito(esito);
		EntityCentralinista ce = new EntityCentralinista(idCentralinista);
		t.setCentralinista(ce);
		
		ret = t.salvaInDB();
		
		if(ret>0) {
			ret=id;
		}
		return ret;
	}
	
	// Form di inserimento appuntamento. In caso positivo ne ritorna l'ID.
	
	public int creaAppuntamento(String data, String ora, String agente, int idTelefonata) {
		int ret=0;
		
		int id = ottieniLatestIDAppuntamento();
		EntityAppuntamento a = new EntityAppuntamento();
		a.setId(id);
		a.setData(data);
		a.setOra(ora);
		a.setAgente(new EntityAgentediVendita(agente));
		a.setTelefonata(new EntityTelefonata(idTelefonata));
		
		ret = a.salvaInDB();
		
		if(ret>0) {
			ret=id;
		}
		
		return ret;
	}
	
	// Esito positivo se effettivamente l'appuntamento precedente è fallito.
	
	public int referenziaAppuntamento(int idVecchio, int idNuovo) {
		int ret=0;
		EntityAppuntamento a = new EntityAppuntamento(idNuovo);
		EntityAppuntamento b = new EntityAppuntamento(idVecchio);
		if(b.getEsito()==1) {
			a.setPrecedente(idVecchio);
			ret = a.referenziaInDB();
		}
		
		return ret;
	}

	public ArrayList<EntityGruppo> getGruppi() {
		return gruppi;
	}

	public void setGruppi(ArrayList<EntityGruppo> gruppi) {
		this.gruppi = gruppi;
	}

	public ArrayList<EntityListaNumeriTelefonici> getListe() {
		return liste;
	}

	public void setListe(ArrayList<EntityListaNumeriTelefonici> liste) {
		this.liste = liste;
	}

	public ArrayList<EntityCentralinista> getCentralinisti() {
		return centralinisti;
	}

	public void setCentralinisti(ArrayList<EntityCentralinista> centralinisti) {
		this.centralinisti = centralinisti;
	}

	public ArrayList<EntityAppuntamento> getAppuntamenti() {
		return appuntamenti;
	}

	public void setAppuntamenti(ArrayList<EntityAppuntamento> appuntamenti) {
		this.appuntamenti = appuntamenti;
	}

	public ArrayList<EntityTelefonata> getTelefonate() {
		return telefonate;
	}

	public void setTelefonate(ArrayList<EntityTelefonata> telefonate) {
		this.telefonate = telefonate;
	}

	public ArrayList<EntityAppuntamento> getFalliti() {
		return falliti;
	}

	public void setFalliti(ArrayList<EntityAppuntamento> falliti) {
		this.falliti = falliti;
	}
	
	
	
}
