package modelo.entidad;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
//Indica que esta clase es una entidad JPA que se va a mapear a una tabla en la base de datos.
@Table(name = "autores")
public class Autor {
		@Id
		// Especifica la propiedad que actúa como identificador único de la entidad.
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		// Configura cómo se genera el valor del identificador. IDENTITY significa que el valor se genera automáticamente por la base de datos.
		private int id;
		 
		private String nombre;
		private String apellidos;
		 
		@Temporal(TemporalType.DATE)
		// Especifica que el campo fechaNacimiento se va a almacenar como una fecha (sin hora) en la base de datos.
		private Date fechaNacimiento;
		 
		@OneToMany(mappedBy = "autor", cascade = CascadeType.PERSIST)
		// Establece una relación uno a muchos con la entidad Libro. "mappedBy" indica el campo de la entidad Libro que posee la relación.
		private List<Libro> libros;

	 
		// Constructor
		
		public Autor(String nombre, String apellidos, Date fechaNacimiento, List<Libro> libros) {
			super();
			this.nombre = nombre;
			this.apellidos = apellidos;
			this.fechaNacimiento = fechaNacimiento;
			this.libros = libros;
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


		public String getApellidos() {
			return apellidos;
		}


		public void setApellidos(String apellidos) {
			this.apellidos = apellidos;
		}


		public Date getFechaNacimiento() {
			return fechaNacimiento;
		}


		public void setFechaNacimiento(Date fechaNacimiento) {
			this.fechaNacimiento = fechaNacimiento;
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
			return "Autor [id=" + id + ", nombre=" + nombre + ", apellidos=" + apellidos + ", fechaNacimiento="
					+ fechaNacimiento + ", libros=" + libros + "]";
		}
		
		
}
