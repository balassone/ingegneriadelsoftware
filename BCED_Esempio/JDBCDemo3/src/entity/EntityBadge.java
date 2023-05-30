package entity;

import database.DBBadge;

public class EntityBadge {
	
	public int idBadge;
	public String tipo;
	public EntityStudente studente;
	
		
	
	public EntityBadge() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public EntityBadge(int idBadge) {
		
		DBBadge badge = new DBBadge(idBadge);
		
		this.idBadge = badge.getIdBadge();
		this.tipo = badge.getTipo();
		
	}
	
	public EntityBadge(DBBadge badge) {
		
		this.idBadge = badge.getIdBadge();
		this.tipo = badge.getTipo();
	}
	
	public EntityBadge(DBBadge badge, EntityStudente studente) {
		
		this.setStudente(studente);
		this.setIdBadge(badge.getIdBadge());
		this.setTipo(badge.getTipo());
	}
	
	public int getIdBadge() {
		return idBadge;
	}
	public void setIdBadge(int idBadge) {
		this.idBadge = idBadge;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	
	
	public EntityStudente getStudente() {
		return studente;
	}

	public void setStudente(EntityStudente studente) {
		this.studente = studente;
	}

	@Override
	public String toString() {
		return "EntityBadge [idBadge=" + idBadge + ", tipo=" + tipo + "]";
	}

	
	
	
}
