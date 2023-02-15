package it.beije.neumann.elassl.feb3;

import java.util.ArrayList;

public class ArrayListUtils {
	public static boolean equals(ArrayList one, ArrayList two) {
		if(one.size()!=two.size()) return false;
		for(int i=0; i<one.size();i++)
			if(!one.get(i).equals(two.get(i))) return false;
		return true;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
