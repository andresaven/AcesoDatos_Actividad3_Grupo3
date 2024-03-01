package modelo.actividad.altaBaseDatos;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import modelo.entidad.Autor;
import modelo.entidad.Editorial;
import modelo.entidad.Libro;

public class _03_AltaLibros {
	
	public static void main(String[] args) {
		
		EntityManagerFactory emf = 
				Persistence.createEntityManagerFactory("Actividad3JPA");
			
		EntityManager em = null;
		
		Libro libro1 = new Libro();
        libro1.setTitulo("It");
        libro1.setPrecio(19.99);
        
        Libro libro2 = new Libro();
        libro2.setTitulo("El resplandor");
        libro2.setPrecio(25.95);
        
        Libro libro3 = new Libro();
        libro3.setTitulo("Todo vuelve");
        libro3.setPrecio(29.99);
        
        Libro libro4 = new Libro();
        libro4.setTitulo("Todo arde");
        libro4.setPrecio(18.95);
        
        Libro libro5 = new Libro();
        libro5.setTitulo("Rey Blanco");
        libro5.setPrecio(11.87);
        
        Libro libro6 = new Libro();
        libro6.setTitulo("La armadura de la luz");
        libro6.setPrecio(23.65 );
        
        Libro libro7 = new Libro();
        libro7.setTitulo("La isla de las tormentas");
        libro7.setPrecio(25.55);
        
        Libro libro8 = new Libro();
        libro8.setTitulo("Los pilares de la tierra");
        libro8.setPrecio(29.99);
        
        
        em = emf.createEntityManager();
        em.getTransaction().begin();
        
        //Buscamos la editorial del libro en nuestra bbdd
        Editorial ed1 = new Editorial();
        Editorial ed2 = new Editorial();
        ed1 = em.find(Editorial.class, 1);
        ed2 = em.find(Editorial.class, 2);
        libro1.setEditorial(ed1);
        libro2.setEditorial(ed1);
        libro3.setEditorial(ed2);
        libro4.setEditorial(ed2);
        libro5.setEditorial(ed2);
        libro6.setEditorial(ed2);
        libro7.setEditorial(ed1);
        libro8.setEditorial(ed1);
        
        
        //Buscamos el autor del libro en la bbdd
        Autor aut1 = new Autor ();
        Autor aut2 = new Autor ();
        Autor aut3 = new Autor ();
        aut1 = em.find(Autor.class,1);
        libro1.setAutor(aut1);
        libro2.setAutor(aut1);
        aut2 = em.find(Autor.class,2);
        libro3.setAutor(aut2);
        libro4.setAutor(aut2);
        libro5.setAutor(aut2);
        aut3 = em.find(Autor.class,3);
        libro6.setAutor(aut3);
        libro7.setAutor(aut3);
        libro8.setAutor(aut3);
        
        em.persist(libro1);
        em.persist(libro2);
        em.persist(libro3);
        em.persist(libro4);
        em.persist(libro5);
        em.persist(libro6);
        em.persist(libro7);
        em.persist(libro8);
        
        List<Libro> librosPlaneta = new ArrayList<Libro>();
        librosPlaneta.add(libro1);
        librosPlaneta.add(libro2);
        librosPlaneta.add(libro7);
        librosPlaneta.add(libro8);
        
        List<Libro> librosEspasa = new ArrayList<Libro>();
        librosEspasa.add(libro3);
        librosEspasa.add(libro4);
        librosEspasa.add(libro5);
        librosEspasa.add(libro6);
        
        ed1.setColeccionLibrosEditorial(librosPlaneta);
        ed2.setColeccionLibrosEditorial(librosEspasa);
        
        em.persist(ed1);
        em.persist(ed2);


		em.getTransaction().commit(); 
		em.close();				

		//cerramos el entitymanager
		emf.close();	
	}

}
