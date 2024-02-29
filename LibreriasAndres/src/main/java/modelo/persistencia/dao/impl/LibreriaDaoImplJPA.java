package modelo.persistencia.dao.impl;

import modelo.entidad.Libreria;
import modelo.persistencia.dao.LibreriaDao;
import javax.persistence.EntityManager;


import java.util.List;

public class LibreriaDaoImplJPA implements LibreriaDao {
    
    private EntityManager em;
    
    public LibreriaDaoImplJPA(EntityManager em) {
		super();
		this.em = em;
	}
    
    @Override
    public void crearLibreria(Libreria libreria) {
        em.persist(libreria);
    }
    
    @Override
    public Libreria obtenerLibreriaPorId(int id) {
        return em.find(Libreria.class, id);
    }
    
    @Override
    public List<Libreria> obtenerTodasLibrerias() {
        return em.createQuery("SELECT l FROM Libreria l", Libreria.class).getResultList();
    }
    
    @Override
    public Libreria actualizarLibreria(Libreria libreria) {
        return em.merge(libreria);
    }
    
    @Override
    public void eliminarLibreriaPorId(int id) {
        Libreria libreria = obtenerLibreriaPorId(id);
        if (libreria != null) {
            em.remove(libreria);
        }
    }
}