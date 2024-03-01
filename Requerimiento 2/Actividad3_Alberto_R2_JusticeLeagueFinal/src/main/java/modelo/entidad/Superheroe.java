package modelo.entidad;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
/**
 * La clase Superheroe representa a un personaje con habilidades especiales. Cada superhéroe tiene un identificador único,
 * un nombre, una especie, una identidad secreta, un equipo al que pertenece y puede tener habilidades y debilidades.
 * 
 * <p>Esta clase se utiliza en el contexto de persistencia de datos, ya que está anotada con las
 * anotaciones de JPA para mapear la clase a una tabla en una base de datos relacional.</p>
 * 
 * <p>Las relaciones de esta clase incluyen:
 * <ul>
 *   <li>One-to-One con IdentidadSecreta: Cada superhéroe tiene una única identidad secreta.</li>
 *   <li>Many-to-One con Equipo: Cada superhéroe pertenece a un único equipo.</li>
 *   <li>Many-to-Many con Habilidad: Cada superhéroe puede tener varias habilidades.</li>
 *   <li>Many-to-Many con Debilidad: Cada superhéroe puede tener varias debilidades.</li>
 * </ul>
 * </p>
 * 
 * @author Alberto Arroyo Santofimia
 * @version 1.0
 */
@Entity
@Table(name = "superheroes")
public class Superheroe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nombre;
    private String especie;

    @OneToOne(mappedBy = "superheroe")
    private IdentidadSecreta identidadSecreta;

    @ManyToOne
    @JoinColumn(name = "equipo_id")
    private Equipo equipo;

    @ManyToMany
    @JoinTable(
        name = "superheroe_habilidad",
        joinColumns = @JoinColumn(name = "superheroe_id"),
        inverseJoinColumns = @JoinColumn(name = "habilidad_id"))
    private List<Habilidad> habilidades;
    
    @ManyToMany
    @JoinTable(
        name = "superheroe_debilidad",
        joinColumns = @JoinColumn(name = "superheroe_id"),
        inverseJoinColumns = @JoinColumn(name = "debilidad_id"))
    private List<Debilidad> debilidades;
    

	public Superheroe() {
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


	public IdentidadSecreta getIdentidadSecreta() {
		return identidadSecreta;
	}

	public void setIdentidadSecreta(IdentidadSecreta identidadSecreta) {
		this.identidadSecreta = identidadSecreta;
	}

	public Equipo getEquipo() {
		return equipo;
	}

	public void setEquipo(Equipo equipo) {
		this.equipo = equipo;
	}

	public List<Habilidad> getHabilidades() {
		return habilidades;
	}

	public void setHabilidades(List<Habilidad> habilidades) {
		this.habilidades = habilidades;
	}

	public String getEspecie() {
		return especie;
	}

	public void setEspecie(String especie) {
		this.especie = especie;
	}

	public List<Debilidad> getDebilidades() {
		return debilidades;
	}

	public void setDebilidades(List<Debilidad> debilidades) {
		this.debilidades = debilidades;
	}
	


}
