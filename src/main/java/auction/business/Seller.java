package auction.business;

import java.text.NumberFormat;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Seller implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long sellerID;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String accountStatus;
    private String phoneNumber;
    private String companyName;
    private float accountBalance;
    



public Seller() {
        firstName = "";
        lastName = "";
        email = "";
        password = "";
        accountStatus = "";
        phoneNumber = "";
        companyName = "";
        accountBalance = 0;
}

 public Long getId() {
        return sellerID;
    }

    public void setId(Long sellerID) {
        this.sellerID = sellerID;
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
     public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }
    
     public float getAccountBalance() {
        return accountBalance;
    }
    public void setAccountBalance(float accountBalance) {
            this.accountBalance = accountBalance;
    }






}

