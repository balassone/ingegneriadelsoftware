package riflessiva;

public class Prova {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Azienda a = new Azienda("dieti");
		Azienda a1 = new Azienda("cocacola");
		Azienda a2 = new Azienda("unina");
		
		a.setControllante(a2);
		
		System.out.println(a.toString());
		
		System.out.println(a1.toString());

	}

}
