package persona;

public class Persona {
	private String nome;
	
	public Persona(String newName){
		this.nome=newName;
	}
	public void stampaNome() {
		System.out.println("Ciao, mi chiamo "+nome);
	}
	
	public static void salutaTutti() {
		System.out.println("Ciao a tutti!");
	}
}
