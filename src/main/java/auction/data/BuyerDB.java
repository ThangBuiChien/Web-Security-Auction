/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package auction.data;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import auction.business.Buyer;


/**
 *
 * @author ThangDz
 */
public class BuyerDB {
    public static void insert(Buyer buyer) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        trans.begin();        
        try {
            em.persist(buyer);
            trans.commit();
        } catch (Exception e) {
            System.out.println(e);
            trans.rollback();
        } finally {
            em.close();
        }
    }
    
    public static void update(Buyer buyer) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        trans.begin();       
        try {
            em.merge(buyer);
            trans.commit();
        } catch (Exception e) {
            System.out.println(e);
            trans.rollback();
        } finally {
            em.close();
        }
    }
    
    
    //Two function for check existed email
    public static Buyer selectUser(String email) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        String qString = "SELECT u FROM Buyer u " +
                "WHERE u.email = :email";
        TypedQuery<Buyer> q = em.createQuery(qString, Buyer.class);
        q.setParameter("email", email);
        try {
            Buyer user = q.getSingleResult();
            return user;
        } catch (NoResultException e) {
            return null;
        } finally {
            em.close();
        }
    }

    public static boolean emailExists(String email) {
        Buyer u = selectUser(email);   
        return u != null;
    }
    
    //Check acount and password
    
    public static boolean checkPassword(String email, String password) {
        Buyer u = selectUser(email);   
        
        if(u!=null ){
            if (u.getPassword().equals(password)) {
                return true;
            }
    }
        return false;
    }
    
    
    
}
