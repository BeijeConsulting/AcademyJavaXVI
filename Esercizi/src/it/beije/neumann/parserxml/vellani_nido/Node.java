package it.beije.neumann.parserxml.vellani_nido;

public class Node {
	
	private String name;
	private String content;
	
	public Node() {
		super();
	}
	public Node(String name) {
		this(name,null);
	}
	public Node(String name, String content) {
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
	@Override
	public String toString() {
		return "Node [name=" + name + ", content=" + content + "]\n";
	}
}
