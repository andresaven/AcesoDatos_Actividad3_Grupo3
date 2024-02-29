package modelo.entidad;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "carnes_conducir")
public class CarneConducir {
    @Id
    private String numeroCarne;

    @OneToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

    private Date fechaExpiracion;

    // Constructor
    
	public CarneConducir() {
		super();
	}

    
    // Getters y setters
	
	public String getNumeroLicencia() {
		return numeroCarne;
	}

	public void setNumeroLicencia(String numeroLicencia) {
		this.numeroCarne = numeroLicencia;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Date getFechaExpiracion() {
		return fechaExpiracion;
	}

	public void setFechaExpiracion(Date fechaExpiracion) {
		this.fechaExpiracion = fechaExpiracion;
	}


	@Override
	public String toString() {
		return "CarneConducir [numeroLicencia=" + numeroCarne + ", cliente=" + cliente + ", fechaExpiracion="
				+ fechaExpiracion + "]";
	}
	
	

}