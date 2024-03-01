package Prueba;

import java.util.List;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;
import modelo.entidad.Autor;
import modelo.entidad.Libreria;
import modelo.entidad.Libro;

public class Consultas {
    
    public static EntityManagerFactory emf = null;
    public static EntityManager em = null;
    
    public static void main(String[] args) {
        emf = Persistence.createEntityManagerFactory("ActividadJPA");    
        
        em = emf.createEntityManager();
        
        // Libros dados de alta con su editorial y autor.
        Query query = em.createQuery("SELECT l FROM Libro l JOIN FETCH l.autor JOIN FETCH l.editorial");
        List<Libro> libros = query.getResultList();
        for (Libro l : libros) {
            System.out.println("Libro: " + l.getTitulo());
            System.out.println("Autor: " + l.getAutor().getNombre());
            System.out.println("Editorial: " + l.getEditorial().getNombre());
            System.out.println("===================================");
        }
        
        // Autores y sus libros asociados
        Query query1 = em.createQuery("SELECT a FROM Autor a JOIN FETCH a.libros");
        List<Autor> autores = query1.getResultList();
        for (Autor autor : autores) {
            System.out.println("Autor: " + autor.getNombre() + " " + autor.getApellidos());
            for (Libro libro : autor.getLibros()) {
                System.out.println(" - Libro: " + libro.getTitulo());
            }
            System.out.println("===================================");
        }
        
        // Librerías y sus libros asociados
        Query query2 = em.createQuery("SELECT l FROM Libreria l JOIN FETCH l.libros");
        List<Libreria> librerias = query2.getResultList();
        for (Libreria libreria : librerias) {
            System.out.println("Librería: " + libreria.getNombre());
            for (Libro libro : libreria.getLibros()) {
                System.out.println("Libro: " + libro.getTitulo());
            }
            System.out.println("===================================");
        }
        
        //Libros dados de alta y libreria asociada     
        Query query3  = em.createQuery("SELECT l FROM Libro l JOIN FETCH l.librerias");
        List<Libro> librosEnLibreria = query3.getResultList();
        for (Libro libro : librosEnLibreria) {
            System.out.println("Libro: " + libro.getTitulo());
            for (Libreria libreria : libro.getLibrerias()) {
                System.out.println(" Librería: " + libreria.getNombre());
            }
            System.out.println("===================================");
        }
        
        em.close();
        emf.close();
    }
}

