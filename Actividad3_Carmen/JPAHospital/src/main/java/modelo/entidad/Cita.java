package modelo.entidad;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
//Nombre de la tabla de la entidad Cita
@Table(name="citas")
public class Cita {
	
	@Id
	// ID autoincremental para cada cita asignada
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	// Especifica que solo la fecha es importante en el atributo fecha (sin tiempo/hora)
	@Temporal(TemporalType.DATE)
	private Date fecha;	
	// Indica una relación muchos a uno con Paciente (muchas citas pueden estar asociadas a un paciente)
	@ManyToOne
	@JoinColumn(name="fk_id_paciente", referencedColumnName="id")
    private Paciente paciente;
	// Relación muchos a uno con Médico (muchas citas pueden estar asociadas a un médico)
	@ManyToOne
	@JoinColumn(name="fk_id_medico", referencedColumnName="id")
	private Medico medico;

	
	public Cita(Integer id, Date fecha, Paciente paciente, Medico medico) {
		super();
		this.id = id;
		this.fecha = fecha;
		this.paciente = paciente;
		this.medico = medico;
	}


	public Cita() {
		super();
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public Date getFecha() {
		return fecha;
	}


	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}


	public Paciente getPaciente() {
		return paciente;
	}


	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}


	public Medico getMedico() {
		return medico;
	}


	public void setMedico(Medico medico) {
		this.medico = medico;
	}


	@Override
	public String toString() {
		return "Cita [id=" + id + ", fecha=" + fecha + ", paciente=" + paciente + ", medico=" + medico + "]";
	}
	
	
}
