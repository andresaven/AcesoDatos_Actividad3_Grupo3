package modelo.entidad;


import java.io.Serializable;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

// Indicamos cuál es el nodo raíz
@XmlRootElement(name="articulo")

// Mapeamos la clase para que al serializar se identifiquen correctamente todos los elementos
@XmlType(propOrder = {
		"id",
		"nombre",
		"descripcion",
		"stock",
		"precio"
		})

public class Articulo implements Serializable{
    
	private static final long serialVersionUID = 1L;
	
	private int id;
    private String nombre;
    private String descripcion;
    private int stock;
    private double precio;


    public Articulo(int id, String nombre, String descripcion, int stock, double precio) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.stock = stock;
        this.precio = precio;
    }
   
    public Articulo() {
		super();
	}



	// Getters y Setters
    
    //Serializamos como atributo en XML el id
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
    
    //Sustituimos el nombre por "cantidad"
    @XmlElement(name= "cantidad")
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

    // Método toString modificado para representar el artículo como una cadena de texto
    @Override
    public String toString() {
        return "Artículo con " +
                "ID: " + id +
                ", nombre: '" + nombre + '\'' +
                ", descripción: '" + descripcion + '\'' +
                ", stock: " + stock +
                ", precio: " + precio +
                '€';
    }
}

