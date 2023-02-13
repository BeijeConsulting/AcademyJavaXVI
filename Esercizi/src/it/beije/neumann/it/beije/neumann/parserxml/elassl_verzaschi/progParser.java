package it.beije.neumann.parserxml.elassl_verzaschi;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class progParser {
	//public static Element readElement()
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
		System.out.println(split);
		return null;
	}
	public static void main(String[] args) throws FileNotFoundException, IOException {
		// TODO Auto-generated method stub
		parse("C:\\Users\\mm\\git\\AcademyJavaXVI\\Esercizi\\src\\it\\beije\\neumann\\it\\beije\\neumann\\parserxml\\elassl_verzaschi\\test_parser1.xml");

	}

}
