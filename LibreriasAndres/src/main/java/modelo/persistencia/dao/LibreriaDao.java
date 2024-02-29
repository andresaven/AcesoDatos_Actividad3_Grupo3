package modelo.persistencia.dao;

import modelo.entidad.Libreria;

import java.util.List;

public interface LibreriaDao {
    void crearLibreria(Libreria libreria);
    Libreria obtenerLibreriaPorId(int id);
    List<Libreria> obtenerTodasLibrerias();
    Libreria actualizarLibreria(Libreria libreria);
    void eliminarLibreriaPorId(int id);
}