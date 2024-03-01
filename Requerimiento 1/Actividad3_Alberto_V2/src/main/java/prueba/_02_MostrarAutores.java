package prueba;

import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;
import modelo.entidad.Autor;
import modelo.entidad.Libro;

public class _02_MostrarAutores {
	
public static void main(String[] args) {
		
	 	EntityManagerFactory emf = Persistence.createEntityManagerFactory("Actividad3JPA");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();
              
        //Mostrar todos los autores dados de alta, con sus libros asociados
        
        Query query = em.createQuery("SELECT a FROM Autor a");
        List<Autor> autores = query.getResultList();

        for (Autor autor : autores) {
        	System.out.println("----autor dado de alta, con sus libros asociados----");
            System.out.println("Autor: " + autor.getNombre() + " " + autor.getApellidos());
            System.out.println("Libros:");
            
            for (Libro libro : autor.getLibros()) {
                System.out.println("  - " + libro.getTitulo());
            }
            System.out.println("--------------------");
        }
        //em.getTransaction().commit();

        em.close();
        emf.close();

	}

}
