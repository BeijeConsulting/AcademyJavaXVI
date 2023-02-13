package it.beije.neumann.parserxml.elassl_verzaschi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Element extends Node {
	String tagName; 
	String text;
	Attribute [] attributes;
	
	public Element(String tagName, String text, Attribute[] attributes) {
		super();
		this.tagName = tagName;
		this.text = text;
		this.attributes = attributes;
	}
	public List<Element> getChildElements(){
		//controlla se sono instanceof element di childNodes
		List<Element> elements = new ArrayList<>();
		for (Node node: childNodes)
			if(node instanceof Element)
				elements.add((Element) node);
		return elements;
	}

	public List<Element> getElementsByTagName(String tagName) {

		List<Element> fifo = new ArrayList<>();
		List<Element> result = new ArrayList<>();
		fifo.add(this);
		while(!fifo.isEmpty()) {
			Element current = fifo.remove(fifo.size()-1);
			if(current.getTagName().equals(tagName))
				result.add(current);
			List<Element> childrenElements = current.getChildElements();
			Collections.reverse(childrenElements);
			for(Element child: childrenElements) {
				fifo.add(child);
			}
		}
		return result;
	}
	
	public String getTagName() {
		return tagName;
	}

	public String getTextContent() {
		return text;
	}
	

	public void setTagName(String tagName) {
		this.tagName = tagName;
	}

	public Attribute [] getAttributes() {
		return attributes;
	}
	 
	public String getAttribute(String attribute) {
		for (Attribute attr: attributes)
			if(attr.getKey().equals(attribute))
				return attr.getValue();
		return null;
	}

	@Override
	public String toString() {
		return "Element [tagName=" + tagName + ", text=" + text + ", attributes=" + Arrays.toString(attributes) + "]";
	}

}
