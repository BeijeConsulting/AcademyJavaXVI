package it.beije.neumann.nido.gestorerubrica;

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

}
