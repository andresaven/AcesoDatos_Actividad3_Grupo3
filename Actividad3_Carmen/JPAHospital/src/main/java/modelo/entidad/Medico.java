package modelo.entidad;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.JoinColumn;

@Entity
//Nombre de la tabla de la entidad medico
@Table(name = "medicos")
public class Medico {
	
	@Id
	// ID autoincremental para cada médico
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nombre, especialidad;
	
	// Relación uno a muchos con Cita, un médico puede tener muchas citas
	 @OneToMany(mappedBy = "medico")
	 private List<Cita> citas;
	// Relación muchos a muchos con Paciente
	 @ManyToMany(cascade=CascadeType.PERSIST)
	// Define la tabla renacida de la relación medico-paciente N:M
	 @JoinTable(name="MedicoEnPaciente",
			   joinColumns= { @JoinColumn(name="fk_id_medico", referencedColumnName="id") }, 
			   inverseJoinColumns= { @JoinColumn(name="fk_id_paciente", referencedColumnName="id")})
	private List<Paciente> pacientes;
	 
	public Medico(Integer id, String nombre, String especialidad, List<Cita> citas, List<Paciente> pacientes) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.especialidad = especialidad;
		this.citas = citas;
		this.pacientes = pacientes;
	}
	public Medico() {
		super();
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getEspecialidad() {
		return especialidad;
	}
	public void setEspecialidad(String especialidad) {
		this.especialidad = especialidad;
	}
	public List<Cita> getCitas() {
		return citas;
	}
	public void setCitas(List<Cita> citas) {
		this.citas = citas;
	}
	public List<Paciente> getPacientes() {
		return pacientes;
	}
	public void setPacientes(List<Paciente> pacientes) {
		this.pacientes = pacientes;
	}
	@Override
	public String toString() {
		return "Medico [id=" + id + ", nombre=" + nombre + ", especialidad=" + especialidad + ", citas=" + citas
				+ ", pacientes=" + pacientes + "]";
	}
	 
	 

}
