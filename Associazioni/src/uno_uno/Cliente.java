package uno_uno;

public class Cliente {
	
	private int id;
	private String nome;
	//associazione
	private Auto autoPosseduta;
	
	
	
	public Cliente(int id, String nome) {
		super();
		this.id = id;
		this.nome = nome;
	}

	public void associaAuto(Auto x) {
		
		this.autoPosseduta=x;
	}
	
	public void rimuoviAuto() {
		
		this.autoPosseduta = null;
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


	public Auto getAutoPosseduta() {
		return autoPosseduta;
	}
	
	
	

}
