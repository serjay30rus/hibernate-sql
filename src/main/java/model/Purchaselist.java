package model;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "Purchaselist")
@Data
public class Purchaselist implements Serializable {

    @EmbeddedId
    private PurchasePrimaryKey key;

    private int price;

    @Column(name = "subscription_date")
    private Date subscriptionDate;
}
