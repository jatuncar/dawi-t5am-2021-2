package app;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Usuario;

public class Demo04 {

	public static void main(String[] args) {
		// obtener la conexi�n -> seg�n unidad de persistencia -> DAOFactory fabrica =...
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("mysql");
		
		// Crea los DAO usando la fabrica
		EntityManager em = fabrica.createEntityManager();
		
		// -- proceso : obtener la informaci�n de un usuario
		Usuario u = em.find(Usuario.class, 30);  // devuelve el obj Usuario, seg�n la PK
		
		if (u == null) {
			System.out.println("C�digo NO existe");
		} else {
			System.out.println("Bienvenido : " + u.getNombre());
			System.out.println(u);
		}
		
		em.close();
		
	}
	
}
