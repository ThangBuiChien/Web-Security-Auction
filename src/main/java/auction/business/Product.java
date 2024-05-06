package auction.business;

import java.text.NumberFormat;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import static javax.persistence.FetchType.EAGER;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;


@Entity
public class Product implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int productID;
    private String productName;
    private String tag;
    private String description;
    private int productStatus;
    private int startingBidPrice;
    private int currentPrice;
    private int buyNowPrice;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date endDateTime;

    
    
//    @ManyToOne(fetch=FetchType.EAGER)
//    private Seller seller;
    
    @ManyToOne(fetch=FetchType.EAGER)
    private Seller seller;
    
    @OneToMany(fetch=EAGER, cascade=CascadeType.PERSIST)  
    private List<Buyer> follower;
    

    @ManyToOne(fetch=FetchType.EAGER)
    private Buyer winner;

    
    public Product() {}
    
    public int getID() {
        return productID;
    }

    public void setID(int productID) {
        this.productID = productID;
    }
    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }
    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    public int getProductStatus() {
        return productStatus;
    }

    public void setProductStatus(int productStatus) {
        this.productStatus = productStatus;
    }
    public int getStartingBidPrice() {
        return startingBidPrice;
    }

    public void setStartingBidPrice(int startingBidPrice) {
        this.startingBidPrice = startingBidPrice;
    }
    public int getCurrentPrice() {
        return currentPrice;
    }

    public void setCurrentPrice(int currentPrice) {
        this.currentPrice= currentPrice;
    }
    public int getBuyNowPrice() {
        return buyNowPrice;
    }

    public void setBuyNowPrice(int buyNowPrice) {
        this.buyNowPrice= buyNowPrice;
    }  
//    public void setSeller(Seller s) {
//        seller = s;
//    }
//
//    public Seller getSeller() {
//        return seller;
//    }
    
    public void setSeller(Seller s) {
        this.seller = s;
    }

    public Seller getSeller() {
        return seller;
    }
    
    public void setFollower(List<Buyer> follower) {
        this.follower = follower;
    }

    public List<Buyer> getFollower() {
        return follower;
    }

    
    public void setWinner(Buyer winner) {
        this.winner = winner;

    }

    public Buyer getWinner() {
        return winner;
    }
    
    public void setEndDatetime(Date endDatetime)
    {
        this.endDateTime = endDatetime;
    }
    public Date getEndDatetime()
    {
        return endDateTime;
    }

}
