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
    
    @ManyToMany (cascade = CascadeType.PERSIST)
    // Establece una relación muchos a muchos con la entidad Libro.
    @JoinTable(
        // Define una tabla de unión para la relación muchos a muchos, especificando los nombres de las columnas de unión.
        name = "libreria_libro", // Nombre de la tabla de unión.
        joinColumns = @JoinColumn(name = "libreria_id"), // Columna que une a Libreria con la tabla de unión.
        inverseJoinColumns = @JoinColumn(name = "libro_id") // Columna que une a Libro con la tabla de unión.
    )
    private List<Libro> libros;

    
    // Constructor
    
    public Libreria(String nombre, String nombreDueno, String direccion) {
		super();
		this.nombre = nombre;
		this.nombreDueno = nombreDueno;
		this.direccion = direccion;
	}
    
    public Libreria() {
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
	
	// toString

	@Override
	public String toString() {
		return "Libreria [id=" + id + ", nombre=" + nombre + ", nombreDueno=" + nombreDueno + ", direccion=" + direccion
				+ ", libros=" + libros + "]";
	}
    
    
}