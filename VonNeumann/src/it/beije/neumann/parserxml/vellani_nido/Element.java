package it.beije.neumann.parserxml.vellani_nido;

import java.util.List;

public class Element extends Node {

	private String name;
	private String content;

	public Element() {
		super();
	}

	public Element(String name) {
		this(name, null);
	}

	public Element(String name, String content) {
		super();
		this.name = name;
		this.content = content;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	// torna tutti i nodi "figli" interni all'elemento su cui viene eseguito
	public static List<Node> getChildNodes() {
		
		
		return null;
	}

	@Override
	public String toString() {
		return "Element [name=" + name + ", content=" + content + "]\n";
	}

}
