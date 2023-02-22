package it.beije.neumann.parserxml.vellani_nido;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ParserXML {

	private Element rootElement;
	private List<Node> childrenNodes;
	private List<Element> childrenElements;

	public Element getRootElement() {
		return rootElement;
	}

	public void setRootElement(Element rootElement) {
		this.rootElement = rootElement;
	}

	public List<Node> getChildrenNodes() {
		return childrenNodes;
	}

	public void setChildrenNodes(List<Node> childrenNodes) {
		this.childrenNodes = childrenNodes;
	}

	public List<Element> getChildrenElements() {
		return childrenElements;
	}

	public void setChildrenElements(List<Element> children) {
		this.childrenElements = children;
	}

	private static String readXML(String file) throws FileNotFoundException, IOException {
		FileReader fileReader = new FileReader(file);
		BufferedReader bufferedReader = new BufferedReader(fileReader);
		StringBuilder sb = new StringBuilder();

		try {
			while (bufferedReader.ready()) {
				sb.append(bufferedReader.readLine());
				sb.append("\n");
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			bufferedReader.close();
		}

		return sb.toString();
	}

	public static ParserXML parse(String file) throws FileNotFoundException, IOException {
		ParserXML parser = new ParserXML();

		String xml = readXML(file);

		List<Node> nodeList = new ArrayList<>();
		List<Element> elementList = new ArrayList<>();

		int indexStart = xml.indexOf("<");
		while (indexStart != -1) {
			int indexEnd = xml.indexOf(">", indexStart);
			if (indexEnd != -1) {

				String name = xml.substring(indexStart + 1, indexEnd);

				if (name.startsWith("?xml")) {
					indexStart = xml.indexOf("<", indexEnd);
					continue;
				} else if (name.startsWith("/")) {
					indexStart = xml.indexOf("<", indexEnd);

					if (indexStart != -1) {
						String text = xml.substring(indexEnd + 1, indexStart);
						if (text.matches("\\s*") && !text.isEmpty()) {
							Node n = new Node();
							n.setName("#text");
							n.setContent(text);
							nodeList.add(n);
						}
						continue;
					} else {
						break;
					}
				}

				Element e = new Element();
				e.setName(name);
				indexStart = xml.indexOf("<", indexEnd);

				String text = xml.substring(indexEnd + 1, indexStart);
				if (text.matches("\\s*") && !text.isEmpty()) {
					Node n = new Node();
					n.setName("#text");
					n.setContent(text);
					nodeList.add(n);
				}

				String tmp = "</" + e.getName() + ">";

				int indexMiddle = xml.indexOf(tmp, indexEnd);

				if (indexMiddle != -1) {
					e.setContent(xml.substring(indexEnd + 1, indexMiddle));
				} else {
					break;
				}

				elementList.add(e);

			} else {
				break;
			}
		}

		// System.out.println("NodeList:\n" + nodeList);
		// System.out.println("ElementList:\n" + elementList);

		/////////
		parser.setRootElement(elementList.get(0));
		elementList.remove(0);
		parser.setChildrenElements(elementList);
		parser.setChildrenNodes(nodeList);

		return parser;
	}

	// torna i soli elementi figli dell'elemento su cui viene eseguito
	public static List<Element> getChildElements() {
		return null;
	}

	// torna TUTTI gli elementi con quello specifico nome
	public static List<Element> getElementsByTagName(String tagName) {
		return null;
	}

	// torna il nome del tag
	public static String getTagName() {
		return null;
	}

	// torna il contenuto del tag
	public static String getTextContent() {
		return null;
	}

	// torna l'elenco degli attributi dell'elemento
	public static List<String> getAttributes() {
		return null;
	}

	// torna il valore dell'attributo specificato
	public static String getAttribute(String attribute) {
		return null;
	}

	public static void main(String[] args) {

		String file = "./src/it/beije/neumann/parserxml/vellani_nido/test_parser1.xml";

		try {
			ParserXML pxml = parse(file);

			System.out.println(pxml.getRootElement()); // metodo 1
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
