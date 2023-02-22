package it.beije.neumann.parserxml.iaria_mercuri_vanoli;

public class Attributo {
	private String name;
	private String value;
	
	public Attributo(String name, String value) {
		this.name = name;
		this.value = value;
	}
	
	public String getName() {
		return name;
	}
	
	public String getValue() {
		return value;
	}
	
	@Override
	public String toString() {
		return "Attributo [name=" + name + ", value=" + value + "]";
	}
}
