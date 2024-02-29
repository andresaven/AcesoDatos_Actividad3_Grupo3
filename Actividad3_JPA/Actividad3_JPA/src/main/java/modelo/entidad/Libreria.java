package modelo.entidad;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "librerias")
public class Libreria {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String nombre;
	private String nombreDueno;
	private String direccion;

	@ManyToMany(cascade = { CascadeType.ALL })
	@JoinTable(name = "libreria_libro", joinColumns = @JoinColumn(name = "libreria_id"), inverseJoinColumns = @JoinColumn(name = "libro_id"))
	private List<Libro> libros;

	public Libreria() {
		super();
	}

	@Override
	public String toString() {
		return "Libreria [id=" + id + ", nombre=" + nombre + ", nombreDueno=" + nombreDueno + ", direccion=" + direccion
				+ ", libros=" + libros + "]";
	}

	public Libreria(String nombre, String nombreDueno, String direccion, List<Libro> libros) {
		super();
		this.nombre = nombre;
		this.nombreDueno = nombreDueno;
		this.direccion = direccion;
		this.libros = libros;
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

	public String getNombreDueno() {
		return nombreDueno;
	}

	public void setNombreDueno(String nombreDueno) {
		this.nombreDueno = nombreDueno;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public List<Libro> getLibros() {
		return libros;
	}

	public void setLibros(List<Libro> libros) {
		this.libros = libros;
	}

}