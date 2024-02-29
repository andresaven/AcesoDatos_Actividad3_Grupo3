package modelo.persistencia.dao.impl;

import modelo.entidad.Editorial;
import modelo.persistencia.dao.EditorialDao;
import javax.persistence.EntityManager;


import java.util.List;

public class EditorialDaoImplJPA implements EditorialDao {
    
    private EntityManager em;
    
    public EditorialDaoImplJPA(EntityManager em) {
		super();
		this.em = em;
	}
    
    @Override
    public void crearEditorial(Editorial editorial) {
        em.persist(editorial);
    }
    
    @Override
    public Editorial obtenerEditorialPorId(int id) {
        return em.find(Editorial.class, id);
    }
    
    @Override
    public List<Editorial> obtenerTodasEditoriales() {
        return em.createQuery("SELECT e FROM Editorial e", Editorial.class).getResultList();
    }
    
    @Override
    public Editorial actualizarEditorial(Editorial editorial) {
        return em.merge(editorial);
    }
    
    @Override
    public void eliminarEditorialPorId(int id) {
        Editorial editorial = obtenerEditorialPorId(id);
        if (editorial != null) {
            em.remove(editorial);
        }
    }
}