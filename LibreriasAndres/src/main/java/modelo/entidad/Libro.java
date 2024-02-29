package modelo.entidad;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "libros")
public class Libro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    private String titulo;
    private float precio;
    
    @ManyToOne
    @JoinColumn(name = "editorial_id")
    // Indica una relación muchos a uno con la entidad Editorial. Cada libro pertenece a una editorial.
    private Editorial editorial;
    
    @ManyToOne
    @JoinColumn(name = "autor_id")
    // Indica una relación muchos a uno con la entidad Autor. Cada libro tiene un autor.
    private Autor autor;
    
    @ManyToMany(mappedBy = "libros")
    // Establece una relación muchos a muchos con la entidad Librería. Un libro puede estar en varias librerías y una librería puede tener varios libros.
    private List<Libreria> librerias;

    
    // Constructor
    public Libro(String titulo, float precio, Editorial editorial, Autor autor) {
		super();
		this.titulo = titulo;
		this.precio = precio;
		this.editorial = editorial;
		this.autor = autor;
	}
    
    public Libro() {
		super();
	}

	// Getters y setters
    
	public int getId() {
		return id;
	}


	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public float getPrecio() {
		return precio;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
	}

	public Editorial getEditorial() {
		return editorial;
	}

	public void setEditorial(Editorial editorial) {
		this.editorial = editorial;
	}

	public Autor getAutor() {
		return autor;
	}

	public void setAutor(Autor autor) {
		this.autor = autor;
	}

	public List<Libreria> getLibrerias() {
		return librerias;
	}
	
	
	public void setLibrerias(List<Libreria> librerias) {
		this.librerias = librerias;
	}

	
	// toString

	@Override
	public String toString() {
		return "Libro [id=" + id + ", titulo=" + titulo + ", precio=" + precio + ", editorial=" + editorial + ", autor="
				+ autor + ", librerias=" + librerias + "]";
	}
    
	// Método que añade librería a libro. 
	public void addLibreria(Libreria libreria) {
		 if (librerias == null) {
		        librerias = new ArrayList<>();
		    }
		    librerias.add(libreria);

		    if (libreria.getLibros() == null) {
		        libreria.setLibros(new ArrayList<>());
		    }
		    libreria.getLibros().add(this); 
	}
    
    
}
