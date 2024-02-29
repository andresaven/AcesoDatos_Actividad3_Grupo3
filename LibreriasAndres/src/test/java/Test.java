

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import modelo.entidad.Autor;
import modelo.entidad.Editorial;
import modelo.entidad.Libreria;
import modelo.entidad.Libro;
import modelo.persistencia.dao.impl.AutorDaoImplJPA;
import modelo.persistencia.dao.impl.EditorialDaoImplJPA;
import modelo.persistencia.dao.impl.LibreriaDaoImplJPA;
import modelo.persistencia.dao.impl.LibroDaoImplJPA;

public class Test {
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("LibreriaAndres");
		EntityManager em = emf.createEntityManager();
		
        AutorDaoImplJPA autorDao = new AutorDaoImplJPA(em);
        EditorialDaoImplJPA editorialDao = new EditorialDaoImplJPA(em);
        LibroDaoImplJPA libroDao = new LibroDaoImplJPA(em);
        LibreriaDaoImplJPA libreriaDao = new LibreriaDaoImplJPA(em);

        // Crear autores
        Autor cervantes = new Autor("Miguel de Cervantes", "Saavedra",autorDao.introducirFecha("29/09/1547"), null);
        Autor garciaMarquez = new Autor("Gabriel", "García Márquez", autorDao.introducirFecha("06/03/1927"), null);
        Autor lorca = new Autor("Federico", "García Lorca", autorDao.introducirFecha("05/06/1898"), null);


        // Crear editoriales
        Editorial catedra = new Editorial("Cátedra", "Calle Levante, 10, Madrid", null);
        Editorial alianza = new Editorial("Alianza", "Calle Poniente, 15, Barcelona", null);

        // Crear librerías
        Libreria andresAlbacete = new Libreria("Andrés Albacete", "Alfonsa Martínez", "San José de Calasanz, 10");
        Libreria andresMurcia = new Libreria("Andrés Murcia", "María Reyes", "Cigarral, 2");
        
        // Crear libros
        
        Libro quijote = new Libro("Don Quijote de la Mancha", 39.99f, catedra, cervantes);
        quijote.addLibreria(andresMurcia);
        quijote.addLibreria(andresAlbacete);
        Libro novelaEjemplares = new Libro("Novelas Ejemplares", 25.99f, catedra, cervantes);
        novelaEjemplares.addLibreria(andresMurcia);
        Libro galatea = new Libro("La Galatea", 35.99f, catedra, cervantes);
        galatea.addLibreria(andresMurcia);
        Libro cienAnos = new Libro("Cien años de soledad", 45.50f, alianza, garciaMarquez);
        cienAnos.addLibreria(andresMurcia);
        Libro amorTiempos = new Libro("El amor en los tiempos del cólera", 34.99f, alianza, garciaMarquez);
        amorTiempos.addLibreria(andresAlbacete);
        Libro romanceroGitano = new Libro("Romancero Gitano", 19.99f, catedra, lorca);
        romanceroGitano.addLibreria(andresAlbacete);
        Libro amorOscuro = new Libro("Sonetos del amor oscuro", 57.99f, catedra, lorca);
        amorOscuro.addLibreria(andresAlbacete);
        Libro bernardaAlba = new Libro("La casa de Bernarda Alba", 9.99f, catedra, lorca);
        bernardaAlba.addLibreria(andresAlbacete);

        //Arrays de colecciones de editoriales
        List<Libro> coleccionClasicosCatedra = new ArrayList<Libro>();
        coleccionClasicosCatedra.add(quijote);
        coleccionClasicosCatedra.add(novelaEjemplares);
        coleccionClasicosCatedra.add(galatea);
        coleccionClasicosCatedra.add(amorOscuro);
        coleccionClasicosCatedra.add(bernardaAlba);
        coleccionClasicosCatedra.add(romanceroGitano);
        catedra.setColeccion(coleccionClasicosCatedra);
       
        List<Libro> coleccionClasicosAlianza = new ArrayList<Libro>();
        coleccionClasicosAlianza.add(amorTiempos);
        coleccionClasicosAlianza.add(amorTiempos);
        alianza.setColeccion(coleccionClasicosAlianza);
        
