package entity;

import database.DBTesto;

public class EntityTesto {
	
	private int idTesto;
	private String nome;
	
	
	public EntityTesto(int idTesto) {
		
		this.idTesto=idTesto;
		DBTesto testo = new DBTesto(idTesto);
		
		this.nome = testo.getNome();
	}
	
	public EntityTesto(DBTesto testo) {
		
		this.idTesto = testo.getIdTesto();
		this.nome = testo.getNome();
	}
	
	public EntityTesto() {
		super();
		
	}
	public int getIdTesto() {
		return idTesto;
	}
	public void setIdTesto(int idTesto) {
		this.idTesto = idTesto;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}

	@Override
	public String toString() {
		return "EntityTesto [idTesto=" + idTesto + ", nome=" + nome + "]";
	}
	
	
	public int ScriviSuDB(int idTesti, String nome, int idCorso) {
		
		int ret=0;
		
		DBTesto testo_db = new DBTesto();
		
		//provo a scrivere sul DB
		
		ret = testo_db.salvaInDB(idTesti, nome, idCorso);
		
		if(ret!=-1) {	
			
			this.setIdTesto(idTesti);
			this.setNome(nome);		
			
		}
		
		return ret;
	}

	public int CercaTesto(int id) {
		
		int ret = 0;
		
		DBTesto testo = new DBTesto();
		
		ret = testo.CercaTesto(id);
		
		return ret;
	}
	
	
}
