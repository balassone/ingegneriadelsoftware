package associativa;

public class Persona {

	
	private String nome;
	private TipoLinkLavora link; //CLASSE ASSOCIATIVA
	
	
	public Persona(String nome) {
		super();
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public void insLinkLavora(TipoLinkLavora t) {
		
		//1) se sto già lavorando
		//2) se ho già istanziato la classe associativa
		//3) se la persona stessa sta creando l'associazione
		if (link == null && t !=null && t.getPers() == this) {
			link = t;
			System.out.println("Link Creato");
		
		}else {
			
			System.out.println("Link Non Creato");
		}
	}
	
	public void eliminaLinkLavora() {
		link = null;
	}

	public TipoLinkLavora getLink() {
		return link;
	}

	public void setLink(TipoLinkLavora link) {
		this.link = link;
	}
	
	
	
	
}
