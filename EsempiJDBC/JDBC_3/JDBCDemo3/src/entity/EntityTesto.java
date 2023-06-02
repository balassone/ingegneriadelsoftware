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

	
	
}
