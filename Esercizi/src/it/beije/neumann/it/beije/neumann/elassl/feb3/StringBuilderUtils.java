package it.beije.neumann.elassl.feb3;

public class StringBuilderUtils {
	public static StringBuilder append(StringBuilder sb, String str) {
	    return new StringBuilder(sb.toString() + str);
	  }
	  
	  public static StringBuilder insert(StringBuilder sb, int offset, String str) {
		String s = sb.toString();
		String result = "";
		for(int i=0; i<s.length(); i++) {
			if (i==offset) {
				for(int j=0; j<str.length(); j++) result+=str.charAt(j);
			}
			result+=s.charAt(i);
		}
	    return new StringBuilder(result);
	  }
	  
	  public static StringBuilder delete(StringBuilder sb, int start, int end) {
		String s = sb.toString();
		String result = "";
		for(int i=0; i<s.length(); i++) {
			if (i>=start && i<end) {}
			else
				result+=s.charAt(i);
		}
	    return new StringBuilder(result);
	  }
	  
	  public static StringBuilder deleteCharAt(StringBuilder sb, int index) {
	    return delete(sb, index, index + 1);
	  }
	  
	  public static StringBuilder reverse(StringBuilder sb) {
		String s = sb.toString();
		String result = "";
	    for (int i = sb.length() - 1; i >= 0; i--) {
	      result+=sb.charAt(i);
	    }
	    return new StringBuilder(result);
	  }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
