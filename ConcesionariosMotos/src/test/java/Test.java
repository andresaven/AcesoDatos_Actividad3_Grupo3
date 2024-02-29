import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import modelo.entidad.Cliente;
import modelo.entidad.Concesionario;
import modelo.entidad.Fabricante;
import modelo.entidad.Moto;

import java.util.List;

public class Test {
    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ConcesionariosMotos");
        EntityManager em = emf.createEntityManager();

        try {
            em.getTransaction().begin();

            // Consulta para verificar clientes y sus licencias de conducir
            Query queryClientes = em.createQuery("SELECT c FROM Cliente c JOIN FETCH c.licenciaConducir", Cliente.class);
            List<Cliente> clientes = queryClientes.getResultList();
            System.out.println("Clientes y sus licencias de conducir:");
            for (int i = 0; i < clientes.size(); i++) {
                Cliente cliente = clientes.get(i);
                System.out.println(cliente.getNombre() + " - Licencia: " + cliente.getLicenciaConducir().getNumeroLicencia());
            }

            // Consulta para verificar motocicletas, fabricantes y concesionarios
            Query queryMotocicletas = em.createQuery("SELECT m FROM motocicletas m JOIN FETCH m.fabricante JOIN FETCH m.concesionarios", Moto.class);
            List<Moto> motocicletas = queryMotocicletas.getResultList();
            System.out.println("Motocicletas, fabricantes y concesionarios:");
            for (int i = 0; i < motocicletas.size(); i++) {
                Moto motocicleta = motocicletas.get(i);
                System.out.println(motocicleta.getModelo() + " - Fabricante: " + motocicleta.getFabricante().getNombre());
                Query stockQuery = em.createQuery("SELECT COUNT(c) FROM Concesionario c JOIN c.motocicletas m WHERE m.id = :motocicleta_id");
                stockQuery.setParameter("motocicleta_id", motocicleta.getId());
                int stock = (int) stockQuery.getSingleResult();
                System.out.println("   Stock total: " + stock);
                List<Concesionario> concesionarios = motocicleta.getConcesionarios();
                System.out.println("   Concesionarios:");
                for (int j = 0; j < concesionarios.size(); j++) {
                    Concesionario concesionario = concesionarios.get(j);
                    System.out.println("      Concesionario: " + concesionario.getNombre() + ", Dirección: " + concesionario.getDireccion() + ", Stock en este concesionario: " + stock);
                }
            }

            // Consulta para verificar fabricantes y sus motocicletas
            Query queryFabricantes = em.createQuery("SELECT f FROM Fabricante f JOIN FETCH f.motocicletas", Fabricante.class);
            List<Fabricante> fabricantes = queryFabricantes.getResultList();
            System.out.println("Fabricantes y sus motocicletas:");
            for (int i = 0; i < fabricantes.size(); i++) {
                Fabricante fabricante = fabricantes.get(i);
                System.out.println("Fabricante: " + fabricante.getNombre());
                List<Moto> motosFabricante = fabricante.getMotocicletas();
                System.out.println("   Motocicletas:");
                for (int j = 0; j < motosFabricante.size(); j++) {
                    Moto moto = motosFabricante.get(j);
                    System.out.println("      Motocicleta: " + moto.getModelo());
                }
            }

            // Consulta para verificar concesionarios, sus motocicletas y clientes
            Query queryConcesionarios = em.createQuery("SELECT c FROM Concesionario c JOIN FETCH c.motocicletas JOIN FETCH c.clientes", Concesionario.class);
            List<Concesionario> concesionarios = queryConcesionarios.getResultList();
            System.out.println("Concesionarios, sus motocicletas y clientes:");
            for (int i = 0; i < concesionarios.size(); i++) {
                Concesionario concesionario = concesionarios.get(i);
                System.out.println("Concesionario: " + concesionario.getNombre() + ", Dirección: " + concesionario.getDireccion());
                List<Moto> motocicletasConcesionario = concesionario.getMotocicletas();
                System.out.println("   Motocicletas:");
                for (int j = 0; j < motocicletasConcesionario.size(); j++) {
                    Moto motocicleta = motocicletasConcesionario.get(j);
                    System.out.println("      Motocicleta: " + motocicleta.getModelo());
                }
                List<Cliente> clientesConcesionario = concesionario.getClientes();
                System.out.println("   Clientes:");
                for (int k = 0; k < clientesConcesionario.size(); k++) {
                    Cliente cliente = clientesConcesionario.get(k);
                    System.out.println("      Cliente: " + cliente.getNombre());
                }
            }

            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            em.close();
            emf.close();
        }
    }
}
