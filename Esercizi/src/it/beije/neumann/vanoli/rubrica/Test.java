package it.beije.neumann.vanoli.rubrica;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;

import org.xml.sax.SAXException;

public class Test {

	public static void main(String[] args) throws FileNotFoundException, IOException, ParserConfigurationException, SAXException, TransformerException, ClassNotFoundException {
		System.out.println("Classe di test");
		//List<Contatto> contatti = CSVManager.loadRubricaFromCSV("/temp/rubrica.csv", ";");
		List<Contatto> contatti = RubricaHBM.LoadRubricaFromDB();
		//RubricaHBM.WriteRubricaToDB(contatti);
        CSVManager.writeRubricaCSV(contatti, "/temp/rubricona.csv", ";");
		//XMLManager.writeRubricaXML(contatti, "/temp/rubricona.xml");
	}

}
