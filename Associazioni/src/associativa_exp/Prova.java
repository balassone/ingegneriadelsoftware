package associativa_exp;


public class Prova {

	public static void main(String[] args){
		// TODO Auto-generated method stub
		
		Persona p = new Persona("marco");
		
		Persona p1 = new Persona("Michele");
		
		Azienda a = new Azienda("Unina");
		
		Azienda b = new Azienda("Ferrari");
		
		Persona p2 = null; 
		
		
		TipoLinkLavora l;
		try {
			
			l = new TipoLinkLavora(a, p2, 2022);
			
		} catch (EccezionePrecondizioni e) {
			
			// TODO Auto-generated catch block
			System.out.println(e.toString());
			
		} //CLASSE ASSOCIATIVA
		
		
		//TipoLinkLavora l1 = new TipoLinkLavora(b,p,2020); //ferrari,marco
		
		//p.insLinkLavora(l);
		
		//p.eliminaLinkLavora(); //mi licenzio
		
		//p.insLinkLavora(l1);	
		
	//	p1.insLinkLavora(l1);
		
		
		//String s = p.getLink().getAz().getNome();
		
		//System.out.println(s);

	}

}
