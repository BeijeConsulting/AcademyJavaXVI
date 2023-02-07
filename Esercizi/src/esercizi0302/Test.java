package esercizi0302;

public class Test {
	
	static { add(2); }
	static void add(int num) { System.out.print(num + " "); }
	Test() { add(5); }
	static { add(4); }
	
	{ add(6); }
	
	static { new Test(); }
	{ add(8); }
	
	public static void main(String[] args) { 
		
		
	} 
	// 2 4 8 6 5
	// 2 4 6 8 5
}




