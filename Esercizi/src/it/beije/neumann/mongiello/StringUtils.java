package it.beije.neumann.mongiello;

public class StringUtils {
	
	
	public static String indexOf ( String s, char c ) {
		for( int i = 0; i<s.length(); i++) {
			if( s.charAt(i) == c ) return String.valueOf(i);
		}
		return String.valueOf(-1);		
	}
	
	public static String indexOf(String s, char c, int fromIndex) {


		for( int i = fromIndex; i < s.length(); i++ ) {
			if( s.charAt(i) == c ) return String.valueOf(i);
		}
		return String.valueOf(-1);		
	}
	
	public static String indexOf(String s, String str){
		int j = 0;
		int position = -1;
		boolean check = false;
		for( int i = 0; i <s.length()-1;i++ ) {
				if( s.charAt(i) == str.charAt(j) ) {
					j++;
				
					if(!check) {
						check = true;
						position = i;
					}
				          if(j >= str.length()) return String.valueOf(position);

					}else {
						if( check ) {
							check = false;
							j=0;
							position = -1;
						}
					}
				}
			
		return String.valueOf(position);
	}
		
	public static String substring(String s, int beginIndex) {
		String appoggio = "";
		for( int i = beginIndex; i < s.length(); i++ ) {
			 appoggio += s.charAt(i);
		}
		return appoggio;
	}
	
	public static String substring(String s, int beginIndex, int endIndex) {
		String appoggio = "";
		for( int i = beginIndex; i < endIndex; i++ ) {
			 appoggio += s.charAt(i);
		}
		return appoggio;
	}
	
	public static String toUpperCase( String s ) {

		String upper = "";
		
		for ( int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if ( c >= 'a' && c <= 'z') {
				c -= 32;
				upper +=c;
			}
			else upper +=c;
		
		}
		return upper;
	}
	
	public static String toLowerCase( String s ) {
		String lower = "";
		
		for ( int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if ( c >= 'A' && c <= 'Z') {
				c += 32;
				lower +=c;
			}else lower +=c;	
		}
		return lower;
	}

	public static boolean equals(String s1, String s2) {
		boolean controllo = false;
		
		if( s1.length()  == s2.length() ) {
			for( int i = 0; i < s1.length(); i++ ) {
					if( s1.charAt(i) == s2.charAt(i) ) {
						controllo = true;
					}else {
						controllo = false;
					}
					if( !controllo ) return controllo;
				}
		}
		return controllo;		
	}

	public static boolean equalsIgnoreCase( String s1, String s2 ) {

		String s1Lower = StringUtils.toLowerCase(s1);
		String s2Lower = StringUtils.toLowerCase(s2);
		
		return StringUtils.equals(s1Lower, s2Lower);
		
	}

	public static boolean contains(String s, String str) {



		/*int j = 0;
		boolean check = false;
		for( int i = 0; i <s.length()-1;i++ ) {
				if( s.charAt(i) == str.charAt(j) ) {
					j++;
				
					if(!check) {
						check = true;

					}
				          if(j >= str.length()) return check;

					}else {
						if( check ) {
							check = false;
							j=0;
							
						}
					}
				}
		
		return check;
		*/
		
		String check =  StringUtils.indexOf( s, str );
		if( check.equals("-1") ) return false;
		return true;
		
	}

	public static boolean startsWith(String s, String prefix) {
		
	
		
		boolean check = false;
		
		for( int i = 0; i < prefix.length(); i++ ) {
			if( s.charAt(i) == prefix.charAt(i) ) {
				check = true;
			}else {
				check = false;
				return check;
			}
		}
		
		return true;
	}
		
	public static boolean endsWith(String s, String prefix) {
		
		
		String reverseS = "";
		String revereseP = "";
		
		for( int i = s.length()-1 ; i >= 0; i--  ) {
			reverseS += s.charAt(i);
		}
		for( int i = prefix.length()-1 ; i >= 0; i--  ) {
			revereseP += prefix.charAt(i);
		}
		boolean check =startsWith( reverseS, revereseP );
		
		return check;
		
		
	}
	
	public static String replace(String s, char oldChar, char newChar) throws NoCharException {
		
		String appoggio = "";
		
		if( StringUtils.indexOf(s, oldChar).equals("-1") ) {
			throw new NoCharException();
		}
		

		for(int i = 0; i< s.length(); i++) {
			if( s.charAt(i) == oldChar ) {
				appoggio +=  newChar;
			}else {
				appoggio += s.charAt(i);
			}
		}		
		return appoggio;
	}

	
}