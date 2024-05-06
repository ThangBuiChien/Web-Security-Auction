
package auction.controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import auction.business.Buyer;
import auction.business.Cart;
import auction.business.Product;
import auction.data.CartDB;
//import auction.data.CartDB;
import auction.data.ProductDB;
import java.util.HashSet;


@WebServlet("/cart")
public class CartServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();
        String url = "/index.html";

        // get current action
        String action = request.getParameter("action");
        if (action == null) {
            action = "addcart"; // default action
        }

        if (action.equals("addcart")) {
            Buyer currentBuyer = (Buyer) session.getAttribute("buyer");
            
            // Retrieve product code from the request parameters
            String productCode = request.getParameter("productCode");

            if (productCode != null && !productCode.isEmpty()) {
                
                    // Convert product code to int
                    int currentProductID = Integer.parseInt(productCode);

                    // Fetch the product from the data source
                    Product currentProduct = ProductDB.selectProduct(currentProductID);

                    if (currentProduct != null) {
                        //Cart cart = (Cart) session.getAttribute("cart");
                        Cart cart = CartDB.selectCart(currentBuyer);

//                        if (cart == null) {
//                            cart = new Cart();
//                            cart.setBuyer(currentBuyer);
//                            CartDB.insert(cart);
//                        }
                        
                            cart.addItem(currentProduct);
                            
                            CartDB.update(cart);
                            
                            session.setAttribute("cart", cart);
                        
                            url = "/cartfinal.jsp";
                          
                         
                    }
            } 
        
        }
        else if (action.equals("deletecart")) {
            String productCode = request.getParameter("productCode");
            
            if (productCode != null && !productCode.isEmpty()) {
                Cart cart = (Cart) session.getAttribute("cart");
                int currentProductID = Integer.parseInt(productCode);
                cart.removeItem(currentProductID);
                CartDB.update(cart);
                session.setAttribute("cart", cart);
                url = "/cartfinal.jsp";
            }
        }
        
        else if (action.equals ("loadCart")){
            Buyer currentUser = (Buyer)session.getAttribute("user");
            Cart currentCart = CartDB.selectCart(currentUser);
            request.setAttribute("cart", currentCart);
            
            url = "/cartfinal.jsp";
            
        }
        else if (action.equals ("shop")){
            
            url = "/finalproduct.jsp";
            
        }
        getServletContext().getRequestDispatcher(url).forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }
}
