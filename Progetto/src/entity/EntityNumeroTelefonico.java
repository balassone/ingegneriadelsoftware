package entity;

import database.DBNumeroTelefonico;

public class EntityNumeroTelefonico {
	private String numero;
	private EntityListaNumeriTelefonici lista;
	
	public EntityNumeroTelefonico() {
		super();
	}
	
	public EntityNumeroTelefonico(DBNumeroTelefonico num) {
		super();
		this.numero=num.getNumero();
	}
	
	public EntityNumeroTelefonico(String numero) {
		super();
		setNumero(numero);
	}
	
	public int aggiungiNumero(int idLista, String numero) {
		int ret=0;
		
		DBNumeroTelefonico num = new DBNumeroTelefonico();
		
		ret = num.aggiungiNumero(idLista,numero);
		
		if(ret>0) {
			this.numero=numero;
		}
		
		return ret;
	}
	
	public int rimuoviNumero() {
		int ret=0;
		DBNumeroTelefonico num = new DBNumeroTelefonico(this.numero);
		ret = num.rimuoviNumero();
		return ret;
	}

	public String getNumero() {
		return this.numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public EntityListaNumeriTelefonici getLista() {
		return lista;
	}

	public void setLista(EntityListaNumeriTelefonici lista) {
		this.lista = lista;
	}

	@Override
	public String toString() {
		return "EntityNumeroTelefonico [numero=" + numero + ", lista=" + lista + "]";
	}
	
	
	
}
