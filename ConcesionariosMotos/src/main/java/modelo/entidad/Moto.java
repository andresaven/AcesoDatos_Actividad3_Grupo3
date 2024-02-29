package modelo.entidad;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "motocicletas")
public class Moto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String modelo;

    @ManyToOne
    @JoinColumn(name = "fabricante_id")
    private Fabricante fabricante;

    @ManyToMany
    @JoinTable(
        name = "concesionario_motocicleta",
        joinColumns = @JoinColumn(name = "motocicleta_id"),
        inverseJoinColumns = @JoinColumn(name = "concesionario_id")
    )
    private List<Concesionario> concesionarios;

    
	public Moto() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public Fabricante getFabricante() {
		return fabricante;
	}

	public void setFabricante(Fabricante fabricante) {
		this.fabricante = fabricante;
	}

	public List<Concesionario> getConcesionarios() {
		return concesionarios;
	}

	public void setConcesionarios(List<Concesionario> concesionarios) {
		this.concesionarios = concesionarios;
	}

	@Override
	public String toString() {
		return "Moto [id=" + id + ", modelo=" + modelo + ", fabricante=" + fabricante + ", concesionarios="
				+ concesionarios + "]";
	}
	
	

    
}
