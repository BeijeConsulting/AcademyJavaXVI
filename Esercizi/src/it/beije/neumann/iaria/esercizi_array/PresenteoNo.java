package it.beije.neumann.iaria.esercizi_array;

public class PresenteoNo {
	
	public boolean contains(int e, int[] array) {
		for(int i=0; i<array.length; i++) {
			if(e == array[i]) {
				return true;
			}
		}
		return false;
	}
	
	public boolean contains(Object  e, Object [] array) {
		for(int i=0; i<array.length; i++) {
			if(e == array[i]) {
				return true;
			}
		}
		return false;
	}

	public static void main(String[] args) {
		int[] array = {4,1,64,23,87,32};
		boolean esito1,esito2;
		PresenteoNo locontiene1 = new PresenteoNo();
		PresenteoNo locontiene2 = new PresenteoNo();
		esito1 = locontiene1.contains(23, array);
		esito2 = locontiene1.contains(23, array);
		System.out.println(esito1);
		System.out.println(esito2);
	}

}