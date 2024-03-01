package pruebas;

import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;
import modelo.entidad.Debilidad;
import modelo.entidad.Habilidad;
import modelo.entidad.IdentidadSecreta;
import modelo.entidad.Superheroe;


public class _01_Pruebas {
	
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("Actividad3JPA2");
	    EntityManager em = emf.createEntityManager();

	    // ... (código para dar de alta autores, editoriales y libros)

	    // Mostrar todos los libros con su editorial y autor
	    em.getTransaction().begin();

        Query query = em.createQuery("Select s from Superheroe s");
        List<Superheroe> superheroes = query.getResultList();

        for (Superheroe heroe : superheroes) {
            System.out.println("---- Superhéroe ----");
            System.out.println("Nombre: " + heroe.getNombre());
            System.out.println("Especie: " + heroe.getEspecie());
            System.out.println("Equipo: " + (heroe.getEquipo() != null ? heroe.getEquipo().getNombre() : "N/A"));

            // Mostrar habilidades
            System.out.println("Habilidades:");
            for (Habilidad habilidad : heroe.getHabilidades()) {
                System.out.println("- " + habilidad.getNombre());
            }

            // Mostrar debilidades
            System.out.println("Debilidades:");
            for (Debilidad debilidad : heroe.getDebilidades()) {
                System.out.println("- " + debilidad.getNombre());
            }

            // Mostrar identidad secreta
            IdentidadSecreta identidad = heroe.getIdentidadSecreta();
            if (identidad != null) {
                System.out.println("Identidad Secreta:");
                System.out.println("Nombre Real: " + identidad.getNombreReal());
                System.out.println("Dirección: " + identidad.getDireccion());
            }

            System.out.println("---------------------------------------------------------");
        }

        em.getTransaction().commit();

        em.close();
        emf.close();
	}

	
}
