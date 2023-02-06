package it.beije.xvi.cap5.andreotti_mercuri_verzaschi;




public class Automobile extends Quadriciclo implements HaMotore, HaRadio, HaPorte
{

	private String carburante;
	private int numeroPorte;
	boolean isAccesa;
	public Automobile(int capienza, String modello, int velocitaMedia,int numeroPorte,String carburante)
	{
		super(capienza, modello, velocitaMedia);
		this.numeroPorte=numeroPorte;
		this.carburante=carburante;
		
	}

	@Override
	public void apriPorte() {
		
		System.out.println("Numero porte aperte: "+numeroPorte);
	}

	@Override
	public void accendiSpegni() 
	{
		isAccesa=!isAccesa;
		if(isAccesa) System.out.println("La macchina è accesa");
		else System.out.println("La macchina è spenta");
		
		
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
