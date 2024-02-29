package modelo.persistencia.dao;

import java.util.Date;
import java.util.List;

import modelo.entidad.Autor;

public interface AutorDao {
	void crearAutor(Autor autor);
    Autor obtenerAutorPorId(int id);
    List<Autor> obtenerTodosAutores();
    Autor actualizarAutor(Autor autor);
    void eliminarAutorPorId(int id);
    Date introducirFecha(String fecha);
}
