package entity;

import java.util.ArrayList;
import database.DBGruppo;

public class EntityGruppo {
	private int id;
	private String descrizione;
	private EntityListaNumeriTelefonici lista;
	private ArrayList<EntityCentralinista> centralinisti;
	
	public EntityGruppo() {
		super();
		this.centralinisti = new ArrayList<EntityCentralinista>();
	}
	
	public EntityGruppo(DBGruppo g) {
		super();
		this.id=g.getId();
		this.descrizione=g.getDescrizione();
		this.centralinisti=new ArrayList<EntityCentralinista>();
		
		//g.caricaCentralinistiDaDB();
		//caricaCentralinisti(g);
		g.caricaListaDaDB();
		caricaLista(g);
	}
	public void caricaCentralinisti(DBGruppo g) {
		for(int i=0; i<g.getCentralinisti().size(); i++) {
			EntityCentralinista c = new EntityCentralinista(g.getCentralinisti().get(i));
			c.setGruppo(this);
			centralinisti.add(c);
		}
	}
	
	public void caricaLista(DBGruppo g) {
		EntityListaNumeriTelefonici l = new EntityListaNumeriTelefonici(g.getLista());
		this.lista=l;
	}
	
	public int trovaGruppo(int id) {
		int ret=-1;
		DBGruppo g = new DBGruppo();
		ret = g.trovaGruppo(id);
		return ret;
	}
	
	public int scriviSuDB(int id, String descrizione) {
		int ret=0;
		DBGruppo g = new DBGruppo();
		g.setId(id);
		g.setDescrizione(descrizione);
		ret = g.SalvaInDB();
		return ret;
	}
	
	public int rimuoviDaDB(int id) {
		int ret=0;
		DBGruppo g = new DBGruppo();
		ret = g.rimuoviDaDB(id);
		return ret;
	}
	
	public boolean checkListaAssegnata(int id) {
		boolean assegnata=true;
		DBGruppo g = new DBGruppo();
		assegnata = g.checkListaAssegnata(id);
		return assegnata;
	}
	
	public int assegnaLista(int idLista, int idGruppo) {
		int ret=0;
		DBGruppo g = new DBGruppo();
		ret=g.assegnaLista(idLista, idGruppo);
		return ret;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public EntityListaNumeriTelefonici getLista() {
		return lista;
	}

	public void setLista(EntityListaNumeriTelefonici lista) {
		this.lista = lista;
	}

	public ArrayList<EntityCentralinista> getCentralinisti() {
		return centralinisti;
	}

	public void setCentralinisti(ArrayList<EntityCentralinista> centralinisti) {
		this.centralinisti = centralinisti;
	}

	@Override
	public String toString() {
		return "EntityGruppo [id=" + id + ", descrizione=" + descrizione + ", lista=" + lista + ", centralinisti="
				+ centralinisti + "]";
	}
	
	
	
}
