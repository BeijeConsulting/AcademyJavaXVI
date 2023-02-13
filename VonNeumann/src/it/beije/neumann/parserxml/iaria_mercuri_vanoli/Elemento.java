package it.beije.neumann.parserxml.iaria_mercuri_vanoli;

import java.util.ArrayList;

public class Elemento {
	private String tag;
	private String textContext;
	private ArrayList<String> attributes;
	private ArrayList<Elemento> childElements;
	
	public Elemento(String tag, String textContext, ArrayList<String> attributes) {
		this.tag = tag;
		this.textContext = textContext;
		this.attributes = attributes;
		childElements = new ArrayList<Elemento>();
	}
	
	public String getTag() {
		return tag;
	}
	public String getTextContext() {
		return textContext;
	}

	public ArrayList<String> getAttributes() {
		return attributes;
	}
	
	public void addFiglio(Elemento e) {
		childElements.add(e);
	}
	
	public ArrayList<Elemento> getChildElements() {
		return childElements;
	}
	
	public ArrayList<Elemento> getElementsByTagName(String tagName) {
		ArrayList<Elemento> elementsWithTag = new ArrayList<Elemento>();
		getElementsByTagName(tagName, elementsWithTag);
		return elementsWithTag;
	}
	
	//metodo che permette il controllo di tutti i nodi in modo ricorsivo
	private void getElementsByTagName(String tagName, ArrayList<Elemento> elementsWithTag) {
		//controllo se il tag è quello che bisogna cercare, in tal caso lo aggiungo alla lista
		if (getTag().equals(tagName)) {
			elementsWithTag.add(this);
		}
		//adesso passo il check con la lista a tutti i figli
		for (Elemento e: getChildElements()) {
			e.getElementsByTagName(tagName, elementsWithTag);
		}
	}

	@Override
	public String toString() {
		return "Elemento [tag=" + tag + ", textContext=" + textContext + ", attributes=" + attributes + "]";
	}
}
