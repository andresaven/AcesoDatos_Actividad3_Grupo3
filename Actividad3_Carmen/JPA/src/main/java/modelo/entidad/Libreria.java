package modelo.entidad;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import jakarta.persistence.JoinColumn;



@Entity
@Table (name = "librerias")
public class Libreria {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nombre, dueño, direccion;
	
	//Relacion de muchos a muchos, tabla renacida
		 @ManyToMany 
		    @JoinTable(name = "libreria_libro", 
		        joinColumns = {@JoinColumn(name = "fk_id_libreria", referencedColumnName="id")}, 
		        inverseJoinColumns = {@JoinColumn(name = "fk_id_libro", referencedColumnName="id")}) 
		 private List<Libro> libros;	    
		    
	public Libreria(Integer id, String nombre, String dueño, String direccion, List<Libro> libros) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.dueño = dueño;
		this.direccion = direccion;
		this.libros = libros;
	}

		public Libreria() {
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

		public String getDueño() {
			return dueño;
		}

		public void setDueño(String dueño) {
			this.dueño = dueño;
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
		@Override
		public String toString() {
			return "Libreria [id=" + id + ", nombre=" + nombre + ", dueño=" + dueño + ", direccion=" + direccion + "]";
		}
	
	
	    
	    
}
