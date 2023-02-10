package it.beije.neumann.rubrica.nicole;
/**
 * Scrivo la mia RubricaCSV
 */
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import it.beije.neumann.rubrica.*;
public class CSVManager 
{
	
	public static void writeRubrica(List<Contatto> contatti,String pathFile, String separator) throws IOException
	{
		
		FileWriter writer= new FileWriter(pathFile);
		try {
			
			writer.append("COGNOME;NOME;TELEFONO;EMAIL;NOTE");
			writer.write(System.lineSeparator());
			String [] contacts=null;
			for(Contatto c : contatti)
			{
				String name=c.getName();
				String surname=c.getSurname();
				String tel=c.getTelephone();
				String email=c.getEmail();
				String note=c.getNote();
				
				
				
				writer.append(name+separator+surname+separator+tel+separator+email+separator+note);
				writer.write(System.lineSeparator());
				
				
				
				
			}
		}
			catch(IOException ioEx)
			{
				ioEx.printStackTrace();
			}
			finally
			{
				writer.close();
			}
		
		
		
		
	}
	
	
	public static void main(String[] args) 
	{
		try
		{
			/**
			 * creo due contatti
			 */
			List<Contatto> contatti= new ArrayList<>();
			Contatto c1= new Contatto();
			c1.setName("nicole");
			c1.setSurname("verzaschi");
			contatti.add(c1);
			
			Contatto c2= new Contatto();
			c2.setName("Lidia");
			c2.setSurname("Mometti");
			c2.setTelephone("nessun telefono");
			c2.setEmail("lilli@gmail");
			c2.setNote("figlia");
			contatti.add(c2);
			
			
			
			writeRubrica(contatti,"C:\\Users\\nverz\\Music\\esercizio.\\Miarubrica.csv",";");
			
			
			
			
			
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		
		
		
	}

}
