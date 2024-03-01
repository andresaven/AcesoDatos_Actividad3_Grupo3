package modelo.entidad;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;


//Indica que esta clase es una entidad que se mapeará a una tabla en la base de datos
@Entity
//Nombre de la tabla de la entidad paciente
@Table(name="pacientes")
public class Paciente {
	
	@Id
	// ID autoincremental para cada paciente
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	private Integer id;
	private String dni;
	private String nombre, apellidos;
	private String telefono;
	
	// Establece una relación uno a muchos con citas; 'mappedBy' indica el campo en la entidad 'Cita' que posee la relación
	@OneToMany(mappedBy="paciente")
	private List<Cita> citas;
	// Establece una relación uno a uno con Historial; CascadeType.ALL propaga todas las operaciones (como persistir, eliminar) al hijo
	@OneToOne(mappedBy = "paciente", cascade = CascadeType.ALL)    
    private Historial historial;
	// Configura una relación muchos a muchos con Médico; 'mappedBy' refiere al campo en 'Medico' que mantiene la relación
	@ManyToMany(mappedBy="pacientes", cascade=CascadeType.PERSIST) 
	private List<Medico> medicos;	

	
	public Paciente(Integer id, String dni, String nombre, String apellidos, String telefono, List<Cita> citas,
			Historial historial, List<Medico> medicos) {
		super();
		this.id = id;
		this.dni = dni;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.telefono = telefono;
		this.citas = citas;
		this.historial = historial;
		this.medicos = medicos;
	}

	public Paciente() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public List<Cita> getCitas() {
		return citas;
	}

	public void setCitas(List<Cita> citas) {
		this.citas = citas;
	}

	public Historial getHistorial() {
		return historial;
	}

	public void setHistorial(Historial historial) {
		this.historial = historial;
	}
	public List<Medico> getMedicos() {
		return medicos;
	}

	public void setMedicos(List<Medico> medicos) {
		this.medicos = medicos;
	}

	@Override
	public String toString() {
		return "Paciente [id=" + id + ", dni=" + dni + ", nombre=" + nombre + ", apellidos=" + apellidos + ", telefono="
				+ telefono + ", citas=" + citas + ", historial=" + historial + "]";
	}

	
	
	
	

}
