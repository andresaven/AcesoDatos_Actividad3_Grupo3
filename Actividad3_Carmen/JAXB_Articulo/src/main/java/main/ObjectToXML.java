package main;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import entidad.Articulo;

public class ObjectToXML {

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

		Marshaller m;
		try {
			m = contexto.createMarshaller();			
			m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			
			
			//Creamos 3 objetos articulo
			Articulo a1 = new Articulo(1,5, "boligrafos", "boligrafos bic de colores", 1.15);
			Articulo a2 = new Articulo(2,10, "papel", "papel folio A4 reciclado", 8.15);
			Articulo a3 = new Articulo(3,15, "cartulinas", "cartulinas A4 colores", 0.50);
			
			
			//Convertimos un objeto a xml y lo imprimimos por pantalla
			m.marshal(a1, System.out);
			m.marshal(a2, System.out);
			m.marshal(a3, System.out);
			
			
		}	catch (JAXBException e) {
			System.out.println("Error convirtiendo el objeto a formato XML");
			System.out.println(e.getMessage());
			e.printStackTrace();	
	}
}
}

	


