package gen;

public class Persona {
	
	public String nome;
	public int eta;
	
		
	public Persona(String nome, int eta) {
		super();
		this.nome = nome;
		this.eta = eta;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getEta() {
		return eta;
	}
	public void setEta(int eta) {
		this.eta = eta;
	}

	@Override
	public String toString() {
		return "[nome=" + nome + ", eta=" + eta + "]";
	}
	
	
	

}
