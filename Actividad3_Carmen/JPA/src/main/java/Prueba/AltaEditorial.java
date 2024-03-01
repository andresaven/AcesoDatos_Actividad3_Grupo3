package Prueba;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;

import modelo.entidad.Editorial;

public class AltaEditorial {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("ActividadJPA");			
		EntityManager em = emf.createEntityManager();
		
		
		//Creamos 3 instancias de Editorial		
		        
          Editorial edit1 = new Editorial(null,"Alfaguara", "Travessera de Gràcia 47-49",null);           
          Editorial edit2 = new Editorial(null,"Tusquets", "Avenida Diagonal 662-664",null);
          
          System.out.println("==============================================");
  		
          
       // Iniciamos la transacción
          em.getTransaction().begin();

       // Persistimos las editoriales en la base de datos
          em.persist(edit1);
          em.persist(edit2);

       // Finalizamos la transacción
          em.getTransaction().commit();

          em.close();
          }     	
	}


