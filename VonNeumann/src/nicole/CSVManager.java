package nicole;
/**
 * Aggiungo contatti alla rubrica.csv
 */

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;




public class CSVManager 
{
	
	public static void writeRubrica(List<Contatto> contatti,String pathFile, String separator) throws IOException
	{
		/**
		 * aggiungo true al costruttore di FileWriter così da non sovrascrivere il file
		 */
		
		FileWriter writer= new FileWriter(pathFile,true);
		try {
			
			writer.write(System.lineSeparator());
			
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
	
	public static List<Contatto> readRubrica(String pathfile) throws FileNotFoundException, IOException {
		FileReader fileReader = new FileReader(pathfile);
		BufferedReader bufferedReader = new BufferedReader(fileReader);
		List<Contatto> contatti = new ArrayList<Contatto>();
		
		try {
			String r = null;
			String[] fields = null;
			Contatto contatto = null;
			while (bufferedReader.ready()) {
				r = bufferedReader.readLine();
				fields = r.split(";");
				
				contatto = new Contatto();
				contatto.setSurname(fields[0]);
				contatto.setName(fields[1]);
				contatto.setTelephone(fields[2]);
				contatto.setEmail(fields[3]);
				contatto.setNote(fields[4]);
				
				contatti.add(contatto);
				
				//System.out.println(contatto);
			}
		} catch (IOException ioEx) {
			ioEx.printStackTrace();
			throw ioEx;
		} finally {
			bufferedReader.close();
		}
		
		return contatti;
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
			
			
			
			writeRubrica(contatti,"C:\\Users\\nverz\\Music\\esercizio.\\rubrica.csv",";");
			
			
			
			
			
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		
		
		
	}

}
