package nicole;

import javax.persistence.EntityManagerFactory;

public class JPAManagerFactory 
{
	private static  EntityManagerFactory istanza;
	
	private JPAManagerFactory() {
		
	}
	
	public static EntityManagerFactory getJPAEntity()
	{
		if(istanza== null) istanza=new EntityManagerFactory();
		return  istanza;
		
	}

}
