package modelo.entidad;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "clientes")
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String nombre;

    @OneToOne(mappedBy = "cliente", cascade = CascadeType.ALL)
    private CarneConducir carneConducir;

    @ManyToMany(mappedBy = "clientes")
    private List<Concesionario> concesionarios;

    // Constructor
	public Cliente() {
		super();
	}

    // Getters y setters
	
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

	public CarneConducir getLicenciaConducir() {
		return carneConducir;
	}

	public void setLicenciaConducir(CarneConducir carneConducir) {
		this.carneConducir = carneConducir;
	}

	public List<Concesionario> getConcesionarios() {
		return concesionarios;
	}

	public void setConcesionarios(List<Concesionario> concesionarios) {
		this.concesionarios = concesionarios;
	}

	// toString
	
	@Override
	public String toString() {
		return "Cliente [id=" + id + ", nombre=" + nombre + ", licenciaConducir=" + carneConducir
				+ ", concesionarios=" + concesionarios + "]";
	}

   

}