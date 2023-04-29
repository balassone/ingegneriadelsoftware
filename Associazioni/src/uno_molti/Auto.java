package uno_molti;

public class Auto {

	public String modello;
	
	private Cliente proprietario;
		
	
	public Auto(String modello) {
		
		this.modello = modello;
	}

	public void associaProprietario(Cliente p) {
		
		this.proprietario = p;
	}
	
	public void rimuoviProprietario() {
		
		this.proprietario = null;
	}

	@Override
	public String toString() {
		return "Auto [modello=" + modello + "]";
	}
	
	
	
}
