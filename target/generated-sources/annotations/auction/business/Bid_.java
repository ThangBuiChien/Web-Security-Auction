package auction.business;

import auction.business.Buyer;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.8.v20201217-rNA", date="2024-05-07T07:53:23")
@StaticMetamodel(Bid.class)
public class Bid_ { 

    public static volatile SingularAttribute<Bid, Long> invoiceNumber;
    public static volatile SingularAttribute<Bid, Integer> bidPrice;
    public static volatile SingularAttribute<Bid, String> timeBid;
    public static volatile SingularAttribute<Bid, Buyer> buyer;

}