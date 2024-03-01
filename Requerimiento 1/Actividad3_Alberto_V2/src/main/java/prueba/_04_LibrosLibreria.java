package prueba;

import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;
import modelo.entidad.Libreria;
import modelo.entidad.Libro;

public class _04_LibrosLibreria {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("Actividad3JPA");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();
              
        //Mostrar todos los libros dados de alta, y en la librería en la que están.
        
        Query query = em.createQuery("SELECT l FROM Libro l LEFT JOIN FETCH l.librerias");
        List<Libro> libros = query.getResultList();
        System.out.println("--------------------");
        for (Libro libro : libros) {
            System.out.println("Libro: " + libro.getTitulo());
            System.out.println("Librerías:");
            
            for (Libreria libreria : libro.getLibrerias()) {
                System.out.println("  - " + libreria.getNombre());
            }

            System.out.println("--------------------");
        }

        em.close();
        emf.close();

	}

}
