package it.beije.neumann.elassl.feb3;



public class StringUtils {

	public static int indexOf(String s, char c) {
		for (int i=0;i<s.length();i++)
			if(s.charAt(i)==c)
				return i;
		return -1;
	}
	public static int indexOf(String s, char c, int fromIndex) {
		for (int i=fromIndex;i<s.length();i++)
			if(s.charAt(i)==c)
				return i;
		return -1;
	}
	
	int indexOf(String s, String str) {
		for (int i=0;i<s.length();i++) {
			for (int j=0; j<str.length() && j<s.length();j++) {
				if(str.charAt(j)!=s.charAt(i+j))
					break;
				if(j==str.length()-1)
					return i;
			}
		}
		return -1;
	}
	
	String substring(String s, int beginIndex) {
		StringBuilder str= new StringBuilder("");
		for (int i=0;i<s.length();i++) {
			str.append(s.charAt(i));
		}
		return str.toString();
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
