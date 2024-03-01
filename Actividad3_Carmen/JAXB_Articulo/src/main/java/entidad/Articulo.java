package entidad;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

//Establecemos el nombre del nodo raíz en XML
@XmlRootElement(name="articulo")

//Establecemos el orden en que queremos que salgan los nodos elemento
@XmlType(propOrder = {
		"id",
	    "nombre",
	    "descripcion",
	    "uds",
	    "precio"
	})
public class Articulo{	
	
	//Definimos los atributos de la clase	
	private int id, uds;
	private String nombre, descripcion;
	private double precio;
	
	//Constructor de la clase con los atributos
	public Articulo(int id, int uds, String nombre, String descripcion, double precio) {
		super();
		this.id = id;
		this.uds = uds;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.precio = precio;
	}
	public Articulo() {
		super();
	}
	
	//Serializamos como atributo en XML el id del artículo
	@XmlAttribute(name = "id")
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	//Cambiamos el nombre en el que queremos que aparezca el nodo elemnto al serializar 
	@XmlElement(name="unidades")
	public int getUds() {
		return uds;
	}
	public void setUds(int uds) {
		this.uds = uds;
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
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	
	//Generamos método toString
	@Override
	public String toString() {
		return "Articulo [id=" + id + ", uds=" + uds + ", nombre=" + nombre + ", descripcion=" + descripcion
				+ ", precio=" + precio + "]";
	}
	
	
	

}
