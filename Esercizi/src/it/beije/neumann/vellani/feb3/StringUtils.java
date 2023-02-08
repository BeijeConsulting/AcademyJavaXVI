package it.beije.neumann.vellani.feb3;

public class StringUtils {

	public static void main(String[] args) {

	}
	
	public static int indexOf(String s, char c) {
	    for (int i = 0; i < s.length(); i++) {
	        if (s.charAt(i) == c) {
	            return i;
	        }
	    }
	    return -1;
	}
	
	public static int indexOf(String s, char c, int fromIndex) {
	  for (int i = fromIndex; i < s.length(); i++) {
	    if (s.charAt(i) == c) {
	      return i;
	    }
	  }
	  return -1;
	}
	
	public static String substring(String s, int beginIndex) {
	    char[] chars = new char[s.length() - beginIndex];
	    for (int i = beginIndex; i < s.length(); i++) {
	        chars[i - beginIndex] = s.charAt(i);
	    }
	    return new String(chars);
	}
	
	public static String substring(String s, int beginIndex, int endIndex) {
	    char[] chars = new char[endIndex - beginIndex];
	    for (int i = beginIndex; i < endIndex; i++) {
	        chars[i - beginIndex] = s.charAt(i);
	    }
	    return new String(chars);
	}

	public static String toLowerCase(String s) {
	    char[] chars = s.toCharArray();
	    for (int i = 0; i < chars.length; i++) {
	        if (chars[i] >= 'A' && chars[i] <= 'Z') {
	            chars[i] = (char)(chars[i] + 32);
	        }
	    }
	    return new String(chars);
	}

	public static String toUpperCase(String s) {
	    char[] chars = s.toCharArray();
	    for (int i = 0; i < chars.length; i++) {
	        if (chars[i] >= 'a' && chars[i] <= 'z') {
	            chars[i] = (char)(chars[i] - 32);
	        }
	    }
	    return new String(chars);
	}

	public static boolean equals(String s1, String s2) {
	    if (s1.length() != s2.length()) {
	        return false;
	    }
	    for (int i = 0; i < s1.length(); i++) {
	        if (s1.charAt(i) != s2.charAt(i)) {
	            return false;
	        }
	    }
	    return true;
	}

	public static boolean equalsIgnoreCase(String s1, String s2) {
	    if (s1.length() != s2.length()) {
	        return false;
	    }
	    for (int i = 0; i < s1.length(); i++) {
	        char char1= Character.toLowerCase(s1.charAt(i));
	        char char2 = Character.toLowerCase(s2.charAt(i));
	        if (char1 != char2) {
	            return false;
	        }
	    }
	    return true;
	}
	
	public static boolean contains(String s, String str) {
	    for (int i = 0; i <= s.length() - str.length(); i++) {
	        if (s.startsWith(str, i)) {
	            return true;
	        }
	    }
	    return false;
	}
	
	public static boolean startsWith(String s, String prefix) {
	    if (s.length() < prefix.length()) {
	        return false;
	    }
	    for (int i = 0; i < prefix.length(); i++) {
	        if (s.charAt(i) != prefix.charAt(i)) {
	            return false;
	        }
	    }
	    return true;
	}
	
	public static boolean endsWith(String s, String suffix) {
	    if (s.length() < suffix.length()) {
	        return false;
	    }
	    int offset = s.length() - suffix.length();
	    for (int i = 0; i < suffix.length(); i++) {
	        if (s.charAt(offset + i) != suffix.charAt(i)) {
	            return false;
	        }
	    }
	    return true;
	}
}
