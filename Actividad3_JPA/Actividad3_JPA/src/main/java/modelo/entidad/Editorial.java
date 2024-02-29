package modelo.entidad;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "editoriales")
public class Editorial {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String nombre;
	private String direccion;

	@OneToMany(mappedBy = "editorial", cascade = CascadeType.PERSIST)
	private List<Libro> coleccionLibros;

	public Editorial(String nombre, String direccion, List<Libro> coleccionLibros) {
		super();
		this.nombre = nombre;
		this.direccion = direccion;
		this.coleccionLibros = coleccionLibros;
	}

	@Override
	public String toString() {
		return "Editorial [id=" + id + ", nombre=" + nombre + ", direccion=" + direccion + ", libros=" + coleccionLibros
				+ "]";
	}

	public Editorial() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public List<Libro> getLibros() {
		return coleccionLibros;
	}

	public void setLibros(List<Libro> coleccionLibros) {
		this.coleccionLibros = coleccionLibros;
	}

}
