package vista;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import entidad.Articulo;

public class Main {

	public static void main(String[] args) {

		JAXBContext contexto;
		try {
			
			contexto = JAXBContext.newInstance(Articulo.class);
			
		} catch (Exception e) {
			System.out.println("Error creando el contexto");
			System.out.println(e.getMessage());
			e.printStackTrace();
			return;
		}
	
		Marshaller m;
		try {
			
			m = contexto.createMarshaller();
			
			m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			
			//Creamos el objeto Articulo
			Articulo a1 = new Articulo(101, "Libro", "Historia de la Tierra", 20, 10.99);
			Articulo a2 = new Articulo(202, "Camiseta", "Camiseta de algodón", 50, 7.99);
			Articulo a3 = new Articulo(303, "Taza", "Taza de cerámica con diseño floral", 100, 5.99);

			m.marshal(a1, System.out);
			System.out.println("--------------");
			m.marshal(a2, System.out);
			System.out.println("--------------");
			m.marshal(a3, System.out);
			
			//Creamos un fichero ".xml"
			m.marshal(a1, new File("articulo1.xml"));
			m.marshal(a2, new File("articulo2.xml"));
			m.marshal(a3, new File("articulo3.xml"));
		} catch (JAXBException e) {
			System.out.println("Error convirtiendo el objeto a formato XML");
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	
	
	}

}
