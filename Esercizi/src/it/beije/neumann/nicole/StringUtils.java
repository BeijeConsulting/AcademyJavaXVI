package it.beije.neumann.nicole;
/**
 * String indexOf(String s, char c)
String indexOf(String s, char c, index fromIndex)
String indexOf(String s, String str)
String indexOf(String s, String str, index fromIndex)
String substring(String s, int beginIndex)
String substring(String s, int beginIndex, int endIndex)
String toLowerCase(String s)
String toUpperCase(String s)
boolean equals(String s1, String s2)
boolean equalsIgnoreCase(String s1, String s2)
boolean contains(String s, String str)
boolean startsWith(String s, String prefix)
boolean endsWith(String s, String suffix)
String replace(String s, char oldChar, char newChar)
String replace(String s, String oldChar, String newChar)
String trim(String s)
 * @author nverz
 *
 */
public class StringUtils 
{

	private String stringa;
	
	public void setStringa(String stringa)
	{
		this.stringa=stringa;
	}
	
	public static String indexOf(String s, char c)
	{
		String trovato="";
		int i=0;
		while(i<s.length())
		{
			if(s.charAt(i)==c) return i+"";
			
			else trovato=-1+"";
			i++;
			
		}
		
		return trovato;
	}
	
	
	
	
	
	public static String indexOf(String s, char c, int fromIndex)
	{
		String trovato="";
		int i=fromIndex;
		while(i<s.length())
		{
			if(s.charAt(i)==c) trovato=i+"";
			else trovato=-1+"";
			i++;
			
		}
		
		return trovato;
		
	}
	
	
	public static String indexOf( String stringa, String s)
	{
		String trovato="";
		int i=0;
		int j=0;
		while((i<s.length())&& (j<s.length()))		{
			if(s.charAt(i)==s.charAt(j)) trovato=i+"";
			else trovato=-1+"";
			i++;
			j++;
			
		}
		
		return trovato;
		
	}
	
	public static String indexOf( String stringa, String s, int fromIndex)
	{
		String trovato="";
		int i=fromIndex;
		int j=0;
		while((i<s.length())&& (j<s.length()))		{
			if(s.charAt(i)==s.charAt(j)) trovato=i+"";
			else trovato=-1+"";
			i++;
			j++;
			
		}
		
		return trovato;
		
	}
	
	public static String substring(String s, int beginIndex)
	{
		String nuova="";
		int i=beginIndex;
		while(i<s.length())
		{
			nuova+=s.charAt(i);
			i++;
			
			
		}
		
		return nuova;
	}
	
	public static String substring(String s, int beginIndex,int endIndex)
	{
		String nuova="";
		int i=beginIndex;
		while((i<endIndex))
		{
			nuova+=s.charAt(i);
			i++;
			
			
		}
		
		return nuova;
	}
	
	
	public static String toLowerCase(String s)
	{
		String nuova="";
		for(int i=0; i<s.length() ;i++)
		{
			char c=s.charAt(i);
			if((c>='A' ) && (c<= 'Z'))
			{
				c+=32;
				nuova+=c;
				
			}
			else nuova+=c;
			
		}
		return nuova;
		
		
	}
	
	public static String toUpperCase(String s)
	{

		String nuova="";
		for(int i=0; i<s.length() ;i++)
		{
			char c=s.charAt(i);
			if((c>='A' ) && (c<= 'Z'))
			{
				c-=32;
				nuova+=c;
			}
			else nuova+=c;
			
		}
		return nuova;
		
		
		
		
	}
	public static boolean equals(String s, String t)
	{
		for(int i=0; i<s.length(); i++)
		{
			if(s.charAt(i)==t.charAt(i)) return true;
			else return false;
		}
		
		
		
		return false;
	}
	/**
	 * da perfezionare
	 * @param s
	 * @param str
	 * @return
	 */
	public static boolean contains(String s, String str)
	{
		
		int j=0;
		boolean bool=false;

		for(int i=0; i<s.length();i++)
		{
			if(s.charAt(i)==s.charAt(j))
			{
				bool=true;
				j++;
				if(j==str.length())  return bool;
			}
			
			else 
				{
				   j=0;
				   bool=false;
				   return bool;
				   
				}
			
		}
		
		
		return bool;

			
	}

    
			
		
	
	
	
	
	public static boolean startsWith(String s, String prefix)
	{
		for(int i=0; i<prefix.length();i++)
		{
			if(prefix.charAt(i)==s.charAt(i))
			{
				return true;
			}
			
			else return false;
		}
		return false;
	
	}
	
	
	public static boolean endsWith(String s, String suffix)
	{
		int i=s.length()-suffix.length();
		int t=0;
		
		while(i<s.length())
		{
			if(s.charAt(i)==suffix.charAt(t)) return true;
			i++;
			t++;
		}
		
		return false;
				
	}
	
	public static String replace(String s, char oldChar, char newChar)
	{
		String nuova="";
		for(int i=0; i<s.length(); i++)
		{
			if(oldChar==s.charAt(i)) 
			{
				nuova+=newChar;
				
			}
			else nuova+= s.charAt(i);
		}
		
		return nuova;
	}
	
	public static  String replace(String s, String oldChar, String newChar)
	{
		String nuova="";
	
		int i=0;
		while(i<s.length())
		{
			if(oldChar.charAt(i)==s.charAt(i)) 
			{
				nuova+=newChar;
				
			}
			
			else nuova+= s.charAt(i);
		}
		return nuova;
	}
	
	public static String trim(String s)
	{
		String str="";
		for(int i=0; i<s.length();i++)
		{
			if(s.charAt(i)!=' ') 
			{
				str+=s.charAt(i);
			}
			
			
		}
		
		return str;


		
	}
	public static void main(String[] args)
	{
		
	
		
		System.out.println(StringUtils.contains("nicole","il"));
		System.out.println(StringUtils.toLowerCase("NICOLE"));
		System.out.println(StringUtils.replace("ciao","iao","IAO"));
		
		
		
		
	}
	
}
