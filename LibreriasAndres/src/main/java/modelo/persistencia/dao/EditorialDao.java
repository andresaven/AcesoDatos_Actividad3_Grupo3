package modelo.persistencia.dao;

import modelo.entidad.Editorial;

import java.util.List;

public interface EditorialDao {
    void crearEditorial(Editorial editorial);
    Editorial obtenerEditorialPorId(int id);
    List<Editorial> obtenerTodasEditoriales();
    Editorial actualizarEditorial(Editorial editorial);
    void eliminarEditorialPorId(int id);
}