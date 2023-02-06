package it.beije.xvi.cap5.andreotti_mercuri_verzaschi;

public class Moto extends Biciclo implements HaMotore, HaRadio
{

	private boolean isAccesa;
	private String carburante;
	public Moto(String modello, int velocitaMedia, String carburante) {
		super(2, modello, velocitaMedia);
		this.carburante=carburante;
		
	}

	@Override
	public void accendiSpegni() 
	{
		
		isAccesa=!isAccesa;
		if(isAccesa) System.out.println("La moto è accesa");
		else System.out.println("La moto è spenta");
	}

	@Override
	public void manutenzione() 
	{
		System.out.println("Manutenzione eseguita.");
		
	}
	

	public String getCarburante()
	{
		return carburante;
	}
}
