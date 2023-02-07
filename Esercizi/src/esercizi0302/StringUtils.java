package esercizi0302;

public class StringUtils {

	public static int indexOf(String s, char c) {
		
		int i = 0;
		
		for(; i < s.length(); i++) {
			
			if (s.charAt(i) == c) return i;
			
		}
		
		return -1;
	}
	
	public static int indexOf(String s, char c, int fromIndex) {
		
		int i = fromIndex;
		
		for(; i < s.length(); i++) {
			
			if (s.charAt(i) == c) return i;
			
		}
		
		return -1;
	}

	public static int indexOf(String s, String str) {
		
		int i = 0;
		
		for(; i < s.length(); i++) {
			
			int k = i;

			for (int j = 0; j < str.length() && k < s.length(); j++, k++){
								
				if (s.charAt(k) != str.charAt(j)) {
					
					break;
				}
				
				
				if (j == (str.length() - 1)) return i;
				
			}
			
		}
		
		return -1;
	}

	public static int indexOf(String s, String str, int fromIndex) {
		
		int i = fromIndex;
		
		for(; i < s.length(); i++) {
			
			int k = i;

			for (int j = 0; j < str.length() && k < s.length(); j++, k++){
								
				if (s.charAt(k) != str.charAt(j)) {
					
					break;
				}
				
				
				if (j == (str.length() - 1)) return i;
				
			}
			
		}
		
		return -1;
	}
	
	public static String substring(String s, int beginIndex) {
		
		StringBuilder sb = new StringBuilder();
		
		for (int i = beginIndex; i < s.length(); i++)
			sb.append(s.charAt(i));
		
		return sb.toString();
	}

	public static String substring(String s, int beginIndex, int endIndex) {
		
		StringBuilder sb = new StringBuilder();
		
		for (int i = beginIndex; i < endIndex; i++)
			sb.append(s.charAt(i));
		
		return sb.toString();
	}
	
	public static String toLowerCase(String s) {
		
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < s.length(); i++) {
			
			if (s.charAt(i) >= 'A' && s.charAt(i) <= 'Z') 
				sb.append((char)(s.charAt(i) + 32));
			else
				sb.append(s.charAt(i));
		}
		return sb.toString();
	}
	
	
	public static boolean equals(String str1, String str2) {
		
		if (str1.length() == str2.length()) {			
		
			for(int i = 0; i< str1.length(); i++) {
				
				if(str1.charAt(i) != str2.charAt(i)) {
					
					return false;
				}
				
			}
			
			return true;
		}
		
		return false;
		
	}
	
	public static boolean equalsIgnoreCase(String str1, String str2) {
		
		if (str1.length() == str2.length()) {			
		
			str1 = toLowerCase(str1);
			str2 = toLowerCase(str2);
			
			for(int i = 0; i < str1.length(); i++) {
				
				if(str1.charAt(i) != str2.charAt(i)) {
					
					return false;
				}
				
			}
			
			return true;
		}
		
		return false;
		
	}
	
	public static boolean contains(String s, String str) {
		
		if (s.length() >= str.length()) {
			
			for (int i = 0; i < s.length() - str.length() + 1; i++) {
				
				for (int j = 0; j < str.length(); j++) {
					
					if (str.charAt(i) != s.charAt(i + j)) {
						
						return false;
					}
				}
			}
		}
		
		return true;
		
	}
	
	public static void main(String[] args) {
		

		System.out.println(equalsIgnoreCase("ciao","cial"));
		

		
		
	}
	
	

}
