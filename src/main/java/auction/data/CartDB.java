/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package auction.data;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import auction.business.*;

public class CartDB {
    
    
    public static void insert(Cart cart) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        trans.begin();        
        try {
            em.persist(cart);
            trans.commit();
        } catch (Exception e) {
            System.out.println(e);
            trans.rollback();
        } finally {
            em.close();
        }
    }
    
    public static void update(Cart cart) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        trans.begin();       
        try {
            em.merge(cart);
            trans.commit();
        } catch (Exception e) {
            System.out.println(e);
            trans.rollback();
        } finally {
            em.close();
        }
    }
    
    public static Cart selectCart(Buyer currentUser) {
        

            
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        
        String qString = "SELECT u from Cart u "
            + "WHERE u.buyer = :currentUser";
        
        System.out.println("this is the query " + qString);
        System.out.println("is user send; userID =  " + currentUser);
        
        TypedQuery<Cart> q = em.createQuery(qString, Cart.class);
        
        q.setParameter("currentUser", currentUser);


        Cart cart;
        try {
            cart = q.getSingleResult();

        } 
        catch (NoResultException e) {
            cart = null; // Handle case where no result is found
        } finally {
            em.close();
        }
        return cart;
    }
//public static Cart selectCart(Long buyerID) {
//        EntityManager em = DBUtil.getEmFactory().createEntityManager();
//
//        String qString = "SELECT u FROM Cart u " +
//                "WHERE u.buyerid = :buyerID";
//        TypedQuery<Cart> q = em.createQuery(qString, Cart.class);
//        q.setParameter("buyerID", buyerID);
//
//        try {
//            Cart cart = q.getSingleResult();
//            return cart;
//        } catch (NoResultException e) {
//            return null;
//        } finally {
//            em.close();
//        }
//    }
//
//    public static Cart selectCart() {
//        EntityManager em = DBUtil.getEmFactory().createEntityManager();
//
//        String qString = "SELECT u FROM Cart u";
//        TypedQuery<Cart> q = em.createQuery(qString, Cart.class);
//
//        try {
//            Cart cart = q.getSingleResult();
//            return cart;
//        } catch (NoResultException e) {
//            return null;
//        } finally {
//            em.close();
//        }
//    }
    
    
}
