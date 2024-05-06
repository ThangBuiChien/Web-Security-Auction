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
import javax.persistence.ManyToOne;
 




/**
 *
 * @author ThangDz
 */
@Entity
public class Bid implements Serializable {

    @ManyToOne
    private Buyer buyer;
    
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long invoiceNumber;
//    @ManyToOne
//    private Product product;
    
    private int bidPrice;
    private String timeBid;
    
    public Buyer getBuyer() {
        return buyer;
    }

    public void setBuyer(Buyer buyer) {
        this.buyer = buyer;
    }
    
    public Long getInvoiceNumber() {
        return invoiceNumber;
    }

    public void setInvoiceNumber(long invoiceNumber) {
        this.invoiceNumber = invoiceNumber;
    }
    
    public int getBidPrice() {
        return bidPrice;
    }

    public void setBidPrice(int bidPrice) {
        this.bidPrice = bidPrice;
    }
    
    public String getTimeBid() {
        return timeBid;
    }

    public void setTimeBid(String timeBid) {
        this.timeBid = timeBid;
    }
    
    
    
    
}
