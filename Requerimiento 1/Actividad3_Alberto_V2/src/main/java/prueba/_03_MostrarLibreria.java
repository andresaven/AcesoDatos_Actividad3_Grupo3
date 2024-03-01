package prueba;

import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;
import modelo.entidad.Libreria;
import modelo.entidad.Libro;

public class _03_MostrarLibreria {

	public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("Actividad3JPA");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();
              
        //Mostrar todas las librerías, con solamente sus libros asociados
        
        Query query = em.createQuery("SELECT l FROM Libreria l");
        List<Libreria> librerias = query.getResultList();
        System.out.println("--------------------");
        for (Libreria libreria : librerias) {
            System.out.println("Librería: " + libreria.getNombre());
            System.out.println("Libros:");
            
            for (Libro libro : libreria.getLibros()) {
                System.out.println("  - " + libro.getTitulo());
            }

            System.out.println("--------------------");
        }

        em.close();
        emf.close();

	}

}


