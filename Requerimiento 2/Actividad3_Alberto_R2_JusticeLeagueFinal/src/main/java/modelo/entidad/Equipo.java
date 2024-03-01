package modelo.entidad;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
/**
 * La clase Equipo representa a un equipo de superhéroes. Cada equipo tiene un identificador único,
 * un nombre y puede tener varios superhéroes asociados.
 * 
 * <p>Esta clase se utiliza en el contexto de persistencia de datos, ya que está anotada con las
 * anotaciones de JPA para mapear la clase a una tabla en una base de datos relacional.</p>
 * 
 * <p>La relación entre la clase Equipo y Superheroe es de uno a muchos (One-to-Many), lo que significa
 * que un equipo puede tener varios superhéroes, pero cada superhéroe pertenece a un solo equipo.</p>
 * 
 * @author Alberto Arroyo Santofimia
 * @version 1.0
 */
@Entity
@Table(name = "equipos")
public class Equipo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nombre;

    @OneToMany(mappedBy = "equipo")
    private List<Superheroe> superheroes;

	public Equipo() {
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