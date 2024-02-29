package modelo.entidad;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "concesionarios")
public class Concesionario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String nombre;

    private String direccion; 
    
    @ManyToMany
    @JoinTable(
        name = "concesionario_cliente",
        joinColumns = @JoinColumn(name = "concesionario_id"),
        inverseJoinColumns = @JoinColumn(name = "cliente_id")
    )
    private List<Cliente> clientes;

    @ManyToMany(mappedBy = "concesionarios")
    private List<Moto> motocicletas;

	public Concesionario() {
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

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public List<Cliente> getClientes() {
		return clientes;
	}

	public void setClientes(List<Cliente> clientes) {
		this.clientes = clientes;
	}

	public List<Moto> getMotocicletas() {
		return motocicletas;
	}

	public void setMotocicletas(List<Moto> motocicletas) {
		this.motocicletas = motocicletas;
	}

	@Override
	public String toString() {
		return "Concesionario [id=" + id + ", nombre=" + nombre + ", clientes=" + clientes + ", motocicletas="
				+ motocicletas + "]";
	}

    
    
}
