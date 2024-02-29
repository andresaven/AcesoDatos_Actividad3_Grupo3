package modelo.vista;

import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import modelo.entidad.Departamento;
import modelo.entidad.DetallesPersonales;
import modelo.entidad.Empleado;
import modelo.entidad.Proyecto;

public class ProgramaPrincipal {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("EmpresaJPA");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();

		try {
			// Carga de datos
			et.begin();

			Departamento departamento1 = new Departamento();
			departamento1.setNombreDep("Departamento de Software");

			Departamento departamento2 = new Departamento();
			departamento2.setNombreDep("Departamento de RRHH");

			Empleado empleado1 = new Empleado();
			empleado1.setNombre("Juan Perez");
			empleado1.setDepartamento(departamento1);
			empleado1.setProyectos(new ArrayList<>());

			Empleado empleado2 = new Empleado();
			empleado2.setNombre("Maria Garcia");
			empleado2.setDepartamento(departamento1);
			empleado2.setProyectos(new ArrayList<>());

			Empleado empleado3 = new Empleado();
			empleado3.setNombre("Pedro Lopez");
			empleado3.setDepartamento(departamento2);
			empleado3.setProyectos(new ArrayList<>());

			DetallesPersonales detalles1 = new DetallesPersonales();
			detalles1.setDireccion("Calle Larga 13");
			detalles1.setTelefono("333333333");
			detalles1.setEmpleado(empleado1);

			DetallesPersonales detalles2 = new DetallesPersonales();
			detalles2.setDireccion("Avenida Laguna 4");
			detalles2.setTelefono("444444444");
			detalles2.setEmpleado(empleado2);

			DetallesPersonales detalles3 = new DetallesPersonales();
			detalles3.setDireccion("Plaza Mayor 7");
			detalles3.setTelefono("555555555");
			detalles3.setEmpleado(empleado3);

			Proyecto proyecto1 = new Proyecto();
			proyecto1.setNombreProyecto("Proyecto A");

			Proyecto proyecto2 = new Proyecto();
			proyecto2.setNombreProyecto("Proyecto B");

			Proyecto proyecto3 = new Proyecto();
			proyecto3.setNombreProyecto("Proyecto C");

			empleado1.setDetallesPersonales(detalles1);
			empleado1.getProyectos().add(proyecto1);
			empleado1.getProyectos().add(proyecto2);

			empleado2.setDetallesPersonales(detalles2);
			empleado2.getProyectos().add(proyecto1);

			empleado3.setDetallesPersonales(detalles3);
			empleado3.getProyectos().add(proyecto3);

			em.persist(departamento1);
			em.persist(departamento2);
			em.persist(empleado1);
			em.persist(empleado2);
			em.persist(empleado3);
			em.persist(proyecto1);
			em.persist(proyecto2);
			em.persist(proyecto3);

			em.getTransaction().commit();
			System.out.println("Datos cargados correctamente.");

		} catch (Exception e) {
			if (et.isActive()) {
				et.rollback();
			}
			e.printStackTrace();
		}
		em.close();
		emf.close();
	}
}
