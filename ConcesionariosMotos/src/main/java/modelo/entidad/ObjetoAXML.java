package modelo.entidad;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

public class ObjetoAXML {

	public static void main(String[] args) {
		JAXBContext contexto;
		
		try {
			contexto = JAXBContext.newInstance(Articulo.class);
			System.out.println("Contexto creado");
		} catch (JAXBException e) {
			System.out.println("No se pudo crear el contexto");
			e.printStackTrace();
			return;
		}
		
		Marshaller m;
		
		try {
			m = contexto.createMarshaller();
			m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			
			// Creamos 3 objetos de Artículo
			
			Articulo a1 = new Articulo(1, "Casco LS2", "Modelo touring", 10, 180.30);
			Articulo a2 = new Articulo(2, "Casco AGV", "Modelo Sport", 4, 283.60);
			Articulo a3 = new Articulo(3, "Casco MT", "Modelo Enduro", 2, 350.90);
			
			//Convertimos los objetos a XML y los sacamos por pantalla
			
			m.marshal(a1, System.out);
			m.marshal(a2, System.out);
			m.marshal(a3, System.out);
			
			System.out.println("Objetos convertidos con éxito");

		} catch (JAXBException e) {
			System.out.println("Error al convertir los objetos");
			e.printStackTrace();
		}

	}

}
