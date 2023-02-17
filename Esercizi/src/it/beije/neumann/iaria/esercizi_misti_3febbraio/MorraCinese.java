package it.beije.neumann.iaria.esercizi_misti_3febbraio;

public class MorraCinese {
	String vincitore = "Ok";
	public String SassoCartaForbice(String mano1, String mano2) {
		if(mano1 == "carta" || mano1 == "forbice" || mano1 == "sasso") {
			if(mano2 == "carta" || mano2 == "forbice" || mano2 == "sasso") {
				if(mano1 == "sasso" && mano2 == "forbice") {
					vincitore = mano1;					
				} else if(mano1 == "carta" && mano2 == "sasso") {
					vincitore = mano1;
				} else if(mano1 == "forbice" && mano2 == "carta") {
					vincitore = mano1;
				} else {
					vincitore = mano2;
				}
			}
		}
		return vincitore;
	}

	public static void main(String[] args) {
		MorraCinese chivince = new MorraCinese();
		System.out.println(chivince.SassoCartaForbice("forbice","sasso"));
	}

}
