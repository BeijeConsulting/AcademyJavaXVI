package it.beije.neumann.parserxml.elassl_verzaschi;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class progParser {
	//public static Element readElement()
	public static Element readName(String str) {
		String[] split=str.split(">");
		String first=split[0];
		if (first=="") return null;
		if(first.charAt(0)=='/') {
			System.out.println("	Chiusura "+first);
			String tagName= first.split(" ")[0];
		}
		else {
			System.out.println("	Apertura "+first);
			String tagName= first.split(" ")[0];
			String allAttributes= first.substring(tagName.length());
			System.out.println("	tagname: "+tagName);
			if(allAttributes!="" && allAttributes.split(" ").length>1) { // se ha attributi
				String [] arrs = allAttributes.split("=\"|\"");
				boolean isKey = true;
				String key="";
				String value="";
				for(String str2 : arrs) {
					if (isKey) {
						key=str2.strip();
					}
					else {
						value=str2.strip();
						System.out.println("	Attributo: key = "+key+" value = "+value);
					}
					isKey=!isKey;
					
				}
			}
			
		}
		String text=split.length==2?split[1]:"";
		System.out.println("Testo:"+text);
		
		
		return null;
		
	}
	public static DocumentEV parse(String file)  throws FileNotFoundException, IOException {
		DocumentEV result = new DocumentEV();
		String s="";
		try(FileReader fileReader = new FileReader(file); BufferedReader bufferedReader = new BufferedReader(fileReader);){
			while (bufferedReader.ready()) {
				s+=bufferedReader.readLine();
			}
		}catch (IOException ioEx) {
			ioEx.printStackTrace();
			throw ioEx;
		}
		String[] split=s.split("<");
		Element current=null;
		for(String str : split) {
			System.out.println(" ");
			if(str.equals("")) continue;
			String str2= str.strip();
			if (str2.length()>3 && !str2.substring(0,4).equals("?xml")) { 
				System.out.println(str2);
				current = readName(str2);
			}
			if (result.getRootElement()==null)
				result.setRootElement(current);
		}
		return null;
	}
	public static void main(String[] args) throws FileNotFoundException, IOException {
		// TODO Auto-generated method stub
		parse("C:\\Users\\mm\\git\\AcademyJavaXVI\\Esercizi\\src\\it\\beije\\neumann\\it\\beije\\neumann\\parserxml\\elassl_verzaschi\\test_parser6.xml");

	}

}
