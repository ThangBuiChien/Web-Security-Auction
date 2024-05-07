package auction.business;

import auction.business.Buyer;
import auction.business.Product;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.8.v20201217-rNA", date="2024-04-21T15:31:59")
@StaticMetamodel(Cart.class)
public class Cart_ { 

    public static volatile ListAttribute<Cart, Product> listcart;
    public static volatile SingularAttribute<Cart, Integer> id;
    public static volatile SingularAttribute<Cart, Buyer> buyer;

}