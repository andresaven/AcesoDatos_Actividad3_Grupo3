package modelo.entidad;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
/**
 * La clase Habilidad representa una habilidad que puede ser poseída por varios superhéroes.
 * Cada habilidad tiene un identificador único, un nombre y puede estar asociada a varios superhéroes.
 * 
 * <p>Esta clase se utiliza en el contexto de persistencia de datos, ya que está anotada con las
 * anotaciones de JPA para mapear la clase a una tabla en una base de datos relacional.</p>
 * 
 * <p>La relación entre la clase Habilidad y Superheroe es de muchos a muchos (Many-to-Many), lo que significa
 * que una habilidad puede estar asociada a varios superhéroes y viceversa.</p>
 * 
 * @author Alberto Arroyo Santofimia
 * @version 1.0
 */
@Entity
@Table(name = "habilidades")
public class Habilidad {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nombre;

    @ManyToMany(mappedBy = "habilidades")
    private List<Superheroe> superheroes;

	public Habilidad() {
		super();
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

	public List<Superheroe> getSuperheroes() {
		return superheroes;
	}

	public void setSuperheroes(List<Superheroe> superheroes) {
		this.superheroes = superheroes;
	}
 
    
}