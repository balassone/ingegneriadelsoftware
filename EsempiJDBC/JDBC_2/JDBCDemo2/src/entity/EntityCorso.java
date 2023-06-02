package entity;

import database.DBCorso;

public class EntityCorso {
	
	public int idCorso;
	public String nome;
	
	
	
	
	public EntityCorso() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	//costrutore con la PK
	public EntityCorso(int idCorso) {
		
		this.idCorso=idCorso;
		DBCorso corso = new DBCorso(idCorso); //carico dal DB con la PK
		this.nome = corso.getNome();
	}
	
	//costruttore copia da oggettoDB
	public EntityCorso(DBCorso corso) {
		
		this.idCorso = corso.getIdCorso();
		this.nome = corso.getNome();
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
	@Override
	public String toString() {
		return "EntityCorso [idCorso=" + idCorso + ", nome=" + nome + "]";
	}

	
	
}
