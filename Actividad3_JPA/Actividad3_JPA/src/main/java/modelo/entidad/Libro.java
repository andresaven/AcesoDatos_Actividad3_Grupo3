package modelo.entidad;

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
	private double precio;

	@ManyToOne
	@JoinColumn(name = "editorial_id")
	private Editorial editorial;

	@ManyToOne
	@JoinColumn(name = "autor_id")
	private Autor autor;

	@ManyToMany(mappedBy = "libros")
	private List<Libreria> librerias;

	public Libro() {
		super();
	}

	public Libro(String titulo, double precio, Editorial editorial, Autor autor, List<Libreria> librerias) {
		this.titulo = titulo;
		this.precio = precio;
		this.editorial = editorial;
		this.autor = autor;
		this.librerias = librerias;
	}

	@Override
	public String toString() {
		return "Libro [id=" + id + ", titulo=" + titulo + ", precio=" + precio + ", editorial=" + editorial + ", autor="
				+ autor + ", librerias=" + librerias + "]";
	}

	public List<Libreria> getLibrerias() {
		return librerias;
	}

	public void setLibrerias(List<Libreria> librerias) {
		this.librerias = librerias;
	}

	public int getId() {
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

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
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

}
