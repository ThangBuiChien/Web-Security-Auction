
package auction.business;

import java.text.NumberFormat;
import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import static javax.persistence.FetchType.EAGER;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class Notification implements Serializable{

    //@ManyToOne(fetch=EAGER, cascade=CascadeType.PERSIST)  
    //private List<Seller> listseller;
    
    @ManyToOne
    private Buyer user;


    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idNoti;
    private String message;

    public Long getIdNoti() {
        return idNoti;
    }

    public void setIdNoti(Long idNoti) {
        this.idNoti = idNoti;
    }
//    public void setListseller(List<Seller> listseller) {
//        this.listseller = listseller;
//    }
//
//    public List<Seller> getListseller() {
//        return listseller;
//    }
    
     public void setUser(Buyer user) {
        this.user = user;
    }

    public Buyer getUser() {
        return user;
    }
      public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
    
    
}
