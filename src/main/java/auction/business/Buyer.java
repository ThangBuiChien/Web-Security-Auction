/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package auction.business;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


/**
 *
 * @author ThangDz
 */
@Entity
public class Buyer implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long buyerID;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String accountStatus;
    private String address;
    private String debitCardInfo;
    private float accountBalance;
    
    public Buyer() {
        firstName = "";
        lastName = "";
        email = "";
        password = "";
        accountStatus = "";
        address = "";
        debitCardInfo = "";
        accountBalance = 0;
        
    }
    
    //getId hay getBuyerID deu duoc
    // tuy nhiên nếu dùng getID thì ở lớp dưới DB thì phải dùng đúng tên, ở jsp thì phải dùng tên là ID
    //VD: "SELECT * ... WHERE buyerID = " còn jsp thì ${buyer.getID()}; còn đây là ghi sai: ${buyer.getBuyerID}
    public Long getId() {
        return buyerID;
    }

    public void setId(Long buyerID) {
        this.buyerID = buyerID;
    }
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAccountStatus() {
        return accountStatus;
    }

    public void setAccountStatus(String accountStatus) {
        this.accountStatus = accountStatus;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDebitCardInfo() {
        return debitCardInfo;
    }

    public void setDebitCardInfo(String debitCardInfo) {
        this.debitCardInfo = debitCardInfo;
    }

    public float getAccountBalance() {
        return accountBalance;
    }

    public void setAccountBalance(float accountBalance) {
        this.accountBalance = accountBalance;
    }

    
    
    
    
    
}
