package auction.business;

import auction.business.Buyer;
import auction.business.Product;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;




@Entity
public class Receipt implements Serializable {
    
    @ManyToOne
    private Buyer buyer;
    
    @OneToOne
    private Product product;
    
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private Long id;
    private LocalDate datetime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
      public LocalDate getDatetime() {
        return datetime;
    }

    public void setDatetime(LocalDate datetime) {
        this.datetime = datetime;
    }
    public Buyer getBuyer() {
        return buyer;
    }

    public void setBuyer(Buyer buyer) {
        this.buyer = buyer;
    }
    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
    
    
}
