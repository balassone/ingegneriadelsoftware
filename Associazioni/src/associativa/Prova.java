package associativa;

public class Prova {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Persona p = new Persona("marco");
		
		Persona p1 = new Persona("Michele");
		
		Azienda a = new Azienda("Unina");
		
		Azienda b = new Azienda("Ferrari");
		
		//TipoLinkLavora l = new TipoLinkLavora(a, p, 2022); //CLASSE ASSOCIATIVA
		TipoLinkLavora l = new TipoLinkLavora(a, p, 2023);
		TipoLinkLavora l1 = new TipoLinkLavora(b,p,2020); //ferrari,marco
		
		p.insLinkLavora(l); //unina
		
		//p.eliminaLinkLavora(); //mi licenzio
		
		p.insLinkLavora(l1); //marco -> ferrari 	
		
		p1.insLinkLavora(l1);
		
		
		String s = p.getLink().getAz().getNome();
		
		System.out.println(s);

	}

}
