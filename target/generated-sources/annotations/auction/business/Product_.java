package auction.business;

import auction.business.Buyer;
import auction.business.Seller;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.8.v20201217-rNA", date="2024-04-21T15:31:59")
@StaticMetamodel(Product.class)
public class Product_ { 

    public static volatile SingularAttribute<Product, Seller> seller;
    public static volatile ListAttribute<Product, Buyer> follower;
    public static volatile SingularAttribute<Product, Buyer> winner;
    public static volatile SingularAttribute<Product, Integer> productID;
    public static volatile SingularAttribute<Product, String> description;
    public static volatile SingularAttribute<Product, Integer> productStatus;
    public static volatile SingularAttribute<Product, Integer> startingBidPrice;
    public static volatile SingularAttribute<Product, Integer> currentPrice;
    public static volatile SingularAttribute<Product, String> tag;
    public static volatile SingularAttribute<Product, Integer> buyNowPrice;
    public static volatile SingularAttribute<Product, Date> endDateTime;
    public static volatile SingularAttribute<Product, String> productName;

}