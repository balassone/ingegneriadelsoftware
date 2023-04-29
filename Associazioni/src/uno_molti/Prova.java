package uno_molti;

public class Prova {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Cliente c = new Cliente(00, "Marco");
		
		Auto a1 = new Auto("BMW");
		Auto a2 = new Auto("Volvo");
		Auto a3 = new Auto("Mercedes");
		Auto a4 = new Auto("Ferrari");
		
		c.associaAuto(a1);		
		a1.associaProprietario(c);
		
		c.associaAuto(a2);
		a2.associaProprietario(c);
		
		c.associaAuto(a3);
		a3.associaProprietario(c);
		c.associaAuto(a4);
		a4.associaProprietario(c);
		
		System.out.println(c.getAutoPosseduta().toString());
		
		c.rimuoviAuto(a1);
		
		System.out.println(c.getAutoPosseduta().toString());
		a1.rimuoviProprietario(); //non dimenticare anche di rimuovere il proprietario
		//l'associazione va scollegata in entrambi i versi in questo caso!
		
		
	}

}
