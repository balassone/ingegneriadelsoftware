
public class Prova4 {
	
	public static float divisione(float x, float y) throws MyException{
		
		if (y==0)
			throw new MyException("La divisione per zero non è possibile!");
		return x/y;
	}
	
	
	public static void main(String[] args)  {
		
		int a=3, b=0;
	
			try {
				System.out.println(divisione(a, b));
			} catch (MyException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
	}

}
