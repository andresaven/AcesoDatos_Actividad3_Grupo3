package modelo.entidad;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
//Especifica el nombre de la tabla para la entidad Historial
@Table(name="historiales")
public class Historial {
	@Id
	// El ID se genera automáticamente con cada nueva entrada
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	private Integer id;
	private String tratamiento, enfermedad;
	// Indica una relación uno a uno con Paciente
	@OneToOne
	// Establece la columna de unión para la relación (clave foránea)
	@JoinColumn(name = "fk_id_paciente", referencedColumnName = "id")
	private Paciente paciente;

	public Historial(Integer id, String tratamiento, String enfermedad, Paciente paciente) {
		super();
		this.id = id;
		this.tratamiento = tratamiento;
		this.enfermedad = enfermedad;
		this.paciente = paciente;
	}

	public Historial() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTratamiento() {
		return tratamiento;
	}

	public void setTratamiento(String tratamiento) {
		this.tratamiento = tratamiento;
	}

	public String getEnfermedad() {
		return enfermedad;
	}

	public void setEnfermedad(String enfermedad) {
		this.enfermedad = enfermedad;
	}

	public Paciente getPaciente() {
		return paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}

	@Override
	public String toString() {
		return "Historial [id=" + id + ", tratamiento=" + tratamiento + ", enfermedad=" + enfermedad + ", paciente="
				+ paciente + "]";
	}
	 
	 

}
