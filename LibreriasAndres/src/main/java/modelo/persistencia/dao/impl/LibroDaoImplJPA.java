package modelo.persistencia.dao.impl;

import modelo.entidad.Libro;
import modelo.persistencia.dao.LibroDao;
import javax.persistence.EntityManager;


import java.util.List;

public class LibroDaoImplJPA implements LibroDao {
    
    private EntityManager em;
    
    public LibroDaoImplJPA(EntityManager em) {
		super();
		this.em = em;
	}
    
    @Override
    public void crearLibro(Libro libro) {
        em.persist(libro);
    }
    
    @Override
    public Libro obtenerLibroPorId(int id) {
        return em.find(Libro.class, id);
    }
    
    @Override
    public List<Libro> obtenerTodosLibros() {
        return em.createQuery("SELECT l FROM Libro l", Libro.class).getResultList();
    }
    
    @Override
    public Libro actualizarLibro(Libro libro) {
        return em.merge(libro);
    }
    
    @Override
    public void eliminarLibroPorId(int id) {
        Libro libro = obtenerLibroPorId(id);
        if (libro != null) {
            em.remove(libro);
        }
    }
}