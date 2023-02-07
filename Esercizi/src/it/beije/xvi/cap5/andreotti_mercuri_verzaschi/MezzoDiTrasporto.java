package it.beije.xvi.cap5.andreotti_mercuri_verzaschi;

public abstract class MezzoDiTrasporto 
{
	private int numeroRuote;
	private int capienza;
	private String modello;
	private int velocitaMedia;
	
	
	public MezzoDiTrasporto(int numeroRuote, int capienza,String modello, int velocitaMedia)
	{
		this.capienza=capienza;
		this.modello=modello;
		this.numeroRuote=numeroRuote;
		this.velocitaMedia=velocitaMedia;
	}

	
	/**
	 * getter variabili d'istanza
	 * @return
	 */
	
	
	public int getNumeroRuote()
	{
		return numeroRuote;
	}
	
	
	public int getCapienza()
	{
		return capienza;
	}
	
	public String getModello()
	{
		return modello;
	}
	
	public int getVelocitaMedia()
	{
		return velocitaMedia;
	}
	
	
}
