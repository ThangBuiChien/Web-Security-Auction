    package auction.controllers;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;

import javax.servlet.annotation.WebServlet;
import auction.data.ProductDB;
import auction.data.NotiDB;

import auction.business.Product;
import auction.business.Buyer;
import auction.business.Cart;
import auction.business.Notification;
import auction.business.Receipt;
import auction.business.Seller;
import auction.data.CartDB;
import auction.data.ReciptDB;
import java.text.ParseException;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;


@WebServlet("/productServlet")
public class ProductServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession session = request.getSession();

        String url = "/index.jsp";
        
        // get current action
        String action = request.getParameter("action");
        if (action == null) {
            action = "loadProduct";  // default action
        }
        
        
        
        if (action.equals("loadProduct")) { 
            List<Product> loadProduct = ProductDB.selectBiddingProducts();
            
            request.setAttribute("product", loadProduct);
            
            session.setAttribute("products", loadProduct);

          
            url = "/finalproduct.jsp";
            
            
            
            //Announce succesfull and send to login.jsp
            
        }
        
        else if (action.equals("loadProductByName")) { 
            String name = request.getParameter("productNameSearch");
            
            System.out.println("Naem serch: " + name);
            
            
            List<Product> loadProduct = ProductDB.selectProductsByName(name);
            
            System.out.println("Why it null, loadproduct is " + loadProduct);
            
            request.setAttribute("product", loadProduct);
            
            session.setAttribute("products", loadProduct);

            
            url = "/finalproduct.jsp";
            
            
            
            //Announce succesfull and send to login.jsp
            
        }
        
        else if (action.equals("loadProductByUser")){
            Buyer currentUser = (Buyer)session.getAttribute("buyer");
            
            List<Product> loadProduct = ProductDB.selectWinningProductsByUser(currentUser);
            
            request.setAttribute("products", loadProduct);
            
            
            url = "/winningproduct.jsp";

            
        }

        else if (action.equals("addProduct")){
            Product newProduct = new Product();
            String productName = request.getParameter("productName");
            String tag = request.getParameter("tag");
            String description = request.getParameter("description");
            String startingBidPrice = request.getParameter("startingBidPrice");
            int intStartingBidPrice = Integer.parseInt(startingBidPrice);
            String buyNowPrice = request.getParameter("buyNowPrice");
            int intBuyNowPrice = Integer.parseInt(buyNowPrice);
            String endDateTime = request.getParameter("endDatetime");
            Date endTime = null;
            LocalDateTime endTime1 = null;
            
            Seller currentseller =(Seller) session.getAttribute("seller");
            
            try {
                
                //endTime = new SimpleDateFormat("yyyy/MM/dd HH:mm").parse(endDateTime);
                SimpleDateFormat inFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm");
                endTime = inFormat.parse(endDateTime);
                
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm");
                endTime1 = LocalDateTime.parse(endDateTime, formatter);
            } catch (ParseException ex) {
                Logger.getLogger(ProductServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
            System.out.println("This is endTime from HTML Origin: " + endDateTime);
            System.out.println("This is endTime from HTML convert: " + endTime);
            
            LocalDateTime currentTime = LocalDateTime.now();
            
            Duration duration = Duration.between(currentTime, endTime1);
            int value = endTime1.compareTo(currentTime);
            
            if( value == 1){
            long differenceInSeconds = duration.getSeconds();
            
            System.out.println("Difference in seconds: " + differenceInSeconds);



            newProduct.setProductName(productName);
            newProduct.setTag(tag);
            newProduct.setDescription(description);
            newProduct.setStartingBidPrice(intStartingBidPrice);
            newProduct.setCurrentPrice(intStartingBidPrice);
            newProduct.setBuyNowPrice(intBuyNowPrice);
            newProduct.setEndDatetime(endTime);
            newProduct.setSeller(currentseller);
            
            
            ProductDB.insert(newProduct);
             
            //Load again the product
            
            List<Product> loadProduct = ProductDB.selectBiddingProducts();
            
            request.setAttribute("product", loadProduct);
            
            session.setAttribute("products", loadProduct);

            
            System.out.println("Call FROM outside schedules, add product succesful!!!!!!!!");
            System.out.println("This is endDateTime from Product " + newProduct.getEndDatetime() );

            url = "/finalproduct.jsp";
            
            
            ////////////Automatically call the GetFinalWinner
            int productID = newProduct.getID();
            
            ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
            
             scheduler.schedule(() -> {
                 
            Product currentProduct = ProductDB.selectProduct(productID);

                 
             try{
                 
             System.out.println("Scheduled task executed at: " + System.currentTimeMillis());

                
            
            //Product currentProduct = newProduct;
            currentProduct.setProductStatus(1);
            
            ProductDB.update(currentProduct);
            
            String message ="";
            
            message = "The winner is" + currentProduct.getWinner().getFirstName();
            
            
            
            List<Product> loadProduct1 = ProductDB.selectBiddingProducts();
            
            request.setAttribute("product", loadProduct1);           
            session.setAttribute("products", loadProduct1);          
            request.setAttribute("message", message);
            
            //check if it run or not
            System.out.println("Call FROM inside schedules!!!!!!!!" + message);
            
            //Get notifaction to the winner
                Buyer winner = currentProduct.getWinner();
                java.util.Date date = new java.util.Date();    
                String nofiMessage = "At " + date.toString() + " congratulation You are the winner of  "
                        + currentProduct.getProductName() +  " !";
                
                //Create new notification
                Notification newNofi = new Notification();
                newNofi.setUser(winner);
                newNofi.setMessage(nofiMessage);
                
                NotiDB.insert(newNofi);
                
                //Create the recipit
                Receipt newRecipt = new Receipt();
                newRecipt.setBuyer(winner);
                newRecipt.setProduct(currentProduct);
                LocalDate w = LocalDate.now();
                
                newRecipt.setDatetime(w);
                
                ReciptDB.insert(newRecipt);
             }
             
             
              
            catch (Exception e) {
                // Catch any exceptions and print the stack trace
                e.printStackTrace();
                currentProduct.setProductStatus(2);
                ProductDB.update(currentProduct);

                
            }

            }, differenceInSeconds, TimeUnit.SECONDS);
            
            

            }
            else{
                String message = "Please choose the end time older than current time";
                request.setAttribute("message", message);
                
                url = "/AddProduct.jsp";
            }
            
            
            
        }
        

        
        else if (action.equals("setBidPrice")){
            String strId = request.getParameter("productID");
            long id = Long.parseLong(strId);

            
            Buyer currentBuyer = (Buyer) session.getAttribute("buyer");
            String strNewBidPrice = request.getParameter("newBidPrice");
            
            
            
            int newBidPrice = Integer.parseInt(strNewBidPrice);
            
            String message = "";
            Product currentProduct = ProductDB.selectProduct((int) id);
            
            int isDifference  = 0; 
            
            if (!currentBuyer.getEmail().equals(currentProduct.getSeller().getEmail())) {
                isDifference  = 1;
            }
            
            System.out.println("This is id: " + strId);
            
            if(currentProduct.getProductStatus() == 0){
                if(newBidPrice > currentProduct.getCurrentPrice() && isDifference  == 1 ){
                
                //Get notifaction to last owner
                Buyer lastWinner = currentProduct.getWinner();
                java.util.Date date = new java.util.Date();    
                String nofiMessage = "At " + date.toString() + " The bid price of "
                        + currentProduct.getProductName() +  " has changed";
                
                //Create new notification
                Notification newNofi = new Notification();
                newNofi.setUser(lastWinner);
                newNofi.setMessage(nofiMessage);
                
                NotiDB.insert(newNofi);
                
 
                //Set new price and new current winner
                currentProduct.setCurrentPrice(newBidPrice);
                currentProduct.setWinner(currentBuyer);
                message = "Update bid price succesful";
                ProductDB.update(currentProduct);
                
                
                //store data to cart
                
                Cart currentCart = CartDB.selectCart(currentBuyer);
                currentCart.addItem(currentProduct);
                CartDB.update(currentCart);
                session.setAttribute("cart", currentCart);

                
                
                
                
            }
                else if (isDifference == 0 ){
                    message = "You can't bid your own product";

                }
                else{
                message = "Now bid price is not higer than current bid price, please choose a new bid price";

            }
            }
            else{
                message = "Bidding time is over!";

            }
            
            
            
            List<Product> loadProduct = ProductDB.selectBiddingProducts();
            
            //older version
            request.setAttribute("product", loadProduct);           
            session.setAttribute("products", loadProduct);          
            request.setAttribute("message", message);
            
            

            
            
            url = "/finalproduct.jsp"; 
            
            
            
            
            
            
            
            
                    
        }
        
        else if (action.equals("setFinalWinner")){
            String strId = request.getParameter("productID");
            long id = Long.parseLong(strId);
            
            Product currentProduct = ProductDB.selectProduct(id);
            
            currentProduct.setProductStatus(1);
            
            ProductDB.update(currentProduct);
            
            String message ="";
            message = "The winner is" + currentProduct.getWinner().getFirstName();
            
            List<Product> loadProduct = ProductDB.selectBiddingProducts();
            
            request.setAttribute("product", loadProduct);           
            session.setAttribute("products", loadProduct);          
            request.setAttribute("message", message);
            

            
            
            url = "/finalproduct.jsp"; 
            
            

            
        }
        else if(action.equals("Addproduct"))
        {
            url ="/AddProduct.jsp";
        }
        else if(action.equals("printInvoice"))
        {
            String strId = request.getParameter("productID");
            long longID = Long.parseLong(strId);
            Product currentProduct = ProductDB.selectProduct(longID);
            System.out.println("why it not read !!, product = " + currentProduct);
            Receipt newReceipt = ReciptDB.selectReceiptByProduct(currentProduct);
            
            request.setAttribute("receipt", newReceipt);
            
            
            
            url ="/receipt.jsp";
        }
        
        getServletContext()
                .getRequestDispatcher(url)
                .forward(request, response);
    }    
    
    @Override
    protected void doGet(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }    
}