package Prueba;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;

import modelo.entidad.Autor;
import modelo.entidad.Editorial;
import modelo.entidad.Libro;

public class AltaLibros {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("ActividadJPA");			
		EntityManager em = emf.createEntityManager();
		

		// Buscamos los autores y editoriales por sus IDs
        Autor a1 = em.find(Autor.class, 1); 
        Autor a2 = em.find(Autor.class, 2); 
        Autor a3 = em.find(Autor.class, 3); 
        Editorial edit1 = em.find(Editorial.class, 1); 
        Editorial edit2 = em.find(Editorial.class, 2);
              
        
		// Damos de alta una lista con 8 instancias de Libro, con sus respectivos autores y editoriales
		List<Libro> listaLibros =new ArrayList<Libro>();
		
		listaLibros.add(new Libro(null, "Soldados de Salamina", 20.0f, a1, edit2));
		listaLibros.add(new Libro(null, "Anatomia de un Instante", 21.90f, a1, edit2));
		listaLibros.add(new Libro(null, "Las Leyes de la Frontera", 20.0f, a1, edit2));
		listaLibros.add(new Libro(null, "Ordesa", 15.50f, a2, edit1));
		listaLibros.add(new Libro(null, "Los Inmortales", 17.0f, a2, edit1));
		listaLibros.add(new Libro(null, "La Reina del Sur", 19.90f, a3, edit1));
		listaLibros.add(new Libro(null, "La Tabla de Flandes", 22.0f, a3, edit1));
		listaLibros.add(new Libro(null, "La sombra del Aguila", 22.0f, a3, edit1));
        
		System.out.println("==============================================");
		 
		  
        // Iniciamos la transacción
        em.getTransaction().begin();

        // Persistimos los libros en la base de datos utilizando un bucle for
        for (Libro libro : listaLibros) {
            em.persist(libro);
        }

        // Finalizamos la transacción
        em.getTransaction().commit();
   
        em.close();
           
  	}

}
