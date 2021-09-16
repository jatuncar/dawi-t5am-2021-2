package app;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Usuario;

public class Demo05 {

	public static void main(String[] args) {
		// obtener la conexión -> según unidad de persistencia -> DAOFactory fabrica =...
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("mysql");
		
		// Crea los DAO usando la fabrica
		EntityManager em = fabrica.createEntityManager();
		
		// -- proceso : obtener la información de un usuario
		Usuario u = em.find(Usuario.class, 10);  // devuelve el obj Usuario, según la PK
		
		if (u == null) {
			System.out.println("Código NO existe");
		} else {
			System.out.println("Eliminando el Usuario !!");
			em.getTransaction().begin();
			em.remove(u);  // para eliminar (borrar de la tabla) / cambiar un estado
			em.getTransaction().commit();
			System.out.println("Eliminación Ok");
		}
		
		em.close();
		
	}
	
	
}
