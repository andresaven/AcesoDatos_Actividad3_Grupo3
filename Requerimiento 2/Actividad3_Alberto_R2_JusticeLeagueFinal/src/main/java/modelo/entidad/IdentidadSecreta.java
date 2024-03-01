package modelo.entidad;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
/**
 * La clase IdentidadSecreta representa la identidad secreta de un superhéroe, incluyendo su nombre real y dirección.
 * Cada identidad secreta tiene un identificador único y está asociada a un único superhéroe.
 * 
 * <p>Esta clase se utiliza en el contexto de persistencia de datos, ya que está anotada con las
 * anotaciones de JPA para mapear la clase a una tabla en una base de datos relacional.</p>
 * 
 * <p>La relación entre la clase IdentidadSecreta y Superheroe es de uno a uno (One-to-One), ya que cada identidad
 * secreta está vinculada a un único superhéroe.</p>
 * 
 * @author Alberto Arroyo Santofimia
 * @version 1.0
 * 
 */
@Entity
@Table(name = "identidades_secretas")
public class IdentidadSecreta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nombreReal;
    private String direccion;

    @OneToOne
    @JoinColumn(name = "superheroe_id")
    private Superheroe superheroe;

	public IdentidadSecreta() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombreReal() {
		return nombreReal;
	}

	public void setNombreReal(String nombreReal) {
		this.nombreReal = nombreReal;
	}

	public Superheroe getSuperheroe() {
		return superheroe;
	}

	public void setSuperheroe(Superheroe superheroe) {
		this.superheroe = superheroe;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

    
}