package auction.business;

import auction.business.Buyer;
import auction.business.Product;
import java.time.LocalDate;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.8.v20201217-rNA", date="2024-05-07T07:53:23")
@StaticMetamodel(Receipt.class)
public class Receipt_ { 

    public static volatile SingularAttribute<Receipt, Product> product;
    public static volatile SingularAttribute<Receipt, LocalDate> datetime;
    public static volatile SingularAttribute<Receipt, Long> id;
    public static volatile SingularAttribute<Receipt, Buyer> buyer;

}