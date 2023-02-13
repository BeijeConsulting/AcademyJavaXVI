package it.beije.neumann.parserxml.elassl_verzaschi;

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
	
	public Attribute [] getAttributes() {
		return attributes;
	}
	 
	public String getAttribute(String attribute) {
		for (Attribute attr: attributes)
			if(attr.getKey() == attribute)
				return attr.getValue();
		return null;
	}
	
}
