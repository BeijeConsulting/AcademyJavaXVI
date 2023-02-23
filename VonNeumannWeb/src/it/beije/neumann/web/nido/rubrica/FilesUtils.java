package it.beije.neumann.web.nido.rubrica;

import java.util.ArrayList;
import java.util.List;

import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class FilesUtils {

	//CSV
	
	
	//XML
	public static void removeHeaderXML() {
		System.out.println("**Not implemented yet, sorry :(**\n");
	}
	
	public static List<Element> getChildElementsXML(Element e) {
		List<Element> elements = new ArrayList<Element>();
		NodeList childNodes = e.getChildNodes();
		for (int i = 0; i < childNodes.getLength(); i++) {
			Node node = childNodes.item(i);
			if (node instanceof Element) {
				elements.add((Element) node);
			}
		}

		return elements;
	}
	
	
	//DB
	public static String formatPeakDB(String str) {
		return str.replace("'", "''");
	}
	
	public static String formatNewField(String oldValue, String addValue) {
		StringBuilder worker = new StringBuilder();
		String newValue = null;
		
		worker.append(oldValue).append(" - ").append(addValue);
		newValue = worker.toString();
		
		if (newValue.contains("- -")) {
			newValue = newValue.replace("- -", "-");
		}
		
		return newValue.trim();
	}

}
