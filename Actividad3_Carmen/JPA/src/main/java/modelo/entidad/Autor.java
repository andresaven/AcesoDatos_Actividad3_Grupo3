package modelo.entidad;

import java.util.Date;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;




@Entity
@Table (name = "autores")
public class Autor {
	
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nombre, apellidos;
	@Temporal(TemporalType.DATE)
	private Date fNac;
	
	//Relacion uno a muchos de la entidad autor con la entidad libro
	@OneToMany(mappedBy = "autor", cascade = CascadeType.ALL) 
    private List<Libro> libros;
	
	public Autor(Integer id, String nombre, String apellidos, Date fNac) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.fNac = fNac;
	}



	public Autor() {
		super();
	}



	public Integer getId() {
		return id;
	}



	public void setId(Integer id) {
		this.id = id;
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



	public Date getfNac() {
		return fNac;
	}



	public void setfNac(Date fNac) {
		this.fNac = fNac;
	}

	public List<Libro> getLibros() {
		return libros;
	}

	public void setLibros(List<Libro> Libros) {
		this.libros = libros;
	}

	@Override
	public String toString() {
		return "Autor [id=" + id + ", nombre=" + nombre + ", apellidos=" + apellidos + ", fNac=" + fNac + "]";
	}
	
	
	
	

}
