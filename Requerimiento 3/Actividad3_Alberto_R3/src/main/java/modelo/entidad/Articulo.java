package modelo.entidad;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * La clase Articulo representa un artículo con información como id, nombre, descripción, stock y precio.
 *
 * @author Alberto Arroyo Santofimia
 * 
 * @version v2.0
 */

@XmlRootElement(name="articulo")

@XmlType(propOrder = {
		"id",
	    "nombre",
	    "descripcion",
	    "stock",
	    "precio"
	})
public class Articulo implements Serializable {
   
	//Atributos privados
	private int id;
    private String nombre;
    private String descripcion;
    private int stock;
    private double precio;

    //constructor por defecto
    
    public Articulo() {
		super();
	}
    
    


	 public Articulo(int id, String nombre, String descripcion, int stock, double precio) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.stock = stock;
		this.precio = precio;
	}

	//getter y setters
	 
	@XmlAttribute(name = "id")
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

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}
	
	//toString
    
    @Override
    public String toString() {
        return "Articulo [id=" + id + ", nombre=" + nombre + ", descripcion=" + descripcion
                + ", stock=" + stock + ", precio=" + precio + "]";
    }
}