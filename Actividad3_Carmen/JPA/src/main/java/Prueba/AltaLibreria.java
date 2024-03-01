package Prueba;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;
import modelo.entidad.Libreria;
import modelo.entidad.Libro;

public class AltaLibreria {

	public static void main(String[] args) {
		 EntityManagerFactory emf = Persistence.createEntityManagerFactory("ActividadJPA");
	     EntityManager em = emf.createEntityManager();
	        
	        
	        //Primero buscamos los libros por sus identificadores y los guardamos en una nueva variable
	             
	        Libro lib1 = em.find(Libro.class, 1);
	        Libro lib2 = em.find(Libro.class, 2);
	        Libro lib3 = em.find(Libro.class, 3);
	        Libro lib4 = em.find(Libro.class, 4);
	        Libro lib5 = em.find(Libro.class, 5);
	        Libro lib6 = em.find(Libro.class, 6);
	        Libro lib7 = em.find(Libro.class, 7);
	        Libro lib8 = em.find(Libro.class, 8);

	        //Creamos dos librerías, cada una de ellas tendrá 4 libros.
	        //Lista de libros de la primera librería
	        
	        List<Libro> lista1 = new ArrayList<>();
	        lista1.add(lib1);
	        lista1.add(lib3);
	        lista1.add(lib5);
	        lista1.add(lib7);
	        
	        //Lista de libros de la segunda librería.
	        
	        List<Libro>lista2 =new ArrayList<>();
	        lista2.add(lib2);
	        lista2.add(lib4);
	        lista2.add(lib6);
	        lista2.add(lib8);
	        
	        
	       //Instanciamos dos objetos de la clase Librería, que tendrán como atributos el identificador único asignado automáticamente por la 
	       // base de datos, un nombre de libreria y nombre de dueño , además cada libreria tendrá su lista correspondiente de libros
	        //al ser una relación N:M surge una tabla renacida (libreria_libro)
	        
	        Libreria libreria1 = new Libreria(null, "Balmes", "Marcos Salvador", "Calle Progreso", lista1);
	        Libreria libreria2 = new Libreria (null, "Cosmos", "Ruth García", "Plaza Campo Castillo", lista2);        

	        
	        System.out.println("==============================================");
	  		  em = emf.createEntityManager();
	        
	     // Iniciamos la transacción
	        em.getTransaction().begin();

	        // Persistimos las librerías en la base de datos
	        em.persist(libreria1);
	        em.persist(libreria2);

	        // Finalizamos la transacción
	        em.getTransaction().commit();

	        em.close();
	       // emf.close();
	    }

}
