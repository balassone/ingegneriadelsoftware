package uno_uno;

public class Prova {

	public static void main(String[] args) {
		
		// TODO Auto-generated method stub

		Cliente c = new Cliente(00, "Marco");
		Auto a = new Auto("sportiva");
		
		
		
		c.associaAuto(a);
		a.associaProprietario(c);
		
		
		// Cliente -> Auto-> Proprietario-> Nome_Proprietario
		System.out.println(c.getAutoPosseduta().getTipo());
		//System.out.println(c.getAutoPosseduta().getProprietario().getNome());
		//System.out.println(c.getNome());
		
		c.rimuoviAuto();
		System.out.println(c.getAutoPosseduta().getProprietario().getNome());
		
	}

}
