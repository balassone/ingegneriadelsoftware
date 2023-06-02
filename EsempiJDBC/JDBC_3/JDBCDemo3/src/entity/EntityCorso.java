package entity;

import java.util.ArrayList;

import database.DBCorso;

public class EntityCorso {
	
	public int idCorso;
	public String nome;
	public ArrayList<EntityTesto> testi;
	
	
	
	
	public EntityCorso() {
		super();
		testi = new ArrayList<EntityTesto>();
		// TODO Auto-generated constructor stub
	}
	
	//costrutore con la PK
	public EntityCorso(int idCorso) {
		
		testi = new ArrayList<EntityTesto>();
		this.idCorso=idCorso;
		DBCorso corso = new DBCorso(idCorso); //carico dal DB con la PK
		this.nome = corso.getNome();
		
		for(int i=0;i<corso.getTesti().size();i++) {
			
			EntityTesto testo = new EntityTesto(corso.getTesti().get(i));
			this.testi.add(testo);
		}
		
		
	}
	
	//costruttore copia da oggettoDB
	public EntityCorso(DBCorso corso) {
		
		testi = new ArrayList<EntityTesto>();
		this.idCorso = corso.getIdCorso();
		this.nome = corso.getNome();
		
		for(int i=0;i<corso.getTesti().size();i++) {
			
			EntityTesto testo = new EntityTesto(corso.getTesti().get(i));
			this.testi.add(testo);
		}
	}
	
	public int getIdCorso() {
		return idCorso;
	}
	public void setIdCorso(int idCorso) {
		this.idCorso = idCorso;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	
	
	public ArrayList<EntityTesto> getTesti() {
		return testi;
	}

	public void setTesti(ArrayList<EntityTesto> testi) {
		this.testi = testi;
	}

	@Override
	public String toString() {
		return "EntityCorso [idCorso=" + idCorso + ", nome=" + nome + ", testi=" + testi + "]";
	}



	
	
}
