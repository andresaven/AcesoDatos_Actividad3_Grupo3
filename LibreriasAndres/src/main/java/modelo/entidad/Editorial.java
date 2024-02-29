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
    // Similar a la anterior, establece una relación uno a muchos con la entidad Libro, siendo Editorial la parte "uno" y Libro la parte "muchos".
    private List<Libro> coleccion;

    // Constructor
    
	public Editorial(String nombre, String direccion, List<Libro> libros) {
		super();
		this.nombre = nombre;
		this.direccion = direccion;
		this.coleccion = libros;
	}
	

	public Editorial() {
		super();
	}
    
    
    // Getters y setters
    
	public int getId() {
		return id;
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

	public List<Libro> getColeccion() {
		return coleccion;
	}

	public void setColeccion(List<Libro> coleccion) {
		this.coleccion = coleccion;
	}

    
	// toString
	
	@Override
	public String toString() {
		return "Editorial [id=" + id + ", nombre=" + nombre + ", direccion=" + direccion + ", libros=" + coleccion + "]";
	}

    
    
}

