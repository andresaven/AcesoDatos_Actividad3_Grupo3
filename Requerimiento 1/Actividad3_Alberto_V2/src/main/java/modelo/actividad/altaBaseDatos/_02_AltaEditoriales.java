package modelo.actividad.altaBaseDatos;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import modelo.entidad.Editorial;

public class _02_AltaEditoriales {
	
	public static void main(String[] args) {
		
		EntityManagerFactory emf = 
				Persistence.createEntityManagerFactory("Actividad3JPA");
			
		EntityManager em = null;
		
		Editorial editorial1 = new Editorial();
		editorial1.setNombre("Planeta");
		editorial1.setDireccion("Avenida Diagonal 662 Barcelona");


		Editorial editorial2 = new Editorial();
		editorial2.setNombre("Espasa");
		editorial2.setDireccion("Josefa Valcárcel, 42 Madrid");
		
		em = emf.createEntityManager();
		em.getTransaction().begin();

		em.persist(editorial1);
		em.persist(editorial2);

		em.getTransaction().commit();
		em.close();

		emf.close();
	}

}
