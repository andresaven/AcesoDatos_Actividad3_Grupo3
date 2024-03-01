package datos;

import java.util.ArrayList;
import java.util.List;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import modelo.entidad.Debilidad;
import modelo.entidad.Equipo;
import modelo.entidad.Habilidad;
import modelo.entidad.IdentidadSecreta;
import modelo.entidad.Superheroe;

public class _01_AltaDatos {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Actividad3JPA2");

        EntityManager em = null;


            em = emf.createEntityManager();
            em.getTransaction().begin();

            // Héroes
            Superheroe heroe1 = new Superheroe();
            heroe1.setNombre("Superman");
            heroe1.setEspecie("Kryptoniano");

            Superheroe heroe2 = new Superheroe();
            heroe2.setNombre("Detective Marciano");
            heroe2.setEspecie("Marciano");

            Superheroe heroe3 = new Superheroe();
            heroe3.setNombre("Linterna Verde");
            heroe3.setEspecie("Humano");

            em.persist(heroe1);
            em.persist(heroe2);
            em.persist(heroe3);

            em.getTransaction().commit();

            // Debilidades
            em.getTransaction().begin();

            Debilidad debilidad1 = new Debilidad();
            debilidad1.setNombre("Kryptonita");

            Debilidad debilidad2 = new Debilidad();
            debilidad2.setNombre("Fuego");

            Debilidad debilidad3 = new Debilidad();
            debilidad3.setNombre("Color amarillo");

            em.persist(debilidad1);
            em.persist(debilidad2);
            em.persist(debilidad3);

            em.getTransaction().commit();

            // Habilidades
            em.getTransaction().begin();

            Habilidad habilidad1 = new Habilidad();
            habilidad1.setNombre("Fuerza");

            Habilidad habilidad2 = new Habilidad();
            habilidad2.setNombre("Control mental");

            Habilidad habilidad3 = new Habilidad();
            habilidad3.setNombre("Proyectar construcciones sólidas de luz");

            Habilidad habilidad4 = new Habilidad();
            habilidad4.setNombre("Volar");

            em.persist(habilidad1);
            em.persist(habilidad2);
            em.persist(habilidad3);
            em.persist(habilidad4);

            em.getTransaction().commit();

            // Equipos
            em.getTransaction().begin();

            Equipo equipo1 = new Equipo();
            equipo1.setNombre("Liga de la justicia");

            Equipo equipo2 = new Equipo();
            equipo2.setNombre("Teen Titans");

            em.persist(equipo1);
            em.persist(equipo2);

            em.getTransaction().commit();

            // Identidades
            em.getTransaction().begin();

            IdentidadSecreta identidad1 = new IdentidadSecreta();
            identidad1.setNombreReal("Clark Kent ");
            identidad1.setDireccion("Metropolis");

            IdentidadSecreta identidad2 = new IdentidadSecreta();
            identidad2.setNombreReal("J'onn J'onzz");
            identidad2.setDireccion("Middleton");

            IdentidadSecreta identidad3 = new IdentidadSecreta();
            identidad3.setNombreReal("Hal Jordan");
            identidad3.setDireccion("Coast City");
            
            identidad1.setSuperheroe(heroe1);
            identidad2.setSuperheroe(heroe2);
            identidad3.setSuperheroe(heroe3);
            
            /*
            heroe1.setIdentidadSecreta(identidad1);
            heroe2.setIdentidadSecreta(identidad2);
            heroe3.setIdentidadSecreta(identidad3);
            */
            

            em.persist(identidad1);
            em.persist(identidad2);
            em.persist(identidad3);
            
           

            em.getTransaction().commit();

            // Asignar habilidades a superhéroes
            em.getTransaction().begin();

            List<Habilidad> listaHabilidades1 = new ArrayList<>();
            listaHabilidades1.add(habilidad1);
            listaHabilidades1.add(habilidad4);
            heroe1.setHabilidades(listaHabilidades1);

            List<Habilidad> listaHabilidades2 = new ArrayList<>();
            listaHabilidades2.add(habilidad2);
            listaHabilidades2.add(habilidad4);
            heroe2.setHabilidades(listaHabilidades2);

            List<Habilidad> listaHabilidades3 = new ArrayList<>();
            listaHabilidades3.add(habilidad3);
            listaHabilidades3.add(habilidad4);
            heroe3.setHabilidades(listaHabilidades3);

            em.persist(heroe1);
            em.persist(heroe2);
            em.persist(heroe3);

            em.getTransaction().commit();

            // Asignar debilidades a superhéroes
            em.getTransaction().begin();

            List<Debilidad> listaDebilidades1 = new ArrayList<>();
            listaDebilidades1.add(debilidad1);
            heroe1.setDebilidades(listaDebilidades1);

            List<Debilidad> listaDebilidades2 = new ArrayList<>();
            listaDebilidades2.add(debilidad2);
            heroe2.setDebilidades(listaDebilidades2);

            List<Debilidad> listaDebilidades3 = new ArrayList<>();
            listaDebilidades3.add(debilidad3);
            heroe3.setDebilidades(listaDebilidades3);
            
            //Asignar equipo
            heroe1.setEquipo(equipo1);
            heroe2.setEquipo(equipo1);
            heroe3.setEquipo(equipo1);

            em.persist(heroe1);
            em.persist(heroe2);
            em.persist(heroe3);

            em.getTransaction().commit();
            
            em.close();
            emf.close();
        } 
}

