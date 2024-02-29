package modelo.persistencia.dao;

import modelo.entidad.Libro;

import java.util.List;

public interface LibroDao {
    void crearLibro(Libro libro);
    Libro obtenerLibroPorId(int id);
    List<Libro> obtenerTodosLibros();
    Libro actualizarLibro(Libro libro);
    void eliminarLibroPorId(int id);
}