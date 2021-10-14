/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package libreria1;

import java.util.Collection;
import java.util.UUID;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;

/**
 *
 * @author usuario
 */
public class Libreria1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try{
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Libreria1PU");
        EntityManager em = emf.createEntityManager();
//        Autor au = new Autor();
        Editorial ed = new Editorial();
        Libro li = new Libro();
/*        
        au.setId(UUID.randomUUID().toString());
        au.setId("2");
        au.setNombre("Borges");
        
        em.getTransaction().begin();
        em.persist(au);
        em.getTransaction().commit();
        
        Editorial ed = new Editorial();
        ed.setId(UUID.randomUUID().toString());
        ed.setId("2");
        ed.setNombre("Editorial Palomita");
        
        em.getTransaction().begin();
        em.persist(ed);
        em.getTransaction().commit();
    
        Libro li = new Libro();
        li.setIsbn(UUID.randomUUID().toString());
        li.setIsbn("4");
        li.setTitulo("El Rasputinh");
        li.setEjemplares(100);
        li.setEjemplaresPrestados(50);
        li.setEjemplaresRestantes(50);
        li.setAlta(true);
        li.setAnio(1821);
        li.setAutor(au);
        li.setEditorial(ed);
               
        em.getTransaction().begin();
        em.persist(li);
        em.getTransaction().commit();
       
        } catch (Exception e){
            System.out.println("Error de sistema");
        }

        Autor au1 = new Autor();
               
        au1.setId(UUID.randomUUID().toString());
        au1.setId("3");
        au1.setNombre("Pepito");
        
        em.getTransaction().begin();
        em.persist(au1);
        em.getTransaction().commit();
      
        au1 = em.find(Autor.class, au1.getId());
        
        String id = "2";
        au1 = (Autor) em.createQuery("SELECT a FROM Autor a WHERE a.id = :id")
        .setParameter("id",id).getSingleResult();
      
        Collection<Libro>libros;
        libros = em.createQuery("SELECT l FROM Libro l").getResultList();
        
        for (Libro l: libros) {
            System.out.println(l.getTitulo());
            System.out.println(l.getIsbn());
        }
    
        li = (Libro) em.createQuery("SELECT l"
                + " FROM Libro l"
                + "WHERE l.isbn = :isbn ")
                .setParameter("isbn","2")
                .getSingleResult();
 
        // Colocar en el ISBN los valores de 4 0 de 15 y de esa manera se lanza o no, la NoResultException!!!!
        String isbn = "15";
        li = (Libro) em.createQuery("SELECT l FROM Libro l WHERE l.isbn = :isbn")
        .setParameter("isbn",isbn).getSingleResult();
        
            System.out.println(li.getTitulo());
            System.out.println(li.getIsbn());
            System.out.println(li.getEditorial().getNombre());

        // mdodifica un dato del siguiente codigo isbn
        String isbn = "4";
        li = (Libro) em.createQuery("SELECT l FROM Libro l WHERE l.isbn = :isbn")
        .setParameter("isbn",isbn).getSingleResult();
        
        li.setTitulo("Cara cortada");
        
        em.getTransaction().begin();
        em.merge(li);
        em.getTransaction().commit();
*/
        // elimina un dato del siguiente codigo isbn
        String isbn = "4";
        li = (Libro) em.createQuery("SELECT l FROM Libro l WHERE l.isbn = :isbn")
        .setParameter("isbn",isbn).getSingleResult();
        
        em.getTransaction().begin();
        em.remove(li);
        em.getTransaction().commit();
        
        } catch (Exception e){
            System.out.println("No se encontró el libro buscado");
        }
    }    
}
