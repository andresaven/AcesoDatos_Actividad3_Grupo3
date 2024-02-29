package modelo.persistencia.dao.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;


import modelo.entidad.Autor;
import modelo.persistencia.dao.AutorDao;

public class AutorDaoImplJPA implements AutorDao{
	
	private EntityManager em;
	

	public AutorDaoImplJPA(EntityManager em) {
		super();
		this.em = em;
	}

	@Override
	public void crearAutor(Autor autor) {
		em.persist(autor);
	}

	@Override
	public Autor obtenerAutorPorId(int id) {
		 return em.find(Autor.class, id);
	}

	@Override
	public List<Autor> obtenerTodosAutores() {
		 return em.createQuery("SELECT a FROM Autor a", Autor.class).getResultList();
	}

	@Override
	public Autor actualizarAutor(Autor autor) {
		 return em.merge(autor);
	}

	@Override
	public void eliminarAutorPorId(int id) {
        Autor autor = obtenerAutorPorId(id);
        if (autor != null) {
            em.remove(autor);
        } 
	}

	@Override
	public Date introducirFecha(String fecha) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Date fechaNacimiento;
		try {
			fechaNacimiento = sdf.parse(fecha);
			return fechaNacimiento;
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
		
	}

}
