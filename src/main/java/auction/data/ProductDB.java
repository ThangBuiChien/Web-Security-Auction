/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package auction.data;


import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import auction.business.Product;
import auction.business.Buyer;

import java.util.List;


public class ProductDB {
     public static void insert(Product product) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        trans.begin();        
        try {
            em.persist(product);
            trans.commit();
        } catch (Exception e) {
            System.out.println(e);
            trans.rollback();
        } finally {
            em.close();
        }
    }
    

    public static void update(Product product) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        trans.begin();       
        try {
            em.merge(product);
            trans.commit();
        } catch (Exception e) {
            System.out.println(e);
            trans.rollback();
        } finally {
            em.close();
        }
    }

    
    public static List<Product> selectProducts() {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        String qString = "SELECT u from Product u";
        TypedQuery<Product> q = em.createQuery(qString, Product.class);

        List<Product> users;
        try {
            users = q.getResultList();
            if (users == null || users.isEmpty())
                users = null;
        } finally {
            em.close();
        }
        return users;
    }
    
    public static List<Product> selectBiddingProducts() {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        String qString = "SELECT u from Product u" 
                + " WHERE u.productStatus = 0"
                + " ORDER BY u.productID";
        TypedQuery<Product> q = em.createQuery(qString, Product.class);

        List<Product> users;
        try {
            users = q.getResultList();
            if (users == null || users.isEmpty())
                users = null;
        } finally {
            em.close();
        }
        return users;
    }
    
    public static List<Product> selectProductsByName(String productName1) {
    EntityManager em = DBUtil.getEmFactory().createEntityManager();

    String qString = "SELECT p FROM Product p WHERE LOWER(p.productName) LIKE LOWER(:productName1) "
            + "AND p.productStatus=0";
    //String qString = "SELECT p FROM Product p WHERE LOWER(p.productName) LIKE LOWER("
    //            + productName1 + ")";


    TypedQuery<Product> q = em.createQuery(qString, Product.class);
    q.setParameter("productName1", "%" +  productName1 + "%" );
    
    System.out.println("the querry is strange: " + qString);



    List<Product> products;
    try {
        products = q.getResultList();
        if (products == null || products.isEmpty()) {
            products = null;
        }
    } finally {
        em.close();
    }
    return products;
}

    
    public static List<Product> selectWinningProductsByUser(Buyer user) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        String qString = "SELECT u from Product u" 
                + " WHERE u.productStatus = 1 and u.winner = :user "
                + " ORDER BY u.productID";
        System.out.println("is user send; userID =  " + user.getId());

        TypedQuery<Product> q = em.createQuery(qString, Product.class);
        q.setParameter("user", user);

        List<Product> users;
        

        try {
            users = q.getResultList();

            if (users == null || users.isEmpty())
                users = null;
        } finally {
            em.close();
        }
        //System.out.println("This is from loadProductByUSer: " + users.get(0).getProductName());

        return users;
    }

    
//    public static Product selectProduct(long ID) {
//        EntityManager em = DBUtil.getEmFactory().createEntityManager();
//        String qString = "SELECT p FROM Product  " +
//                "WHERE p.productID == :ID";
//        TypedQuery<Product> q = em.createQuery(qString, Product.class);
//        //q.setParameter("email", email);
//        try {
//            Product currentProduct = q.getSingleResult();
//            return currentProduct;
//        } catch (NoResultException e) {
//            return null;
//        } finally {
//            em.close();
//        }
//    }
    
    public static Product selectProduct(long ID) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        String qString = "SELECT u FROM Product u " +
                "WHERE u.productID = :ID";
        TypedQuery<Product> q = em.createQuery(qString, Product.class);
        q.setParameter("ID", ID);
        try {
            Product currentProduct = q.getSingleResult();
            return currentProduct;
        } catch (NoResultException e) {

            return null;
        } finally {
            em.close();
        }

    }
    
    
}
