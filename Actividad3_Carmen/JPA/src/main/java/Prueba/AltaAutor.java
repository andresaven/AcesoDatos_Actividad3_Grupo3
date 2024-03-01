package Prueba;


import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;
import modelo.entidad.Autor;
import modelo.entidad.Libro;

public class AltaAutor {

	public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("ActividadJPA");			
		EntityManager em = emf.createEntityManager();
		
		//Importamos la clase SimpleDateFormat para parsear y formatear las fechas de nacimiento
		//genera excepciones try/catch
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");    
		
		try {
        // Parseamos las fechas 
        Date fechaNacA1 = sdf.parse("1962-03-04");
        Date fechaNacA2 = sdf.parse("1962-10-19");
        Date fechaNacA3 = sdf.parse("1951-11-25");        

        // Crear instancias de Autor con las fechas ya parseadas
        Autor a1 = new Autor(null,"Javier", "Cercas", fechaNacA1);
        Autor a2 = new Autor(null,"Manuel", "Vilas", fechaNacA2);
        Autor a3 = new Autor(null,"Arturo", "Pérez-Reverte", fechaNacA3);
        
        System.out.println("==============================================");
		
        
     // Iniciamos la transacción
        em.getTransaction().begin();
        
     // Persistimos los autores en la base de datos
        em.persist(a1);
        em.persist(a2);
        em.persist(a3);
		
        // Finalizamos la transacción
        em.getTransaction().commit();     
        Query query = em.createQuery("SELECT a  FROM Autor a ");
        List<Autor> autores = query.getResultList();
        
              
		} catch (Exception e) {
            e.printStackTrace();   
		}finally {
            em.close();
            
		}
        }
    }


