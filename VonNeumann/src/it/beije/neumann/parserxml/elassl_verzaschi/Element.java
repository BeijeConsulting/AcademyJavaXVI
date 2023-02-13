package it.beije.neumann.parserxml.elassl_verzaschi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Element extends Node {
	String tagName; 
	String text;
	Attribute [] attributes;
	public List<Element> getChildElements(){
		//controlla se sono instanceof element di childNodes
		List<Element> elements = new ArrayList<>();
		for (Node node: childNodes)
			if(node instanceof Element)
				elements.add((Element) node);
		return elements;
	}

	public Element[] getElementsByTagName(String tagName) {
		return null;
		// BSF e ritorna se il tag coincide
	}
	
	public String getTagName() {
		return tagName;
	}

	public String getTextContent() {
		return text;
	}
	
	public Element(String tagName, String text, Attribute[] attributes) {
		super();
		this.tagName = tagName;
		this.text = text;
		this.attributes = attributes;
	}

	public void setTagName(String tagName) {
		this.tagName = tagName;
	}

	public Attribute [] getAttributes() {
		return attributes;
	}
	 
	public String getAttribute(String attribute) {
		for (Attribute attr: attributes)
			if(attr.getKey() == attribute)
				return attr.getValue();
		return null;
	}

	@Override
	public String toString() {
		return "Element [tagName=" + tagName + ", text=" + text + ", attributes=" + Arrays.toString(attributes) + "]";
	}

}
