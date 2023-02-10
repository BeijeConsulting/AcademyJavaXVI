package it.beije.neumann.rubrica.nicole;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import it.beije.neumann.rubrica.*;
public class Esercizio 
{
	public static void creaRubrica(List<Contatto> contatti) throws IOException
	{
		
		
		
		
		
	}
	
	
	public static void main(String[] args) throws IOException
	{
		File miaRubrica= new File("C:\\Users\\nverz\\Music\\esercizio.\\miaRubrica.csv");
		miaRubrica.createNewFile();
		FileWriter writerRubrica= new FileWriter(miaRubrica);
	
		writerRubrica.write("ciao");
		
		
		
		
	}

}
