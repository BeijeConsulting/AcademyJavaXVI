package it.beije.neumann.parserxml.elassl_verzaschi;

import java.util.ArrayList;
import java.util.List;

public class Node {
	String attribute;
	List<Node> childNodes;
	
	public Node() {
		childNodes=new ArrayList<>();
	}
	public List<Node> getChildNodes(){
		return childNodes;
	}
	public void addChildNode(Node e) {
		childNodes.add(e);
	}
	//toString
}
