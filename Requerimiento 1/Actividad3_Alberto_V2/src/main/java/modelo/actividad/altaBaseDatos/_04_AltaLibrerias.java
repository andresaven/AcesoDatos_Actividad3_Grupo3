package modelo.actividad.altaBaseDatos;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import modelo.entidad.Libreria;
import modelo.entidad.Libro;

public class _04_AltaLibrerias {
	
	public static void main(String[] args) {
		
		EntityManagerFactory emf = 
				Persistence.createEntityManagerFactory("Actividad3JPA");
			
		EntityManager em = null;
		
		em = emf.createEntityManager();
	    em.getTransaction().begin();
	    
		Libro libro1 = em.find(Libro.class, 1);
		Libro libro2 = em.find(Libro.class, 2);
		Libro libro3 = em.find(Libro.class, 3);
		Libro libro4 = em.find(Libro.class, 4);
		Libro libro5 = em.find(Libro.class, 5);
		Libro libro6 = em.find(Libro.class, 6);
		Libro libro7 = em.find(Libro.class, 7);
		Libro libro8 = em.find(Libro.class, 8);
		
		 // Crear librerías
        Libreria libreria1 = new Libreria();
        libreria1.setNombre("Libreria A");
        libreria1.setNombreDueno("Dueño A");
        libreria1.setDireccion("Dirección A");
        List<Libro> librosLibreria1 = new ArrayList<>();
        librosLibreria1.add(libro1);
        librosLibreria1.add(libro2);
        librosLibreria1.add(libro3);
        librosLibreria1.add(libro4);
        libreria1.setLibros(librosLibreria1);

        Libreria libreria2 = new Libreria();
        libreria2.setNombre("Libreria B");
        libreria2.setNombreDueno("Dueño B");
        libreria2.setDireccion("Dirección B");
        List<Libro> librosLibreria2 = new ArrayList<>();
        librosLibreria2.add(libro1); // Puedes asociar los mismos libros a ambas librerías
        librosLibreria2.add(libro2);
        librosLibreria2.add(libro7);
        librosLibreria2.add(libro8);
        libreria2.setLibros(librosLibreria2);

        // Persistir librerías
        em.persist(libreria1);
        em.persist(libreria2);
        
        em.getTransaction().commit(); 
        
		em.close();	
		
		emf.close();	

	}
	
}
