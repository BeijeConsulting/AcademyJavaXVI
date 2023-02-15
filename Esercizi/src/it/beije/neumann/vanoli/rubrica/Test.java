package it.beije.neumann.vanoli.rubrica;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;

import org.xml.sax.SAXException;

public class Test {

	public static void main(String[] args) throws FileNotFoundException, IOException, ParserConfigurationException, SAXException, TransformerException, ClassNotFoundException {
		//List<Contatto> contatti = CSVManager.loadRubricaFromCSV("/temp/rubrica.csv", ";");
		List<Contatto> contatti = XMLManager.loadRubricaFromXML("/temp/rubricona.xml");
		RubricaJDBC.WriteRubricaToDB(contatti);
        //CSVManager.writeRubricaCSV(contatti, "/temp/rubricona.csv", ";");
		//XMLManager.writeRubricaXML(contatti, "/temp/rubricona.xml");
	}

}
