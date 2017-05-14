package tony.com.DaoImpl;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Entidad {
private static  Entidad enti=null;
private static  EntityManagerFactory emf = Persistence.createEntityManagerFactory("PersonalPU");
	private Entidad() {

}
	public static Entidad getEntidad(){
		if(enti!=null){
			return enti;
		}
		enti=new Entidad();
		return enti;
	}
	public EntityManager getEntidadManager(){
	
		return emf.createEntityManager();
	}

}
