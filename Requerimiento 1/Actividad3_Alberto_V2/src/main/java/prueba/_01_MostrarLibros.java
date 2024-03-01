package prueba;

import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;
import modelo.entidad.Libro;

public class _01_MostrarLibros {

	public static void main(String[] args) {
		
	 	EntityManagerFactory emf = Persistence.createEntityManagerFactory("Actividad3JPA");
        EntityManager em = emf.createEntityManager();

        // ... (código para dar de alta autores, editoriales y libros)

        // Mostrar todos los libros con su editorial y autor
        em.getTransaction().begin();
        
        
        //Mostrar todos los libros dados de alta, con su editorial y su autor
        
        Query query = em.createQuery("Select l from Libro l");
        List<Libro> libros = query.getResultList();

        for (Libro libro : libros) {
        	System.out.println("----libros dados de alta, con su editorial y su autor----");
            System.out.println("Libro: " + libro.getTitulo());
            System.out.println("Editorial: " + libro.getEditorial().getNombre());
            System.out.println("Autor: " + libro.getAutor().getNombre() + " " + libro.getAutor().getApellidos());
            System.out.println("---------------------------------------------------------");
        }

        //em.getTransaction().commit();

        em.close();
        emf.close();

	}

}
