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

		// System.out.println(sb);

		return sb.toString();
	}

	public static ParserXML parse(String file) throws FileNotFoundException, IOException {
		ParserXML parser = new ParserXML();

		String xml = readXML(file);

		// List<Element> elements = getChildElements(fileContent);

		List<Node> nodeList = new ArrayList<>();
		List<Element> elementList = new ArrayList<>();

		int indexStart = xml.indexOf("<");
		while (indexStart != -1) {
			int indexEnd = xml.indexOf(">", indexStart);
			if (indexEnd != -1) {
				// System.out.println("indexStart - indexEnd -> " + indexStart + "-" +
				// indexEnd);
				// System.out.println("xml[indexStart] - xml[indexEnd] -> " +
				// xml.charAt(indexStart) + "-" + xml.charAt(indexEnd));

				String name = xml.substring(indexStart + 1, indexEnd);

				if (name.startsWith("/") || name.startsWith("?xml")) {
					indexStart = xml.indexOf("<", indexEnd);
					continue;
				}

				Element e = new Element();
				e.setName(name);
				indexStart = xml.indexOf("<", indexEnd);

				// Prendere i nodes stava qui

				String tmp = "</" + e.getName() + ">";

				// System.out.println("Temp -> " + tmp);

				int indexMiddle = xml.indexOf(tmp, indexEnd);

				if (indexMiddle != -1) {
					e.setContent(xml.substring(indexEnd + 1, indexMiddle));
					// indexStart = xml.indexOf("<", indexMiddle);
				} else {
					break;
				}

				indexStart = xml.indexOf("<", indexEnd);

				// Prendere i nodes
				// String text = xml.substring(lastCloseTagIndex + 1, indexStart).trim();
				String text = xml.substring(indexEnd + 1, indexStart);
				if (text.isBlank() && !text.isEmpty()) {
					Node n = new Node();
					n.setName("#text");
					n.setContent(text);
					nodeList.add(n);
				}

				elementList.add(e);

			} else {
				break;
			}
		}

		System.out.println("NodeList:\n" + nodeList);
		System.out.println("ElementList:\n" + elementList);

		/////////
		parser.setRootElement(elementList.get(0));
		elementList.remove(0);
		parser.setChildrenElements(elementList);
		parser.setChildrenNodes(nodeList);

		return parser;
	}
	
	public static List<Node> getChildNodes(Element el){
		return null;
	}

	public static void main(String[] args) {

		String file = "./src/it/beije/neumann/parserxml/vellani_nido/test_parser1.xml";

		try {
			ParserXML pxml = parse(file);

			// System.out.println(pxml.getChildren());

			// System.out.println(pxml.getRootElement());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