        //Arrays de libros en librerías
        List<Libro> librosEnAlbacete = new ArrayList<Libro>();
        librosEnAlbacete.add(bernardaAlba);
        librosEnAlbacete.add(amorOscuro);
        librosEnAlbacete.add(cienAnos);
        librosEnAlbacete.add(galatea);
        librosEnAlbacete.add(amorTiempos);
        andresAlbacete.setLibros(librosEnAlbacete);
        
        List<Libro> librosEnMurcia = new ArrayList<Libro>();
        librosEnMurcia.add(bernardaAlba);
        librosEnMurcia.add(novelaEjemplares);
        librosEnMurcia.add(quijote);
        librosEnMurcia.add(romanceroGitano);
        librosEnMurcia.add(amorOscuro);
        andresMurcia.setLibros(librosEnMurcia);
        
        //Arrays libros de autores
        List<Libro> librosCervantes = new ArrayList<Libro>();
        librosCervantes.add(galatea);
        librosCervantes.add(novelaEjemplares);
        librosCervantes.add(quijote);
        cervantes.setLibros(librosCervantes);
        
        List<Libro> librosMarquez = new ArrayList<Libro>();
        librosMarquez.add(amorTiempos);
        librosMarquez.add(cienAnos);
        garciaMarquez.setLibros(librosMarquez);
        
        List<Libro> librosLorca = new ArrayList<Libro>();
        librosLorca.add(bernardaAlba);
        librosLorca.add(amorOscuro);
        librosLorca.add(romanceroGitano);
        lorca.setLibros(librosLorca);
        
        //Transacción para la persistencia
        em.getTransaction().begin();
        
        autorDao.crearAutor(cervantes);
        autorDao.crearAutor(garciaMarquez);
        autorDao.crearAutor(lorca);
        
        editorialDao.crearEditorial(catedra);
        editorialDao.crearEditorial(alianza);

        libreriaDao.crearLibreria(andresAlbacete);
        libreriaDao.crearLibreria(andresMurcia);
        
        libroDao.crearLibro(quijote);
        libroDao.crearLibro(amorOscuro);
        libroDao.crearLibro(amorTiempos);
        libroDao.crearLibro(bernardaAlba);
        libroDao.crearLibro(cienAnos);
        libroDao.crearLibro(galatea);
        libroDao.crearLibro(novelaEjemplares);
        libroDao.crearLibro(romanceroGitano);
        
        em.getTransaction().commit();
        
        
        // Queries
        
        // Mostrar todos los libros dados de alta, con su editorial y su autor
        em.getTransaction().begin();
        Query query1 = em.createQuery("SELECT l FROM Libro l");
        List<Libro> librosAutorEditorial= query1.getResultList();
        
        for(Libro libro : librosAutorEditorial) {
            System.out.println(libro.getTitulo() + " - " + libro.getAutor().getNombre() + " " 
            		+ libro.getAutor().getApellidos() + " - " + libro.getEditorial().getNombre());
        }
        
        // Mostrar todos los autores dados de alta, con sus libros asociados
        Query query2 = em.createQuery("SELECT a FROM Autor a");
        List<Autor> autoresLibros= query2.getResultList();
        
        for(Autor autor : autoresLibros) {
            System.out.println(autor.getNombre() + " " + autor.getApellidos() + ":");
            for(Libro libro : autor.getLibros()) {
                System.out.println(" - " + libro.getTitulo());
            }
        }
        
        // Mostrar todas las librerías, con solamente sus libros asociados
        Query query3 = em.createQuery("SELECT l FROM Libreria l");
        List<Libreria> libreriasLibros= query3.getResultList();
        
        for(Libreria libreria : libreriasLibros) {
            System.out.println(libreria.getNombre() + ":");
            for(Libro libro : libreria.getLibros()) {
                System.out.println(" - " + libro.getTitulo());
            }
        }
        
    
        // Mostrar todos los libros dados de alta, y en la librería en la que están.
        Query query4 = em.createQuery("SELECT DISTINCT l FROM Libro l LEFT JOIN FETCH l.librerias ");
        List<Libro> librosLibrerias= query4.getResultList();
        
        for(Libro libro : librosLibrerias) {
            System.out.println(libro.getTitulo() + " está en las siguientes librerías:");
            for(Libreria libreria : libro.getLibrerias()) {
                System.out.println(" - " + libreria.getNombre());
            }
        }
        
        em.getTransaction().commit();
        em.close();
    }
		
}

