package uno_uno;

public class Auto {
	
	private String tipo;
	private Cliente proprietario; //nb la semantica
	
	
	
	public Auto(String tipo) {
		super();
		this.tipo = tipo;
	}


	public  void associaProprietario(Cliente p) {
		
		this.proprietario=p;
	}
	
	public void rimuoviProprietario() {
		
		this.proprietario = null;
	}


	public String getTipo() {
		return tipo;
	}


	public void setTipo(String tipo) {
		this.tipo = tipo;
	}


	public Cliente getProprietario() {
		return proprietario;
	}
	
	
	
	
	
	
	

}
