package modelo.main;

import java.io.File;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import modelo.entidad.Articulo;

public class ObjetoAXML {
	
	public static void main(String[] args) {
		
		JAXBContext contexto;
		
		try {
			contexto = JAXBContext.newInstance(Articulo.class);
		} catch (JAXBException e) {
			System.out.println("Error creando el contexto");
			System.out.println(e.getMessage());
			e.printStackTrace();
			return;
		}
		//objeto capaz de serializar
		Marshaller m;
		try {
			m = contexto.createMarshaller();
			//darle formato de salida más adecuado para leer
			m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			
			//Creamos el objeto Persona y su Direccion
			Articulo articulo1 = new Articulo(1, "Fallout", "Videojuego Ps4", 4, 9.0);
			Articulo articulo2 = new Articulo(2, "Marvel Spiderman 2", "Videojuego Ps5", 100, 59.95);
			Articulo articulo3 = new Articulo(3, "Starfield", "Videojuego Xbox", 77, 50);

			
			//Convertimos un objeto a xml y lo imprimimos por pantalla
			m.marshal(articulo1, System.out);
			m.marshal(articulo2, System.out);
			m.marshal(articulo3, System.out);
			
			//crear un fichero ".xml"
			
			m.marshal(articulo1, new File("articulo1.xml"));
			m.marshal(articulo2, new File("articulo2.xml"));
			m.marshal(articulo3, new File("articulo3.xml"));

			
			
		} catch (JAXBException e) {
			System.out.println("Error convirtiendo el objeto a formato XML");
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}

}
