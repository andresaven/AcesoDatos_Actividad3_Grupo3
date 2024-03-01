package modelo.entidad;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table (name = "editoriales")
public class Editorial {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nombre, direccion;
	
	
	 @OneToMany(mappedBy = "editorial", cascade = CascadeType.PERSIST)
	    private List<Libro> coleccionLibros;


	public Editorial(Integer id, String nombre, String direccion, List<Libro> coleccionLibros) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.direccion = direccion;
		this.coleccionLibros = coleccionLibros;
	}


	public Editorial() {
		super();
	}


	public Integer getId() {
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


	public void setLibros(List<Libro> libros) {
		this.coleccionLibros = libros;
	}


	@Override
	public String toString() {
		return "Editorial [id=" + id + ", nombre=" + nombre + ", direccion=" + direccion + ", coleccionLibros =" + coleccionLibros + "]";
	}

	 
	 
}
