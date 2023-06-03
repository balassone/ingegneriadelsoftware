package entity;
import java.util.ArrayList;

import database.DBListaNumeriTelefonici;

public class EntityListaNumeriTelefonici {
	private int id;
	private String nome;
	private ArrayList<EntityNumeroTelefonico> numeri;
	private EntityGruppo gruppo;
	
	public EntityListaNumeriTelefonici() {
		super();
		this.numeri = new ArrayList<EntityNumeroTelefonico>();
	}
	
	public EntityListaNumeriTelefonici(int id) {
		super();
		DBListaNumeriTelefonici lista = new DBListaNumeriTelefonici(id);
		
		this.nome=lista.getNome();
		this.id=id;
		
		this.numeri=new ArrayList<EntityNumeroTelefonico>();
		lista.caricaNumeriDaDB();
		caricaNumeri(lista);
		
		//lista.caricaGruppoDaDB();
		//caricaGruppo(lista);
		
	}
	
	public EntityListaNumeriTelefonici(DBListaNumeriTelefonici lista) {
		this.id=lista.getId();
		this.nome=lista.getNome();
		this.numeri=new ArrayList<EntityNumeroTelefonico>();
		lista.caricaNumeriDaDB();
		caricaNumeri(lista);
		//lista.caricaGruppoDaDB();
		//caricaGruppo(lista);
	}
	
	public int ScriviSuDB(int id, String nome) {
		DBListaNumeriTelefonici lista = new DBListaNumeriTelefonici();
		int ret = lista.salvaInDB(id, nome);
		
		if(ret!=-1) {
			this.setId(id);
			this.setNome(nome);
		}
		
		return ret;
	}
	
	public void caricaNumeri(DBListaNumeriTelefonici lista) {
		for(int i=0; i<lista.getNumeri().size(); i++) {
			EntityNumeroTelefonico num = new EntityNumeroTelefonico(lista.getNumeri().get(i));
			this.numeri.add(num);
			
		}
	}
	
	public void caricaGruppo(DBListaNumeriTelefonici lista) {
		EntityGruppo g = new EntityGruppo(lista.getGruppo());
		this.gruppo=g;
	}
	
	public int trovaLista(int id) {
		int ret = 0;
		
		DBListaNumeriTelefonici l = new DBListaNumeriTelefonici();
		ret = l.trovaLista(id);
		
		return ret;
	}
	
	public boolean verificaPresenza(EntityNumeroTelefonico num) {
		boolean guardia = false;
		
		for(int i=0; i<this.getNumeri().size(); i++) {
			if(this.getNumeri().get(i).getNumero().equals(num.getNumero())) {
				guardia=true;
			}
		}
		return guardia;
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

	public ArrayList<EntityNumeroTelefonico> getNumeri() {
		return numeri;
	}

	public void setNumeri(ArrayList<EntityNumeroTelefonico> numeri) {
		this.numeri = numeri;
	}

	public EntityGruppo getGruppo() {
		return gruppo;
	}

	public void setGruppo(EntityGruppo gruppo) {
		this.gruppo = gruppo;
	}

	@Override
	public String toString() {
		return "EntityListaNumeriTelefonici [id=" + id + ", nome=" + nome + ", numeri=" + numeri + ", gruppo=" + gruppo
				+ "]";
	}
	
	
	
}
