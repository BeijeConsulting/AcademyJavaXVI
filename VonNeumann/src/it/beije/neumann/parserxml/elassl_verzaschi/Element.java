package it.beije.neumann.parserxml.elassl_verzaschi;

import java.util.Arrays;

public class Element extends Node {
	String tagName; 
	String text;
	Attribute [] attributes;
	public Element[] getChildElements(){
		//controlla se sono instanceof element di childNodes
		
		return null;
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
