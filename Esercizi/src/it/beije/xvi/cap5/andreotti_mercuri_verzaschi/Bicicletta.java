package it.beije.xvi.cap5.andreotti_mercuri_verzaschi;



public class Bicicletta extends Biciclo
{

	public Bicicletta( int capienza, String modello, int velocitaMedia) 
	{
		super(1, modello, 15);
		
	}
	

	public void suonaCampanello()
	{
		System.out.println("Driiiin driiiin");
	}
	
	
	
}
