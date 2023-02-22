package it.beije.neumann.parserxml.elassl_verzaschi;

public class Attribute {
	private String key;
	private String value;
	
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		//this.key = key.strip();
		this.key = key.trim();
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public String toString() {
		return "key:"+key+" value:"+value; 
	}
}
