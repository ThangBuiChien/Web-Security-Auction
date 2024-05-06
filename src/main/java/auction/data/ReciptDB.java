/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package auction.data;

import auction.business.Product;
import auction.business.Receipt;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

/**
 *
 * @author ThangDz
 */
public class ReciptDB {
     public static void insert(Receipt receipt) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        trans.begin();        
        try {
            em.persist(receipt);
            trans.commit();
        } catch (Exception e) {
            System.out.println(e);
            trans.rollback();
        } finally {
            em.close();
        }
    }
    

    public static void update(Receipt receipt) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        trans.begin();       
        try {
            em.merge(receipt);
            trans.commit();
        } catch (Exception e) {
            System.out.println(e);
            trans.rollback();
        } finally {
            em.close();
        }
    }
    
    public static Receipt selectReceiptByProduct(Product product1) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        
        String qString = "SELECT u from Receipt u "
            + "WHERE u.product = :product";
        
        
        TypedQuery<Receipt> q = em.createQuery(qString, Receipt.class);
        
        q.setParameter("product", product1);
        
        System.out.println("This is product from recepit: " + product1);


        Receipt receipt ;
        try {
            receipt = q.getSingleResult();

        } 
        finally {
            em.close();
        }
        return receipt;
    }
    
}
