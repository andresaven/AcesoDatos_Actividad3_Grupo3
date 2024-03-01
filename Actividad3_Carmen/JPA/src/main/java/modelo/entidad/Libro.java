package modelo.entidad;


import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table (name = "libros")
public class Libro {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String titulo;
	private float precio;
	
	//Establecemos la relación de muchos a uno con la entidad Autor 
	@ManyToOne 
    @JoinColumn(name = "autor_id")
	private Autor autor;
	
	
	//Establecemos la relación de muchos a uno con la entidad Editorial
	@ManyToOne 
    @JoinColumn(name = "editorial_id")
	private Editorial editorial;
	 @ManyToMany(mappedBy = "libros")
	    private List<Libreria> librerias;
	
	public Libro(Integer id, String titulo, float precio, Autor autor, Editorial editorial) {
		super();
		this.id = id;
		this.titulo = titulo;
		this.precio = precio;
		this.autor = autor;
		this.editorial = editorial;
	}

	public Libro() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public Autor getAutor() {
		return autor;
	}

	public void setAutor(Autor autor) {
		this.autor = autor;
	}

	public Editorial getEditorial() {
		return editorial;
	}

	public void setEditorial(Editorial editorial) {
		this.editorial = editorial;
	}
	public List<Libreria> getLibrerias() {
        return librerias;
    }

    public void setLibrerias(List<Libreria> librerias) {
        this.librerias = librerias;
    }

	@Override
	public String toString() {
		return "Libro [id=" + id + ", titulo=" + titulo + ", precio=" + precio + ", autor=" + autor + "]";
	}

	
}
