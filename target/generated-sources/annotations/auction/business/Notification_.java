package auction.business;

import auction.business.Buyer;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.8.v20201217-rNA", date="2024-04-21T15:31:59")
@StaticMetamodel(Notification.class)
public class Notification_ { 

    public static volatile SingularAttribute<Notification, Long> idNoti;
    public static volatile SingularAttribute<Notification, String> message;
    public static volatile SingularAttribute<Notification, Buyer> user;

}