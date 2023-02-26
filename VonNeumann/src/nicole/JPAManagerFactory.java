package nicole;

import javax.persistence.EntityManagerFactory;

public class JPAManagerFactory 
{
	private static  JPAManagerFactory istanza;
	
	private JPAManagerFactory() {
		
	}
	
	public static JPAManagerFactory createJPAEntity(String s)
	{
		if(istanza== null) istanza = new JPAManagerFactory();
		return  istanza;
		
	}

}
