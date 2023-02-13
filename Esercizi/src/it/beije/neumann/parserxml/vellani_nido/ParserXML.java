package it.beije.neumann.parserxml.vellani_nido;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ParserXML {

	private Element rootElement;
	private List<Element> children;

	public Element getRootElement() {
		return rootElement;
	}

	public void setRootElement(Element rootElement) {
		this.rootElement = rootElement;
	}

	public List<Element> getChildren() {
		return children;
	}

	public void setChildren(List<Element> children) {
		this.children = children;
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

		String fileContent = readXML(file);

		List<Element> elements = getChildElements(fileContent);
		parser.setRootElement(elements.get(0));
		elements.remove(0);
		parser.setChildren(elements);

		return parser;
	}

	private static List<Element> getChildElements(String xml) {
		List<Element> childElements = new ArrayList<>();

		int indexStart = xml.indexOf("<");
		while (indexStart != -1) {
			int indexEnd = xml.indexOf(">", indexStart);
			if (indexEnd != -1) {
				String name = xml.substring(indexStart + 1, indexEnd);

				if (name.startsWith("/")) {
					indexStart = xml.indexOf("<", indexEnd);
					continue;
				}

				Element e = new Element();
				e.setName(xml.substring(indexStart + 1, indexEnd));

				String tmp = "</" + e.getName() + ">";

				//System.out.println("Temp -> " + tmp);

				if (tmp.startsWith("</?xml")) {
					indexStart = xml.indexOf("<", indexEnd);
					continue;
				}

				int indexMiddle = xml.indexOf(tmp, indexEnd);

				if (indexMiddle != -1) {
					e.setContent(xml.substring(indexEnd + 1, indexMiddle));
					indexStart = xml.indexOf("<", indexMiddle);
				} else {
					break;
				}

				e.setContent(xml.substring(indexEnd + 1, indexMiddle));

				indexStart = xml.indexOf("<", indexEnd);
				
				childElements.add(e);

				//System.out.println(e);

			} else {
				break;
			}
		}
		return childElements;
	}

	public static void main(String[] args) {

		String file = "./src/it/beije/neumann/parserxml/vellani_nido/test_parser1.xml";

		try {
			ParserXML pxml = parse(file);

			System.out.println(pxml.getChildren());
			
			System.out.println(pxml.getRootElement());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
