package pruebas;

import java.util.Date;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import modelo.entidad.Cita;
import modelo.entidad.Historial;
import modelo.entidad.Medico;
import modelo.entidad.Paciente;

public class AltaTablas {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPAHospital");
        EntityManager em = emf.createEntityManager();

        try {
            em.getTransaction().begin();

            // Crear y persistir médicos
            Medico medico1 = new Medico(null, "Dr. Alonso", "Diagnóstico", null, null);
            Medico medico2 = new Medico(null, "Dr. Sanchez", "Cirugía", null, null);
            Medico medico3 = new Medico(null, "Dra. Álvarez", "Medicina General", null, null);
            em.persist(medico1);
            em.persist(medico2);
            em.persist(medico3);

            // Crear y persistir pacientes
            Paciente paciente1 = new Paciente(null, "12345678A", "Laura", "Lopez", "600600600", null, null, null);
            Paciente paciente2 = new Paciente(null, "87654321B", "Jorge", "Rodriguez", "555-5678", null, null, null);
            Paciente paciente3 = new Paciente(null, "45678912C", "Carmen", "Mendez", "555-9101", null, null, null);
            em.persist(paciente1);
            em.persist(paciente2);
            em.persist(paciente3);

            // Crear y persistir citas
            Cita cita1 = new Cita(null, new Date(), paciente1, medico1);
            Cita cita2 = new Cita(null, new Date(), paciente2, medico2);
            Cita cita3 = new Cita(null, new Date(), paciente3, medico3);
            em.persist(cita1);
            em.persist(cita2);
            em.persist(cita3);

            // Crear y persistir historiales
            Historial historial1 = new Historial(null, "Tratamiento 1", "Enfermedad 1", paciente1);
            Historial historial2 = new Historial(null, "Tratamiento 2", "Enfermedad 2", paciente2);
            Historial historial3 = new Historial(null, "Tratamiento 3", "Enfermedad 3", paciente3);
            em.persist(historial1);
            em.persist(historial2);
            em.persist(historial3);

            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            //em.getTransaction().rollback();
        } finally {
            em.close();
            emf.close();
        }
	}

}
