package modelo.vista;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import modelo.entidad.Autor;
import modelo.entidad.Editorial;
import modelo.entidad.Libreria;
import modelo.entidad.Libro;

public class ProgramaPrincipal {

	public static void main(String[] args) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("PruebaJPA");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();

		try {
			// Carga de datos
			et.begin();

			Autor autor1 = new Autor("Gabriel", "García Márquez", LocalDate.of(1927, 3, 6), new ArrayList<>());
			Autor autor2 = new Autor("J.K.", "Rowling", LocalDate.of(1965, 7, 31), new ArrayList<>());
			Autor autor3 = new Autor("Haruki", "Murakami", LocalDate.of(1949, 1, 12), new ArrayList<>());
			em.persist(autor1);
			em.persist(autor2);
			em.persist(autor3);

			// Dar de alta 2 editoriales
			Editorial editorial1 = new Editorial("Salamandra", "Calle Almansa 13", new ArrayList<>());
			Editorial editorial2 = new Editorial("Alfaguara", "Avenida de los Puentes 4", new ArrayList<>());
			em.persist(editorial1);
			em.persist(editorial2);

			// Dar de alta 8 libros y asociarlos a las editoriales y autores
			List<Libro> libros = new ArrayList<>();
			libros.add(new Libro("Cien años de soledad", 20.5, editorial1, autor1, new ArrayList<>()));
			libros.add(new Libro("Harry Potter y la piedra filosofal", 18.99, editorial2, autor2, new ArrayList<>()));
			libros.add(new Libro("Tokio Blues", 15.75, editorial1, autor3, new ArrayList<>()));
			libros.add(new Libro("Crónica de una muerte anunciada", 22.0, editorial2, autor1, new ArrayList<>()));
			libros.add(new Libro("La chica del tren", 19.25, editorial1, autor2, new ArrayList<>()));
			libros.add(new Libro("Norwegian Wood", 16.99, editorial2, autor3, new ArrayList<>()));
			libros.add(new Libro("El amor en los tiempos del cólera", 21.5, editorial1, autor1, new ArrayList<>()));
			libros.add(new Libro("El señor de los anillos", 17.75, editorial2, autor2, new ArrayList<>()));

			// Persistir los libros y asociarlos a las editoriales y autores
			for (Libro libro : libros) {
				em.persist(libro);

				// Asociar el libro al autor
				libro.getAutor().getLibros().add(libro);

				// Asociar el libro a la editorial
				libro.getEditorial().getLibros().add(libro);
			}

			Libreria libreria1 = new Libreria("Librería El Quijote", "Juan Pérez", "Calle Real 89", new ArrayList<>());
			Libreria libreria2 = new Libreria("Librería Borges", "María Gómez", "Avenida de las Olas 1",
					new ArrayList<>());
			em.persist(libreria1);
			em.persist(libreria2);

			// Asociar los libros a las librerías
			for (int i = 0; i < libros.size(); i++) {
				Libro libro = libros.get(i);

				// Asociar cada libro a la primera librería
				libreria1.getLibros().add(libro);
				libro.getLibrerias().add(libreria1);

				// Asociar los primeros tres libros a la segunda librería
				if (i < 3) {
					libreria2.getLibros().add(libro);
					libro.getLibrerias().add(libreria2);
				}
			}

			et.commit();
			System.out.println("Datos cargados correctamente.");

		} catch (Exception e) {
			if (et.isActive()) {
				et.rollback();
			}
			e.printStackTrace();
		}

		
		
		System.out.println("============== CONSULTA 1 ==============");
		System.out.println("----------------------------------------");

		// Consulta 1: Mostrar todos los libros dados de alta, con su editorial y su
		// autor
		Query query1 = em.createQuery("SELECT l FROM Libro l");
		List<Libro> libros = query1.getResultList();
		for (Libro libro : libros) {
			System.out.println("Libro: " + libro.getTitulo());
			System.out.println("Editorial: " + libro.getEditorial().getNombre());
			System.out.println("Autor: " + libro.getAutor().getNombre() + " " + libro.getAutor().getApellidos());
			System.out.println("----------------------------------------");
		}

		System.out.println("============== CONSULTA 2 ==============");
		System.out.println("----------------------------------------");

		// Consulta 2: Mostrar todos los autores dados de alta, con sus libros asociados
		Query query2 = em.createQuery("SELECT a FROM Autor a");
		List<Autor> autores = query2.getResultList();
		for (Autor autor : autores) {
			System.out.println("Autor: " + autor.getNombre() + " " + autor.getApellidos());
			System.out.println("Libros asociados:");

			List<Libro> librosDelAutor = autor.getLibros();
			for (Libro libro : librosDelAutor) {
				System.out.println("- " + libro.getTitulo());
			}

			System.out.println("----------------------------------------");
		}

		System.out.println("============== CONSULTA 3 ==============");
		System.out.println("----------------------------------------");

		// Consulta 3: Mostrar todas las librerías, con solamente sus libros asociados
		Query query3 = em.createQuery("SELECT l FROM Libreria l");
		List<Libreria> librerias = query3.getResultList();
		for (Libreria libreria : librerias) {
			System.out.println("Librería: " + libreria.getNombre());
			System.out.println("Libros:");
			for (Libro libro : libreria.getLibros()) {
				System.out.println("- " + libro.getTitulo());
			}
			System.out.println("----------------------------------------");
		}

		System.out.println("============== CONSULTA 4 ==============");
		System.out.println("----------------------------------------");

		// Consulta 4: Mostrar todos los libros dados de alta, y en la librería en la
		// que están
		Query queryLibros = em.createQuery("SELECT DISTINCT l FROM Libro l JOIN FETCH l.librerias libreria");
		List<Libro> libros2 = queryLibros.getResultList();

		for (Libro libro : libros2) {
			System.out.println("Libro: " + libro.getTitulo());
			System.out.println("Editorial: " + libro.getEditorial().getNombre());
			System.out.println("Librerías:");

			for (Libreria libreria : libro.getLibrerias()) {
				System.out.println("- " + libreria.getNombre());
			}

			System.out.println("----------------------------------------");
		}

		System.out.println("Consultas realizadas correctamente.");
		em.close();
		emf.close();
	}
	
}