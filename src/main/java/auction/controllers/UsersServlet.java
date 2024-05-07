package auction.controllers;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;

import javax.servlet.annotation.WebServlet;
import auction.data.*;
import auction.business.*;
import auction.data.BuyerDB;
import auction.business.Buyer;
import auction.business.Cart;
import auction.business.Notification;
import auction.data.CartDB;
import auction.data.NotiDB;
 
@WebServlet("/userLogin")
public class UsersServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession session = request.getSession();

        String url = "/index.jsp";
        
        // get current action
        String action = request.getParameter("action");
        if (action == null) {
            action = "register";  // default action
        }
        
        
        
        else if (action.equals("register")) { 
            
            //Get imformation
            String newEmail = request.getParameter("email");
            String newPassword = request.getParameter("password");
            
            //Create new buyer with information
            Buyer buyer = new Buyer();
            buyer.setEmail(newEmail);
            buyer.setPassword(newPassword);
            
            Seller seller = new Seller();
            seller.setEmail(newEmail);
            seller.setPassword(newPassword);
            //save to database
            String message;
            if (BuyerDB.emailExists(newEmail)) {
                message = "This email address already exists.<br>" +
                          "Please enter another email address.";
                url = "/RegisteringForm.jsp";

            }
            else {
                message = "Create new account succesfully, please login in";
                BuyerDB.insert(buyer);
                SellerDB.insert(seller);
                 url = "/LoginForm.jsp";
            }
            
            
            //Announce succesfull and send to login.jsp
            request.setAttribute("message", message);
            
        }
        else if (action.equals("login")){
            String currentEmail = request.getParameter("email");
            String currentPassword = request.getParameter("password");
            
            String message="";
            if(BuyerDB.checkPassword(currentEmail, currentPassword)){
                

                
                
                Buyer currentBuyer = BuyerDB.selectUser(currentEmail);
                Seller currentSeller = SellerDB.selectUser(currentEmail);
                
                //store current login succesfully to use 
                session.setAttribute("buyer", currentBuyer);
                session.setAttribute("seller", currentSeller);
                //Load to main page 
                if("activate".equals(currentBuyer.getAccountStatus())){
                    message = "Login successfully";
                    session.setAttribute("user", currentBuyer);
                    //session.setAttribute("user", currentSeller);
                    url = "/index.jsp";
                    
                    
                    
                }
                else{
                    url = "/AddInfoUserForm.jsp";
                }
                
                

            }
            else {
                message = "Wrong account or password, please try again";
                url = "/LoginForm.jsp";
                }
            
            request.setAttribute("message", message);
            
        }
        
        else if (action.equals("logOut")){
            session.removeAttribute("user");
             url = "/LoginForm.jsp";
        }
        
        else if (action.equals("createNewAccount")){
            url = "/RegisteringForm.jsp";
        }
        
        else if (action.equals("addInformation")){
            //Get imformation
            String firstName = request.getParameter("firstName");
            String lastName = request.getParameter("lastName");
            String address = request.getParameter("address");
            String debitCardInfo = request.getParameter("debitCardInfo");
            
            //get the current buyer
            Buyer currentBuyer = (Buyer) session.getAttribute("buyer");
            Seller currentSeller = (Seller) session.getAttribute("seller");
            //Add new value
            currentBuyer.setFirstName(firstName);
            currentBuyer.setLastName(lastName);
            currentBuyer.setAddress(address);
            currentBuyer.setDebitCardInfo(debitCardInfo);
            currentBuyer.setAccountStatus("activate");
            
            currentSeller.setFirstName(firstName);
            currentSeller.setLastName(lastName);
            currentSeller.setCompanyName(address);
            currentSeller.setPhoneNumber(debitCardInfo);
            currentSeller.setAccountStatus("activate");
            //Store to DB
            BuyerDB.update(currentBuyer);
            SellerDB.update(currentSeller);
            
            //add cart to usesr
            Cart newCart = new Cart();
            newCart.setBuyer(currentBuyer);
            CartDB.insert(newCart);
            
            session.setAttribute("cart", newCart);
            
            //
            String message = "Update succesfully!";
            request.setAttribute("message", message);
            
            url = "/LoginForm.jsp";
        
        }
        else if (action.equals("Change")){
            url = "/ChangInfoUser.jsp";
        } 
        else if (action.equals("ChangeInfo")){
            
            String firstName = request.getParameter("firstName");
            String lastName = request.getParameter("lastName");
            String companyName = request.getParameter("companyName");
            String phoneNumber = request.getParameter("phoneNumber");
            Seller currentSeller = (Seller) session.getAttribute("seller");
            currentSeller.setFirstName(firstName);
            currentSeller.setLastName(lastName);
            currentSeller.setCompanyName(companyName);
            currentSeller.setPhoneNumber(phoneNumber);
            SellerDB.update(currentSeller);
            
            Buyer currentBuyer = (Buyer) session.getAttribute("buyer");
            currentBuyer.setFirstName(firstName);
            currentBuyer.setLastName(lastName);
            currentBuyer.setAddress(companyName);
            currentBuyer.setDebitCardInfo(phoneNumber);
            BuyerDB.update(currentBuyer);
            

            //
            String message = "Update succesfully!";
            request.setAttribute("message", message);
            
            url = "/SellerForm.jsp";
        } 

        else if (action.equals("loadNofi")){
            try{
            Buyer currentUser = (Buyer)session.getAttribute("user");
            String email = currentUser.getEmail();
            System.out.println("This is email from load Nofi" + email);
            List<Notification> tempNofi = NotiDB.selectNotifications(currentUser);
                
            request.setAttribute("nofi", tempNofi);
            
            url = "/index.jsp";
       

            }
            catch (Exception e) {
                // Catch any exceptions and print the stack trace
                String mess = "You has been log out, plaese log in again!";
                request.setAttribute("message", mess);
                url = "/LoginForm.jsp";
            }
            
        }
        
        else if (action.equals("contact")){
            
                // Catch any exceptions and print the stack trace
                String mess = "You will be receive our email soon!";
                request.setAttribute("message", mess);
                System.out.println("this was in contact servlet");
                url = "/contact.jsp";
            
            
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