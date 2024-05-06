/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package auction.data;

import auction.business.Notification;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import java.util.List;
import javax.persistence.TypedQuery;

import auction.business.Notification;
import auction.business.Buyer;



/**
 *
 * @author ThangDz
 */
public class NotiDB {
    public static void insert(Notification Notification) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        trans.begin();        
        try {
            em.persist(Notification);
            trans.commit();
        } catch (Exception e) {
            System.out.println(e);
            trans.rollback();
        } finally {
            em.close();
        }
    }
    
    public static List<Notification> selectNotifications(Buyer currentUser) {
        
        try{
            
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        
        String qString = "SELECT u from Notification u "
            + "WHERE u.user = :currentUser "
                + "ORDER BY u.idNoti DESC";
        
        System.out.println("this is the query " + qString);
        System.out.println("is user send; userID =  " + currentUser);
        
        TypedQuery<Notification> q = em.createQuery(qString, Notification.class);
        
        q.setParameter("currentUser", currentUser);
        
        q.setMaxResults(3);


        List<Notification> notifications;
        try {
            notifications = q.getResultList();
            if (notifications == null || notifications.isEmpty())
                notifications = null;
        } finally {
            em.close();
        }
        return notifications;
        }
        catch (Exception e) {
            // Handle the exception appropriately, e.g., log it or throw a custom exception
            e.printStackTrace(); // This prints the exception's stack trace, replace with proper logging
            return null; // Or throw a custom exception based on your application logic
        }
    }
    
    public static List<Notification> selectNotification() {
        

            
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        
        String qString = "SELECT u from Notification u ";
           // + "WHERE u.user = :currentUser";
        
       
        
        TypedQuery<Notification> q = em.createQuery(qString, Notification.class);
        


        List<Notification> notifications;
        try {
            notifications = q.getResultList();
            if (notifications == null || notifications.isEmpty())
                notifications = null;
        } finally {
            em.close();
        }
        return notifications;
    }
}
