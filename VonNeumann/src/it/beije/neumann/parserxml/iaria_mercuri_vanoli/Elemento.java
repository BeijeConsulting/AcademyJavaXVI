package it.beije.neumann.parserxml.iaria_mercuri_vanoli;

import java.util.ArrayList;

public class Elemento {
	private String tag;
	private String textContext;
	private ArrayList<Attributo> attributes;
	private ArrayList<Elemento> childElements;
	private Elemento parent;

	public Elemento(String tag, String textContext, String[] attrStrings, Elemento parent) {
		this.tag = tag;
		this.textContext = textContext;
		this.parent = parent;
		childElements = new ArrayList<Elemento>();
		//costruzione struttura degli attributi
		this.attributes = new ArrayList<Attributo>();
		if (attrStrings != null) {
			for (int i = 0; i < attrStrings.length; i += 2) {
				this.attributes.add(new Attributo(attrStrings[i], attrStrings[i + 1]));
			}
		}
	}
	
	public String getTag() {
		return tag;
	}
	public String getTextContext() {
		return textContext;
	}

	public ArrayList<Attributo> getAttributes() {
		return attributes;
	}
	
	public String getAttribute(String attribute) {
		for (Attributo a : attributes) {
			if (a.getName().equals(attribute)) {
				return a.getValue();
			}
		}
		return "Attributo non trovato!";
	}
	
	public Elemento getParent() {
		return parent;
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

	public void stampaAlbero() {
		stampaAlbero("");		
	}
	
	private void stampaAlbero(String indent) {
		System.out.println(indent + toString());
		for(Elemento e: getChildElements()) {
			e.stampaAlbero(indent + "   ");
		}
	}
	
	@Override
	public String toString() {
		return "Elemento [tag=" + tag + ", textContext=" + textContext + ", attributes=" + attributes + "]";
	}
}
