package it.beije.boot.rubrica.controller.nicoleSOAP;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getNames")
public class GetNames {
	
	public GetNamesResponse getNames() {
		System.out.println("ok ok ok");
		
		return null;
	}

}
