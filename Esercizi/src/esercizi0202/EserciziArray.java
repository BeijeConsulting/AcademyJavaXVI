package esercizi0202;

public class EserciziArray {
	
	
	static boolean contains (int e, int[] array) {
		
		
		for (int numero: array)
			if (numero == e)
				return true;
		
		return false;
		
		
	}
	
	static boolean contains (Object e, Object[] array) {
		
		
		for (Object obj: array)
			if (obj.equals(e))
				return true;
		
		return false;
		
		
	}
	
	boolean isCrescente(int [] array) {
		
		for(int i = 0; i < array.length - 1; i++) {
			
			if (array[i] > array[i+1])
				return false;
			
		}
				
		return true;
	}
	
	public int mostRecurrent(int [] array) {
		
		int mostCounter = 0;
		int counter = 0;
		int most = 0;
	
		
		for (int i = 0; i < array.length; i++) {
			
			counter = 0;
			
			for (int j = 0;  j < array.length; j++) {
				
				if (array[i] == array[j])
					counter++;
			}

			System.out.println ("numero: " + array[i] + " counter: " + counter);
			
			if (counter > mostCounter) {
				 
				mostCounter = counter;
				most = array[i];
			 
			}
		 
		}
		
		return most;
		
	}
	
	public static double mediaMultipliDiTre (int [] array) {
		
		double media = 0;
		double divisore = 0;
		
		for (int numero: array) {
			
			if (numero%3 == 0) {
				
				media += numero;
				divisore++;
				
			}
				
		}
		
		return media/divisore;
	}
	
	public static void stampaZigZag (int[] array) {
		
		for (int i = 0; i <= array.length/2; i++) {
			
			if( i != array.length - 1 - i)
				System.out.print(array[i] + ", " + array[array.length - 1 - i] + ", " );
			else 
				System.out.print(array[i]);
		}
	}
	
	public String [] addString(String s, String[] a) {
		
		String [] res = new String [a.length + 1];
		
		for (int i = 0; i < a.length; i++) {
			
			res [i] = a[i];			
		}
		
		res[a.length] = s;
		
		return res;
	}
	
	
	public static void main(String[] args) {

		int[] numeri = {1,4,3,4,52};//{34,4,67,23,12,25};
		
		int max = Integer.MIN_VALUE;
		int indice = 0;
		
		for (int i = 0; i < numeri.length; i++ ) {
			
			if (numeri[i] > max) {
				max = numeri[i];
				indice = i;
			}
				
			
		}

	
		String [] res1 = {"ciao1", "ciao2"};
		String [] res = new EserciziArray().addString("ciao", res1 );
		
		for (String str: res)
			System.out.println(str);
		
	}

}
