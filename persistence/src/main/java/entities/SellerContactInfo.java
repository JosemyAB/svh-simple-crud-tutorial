package entities;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.List;

/**
 * Created by Edu on 12/02/2016.
 */

@Entity
@Table(name = "SELLER_CONTACT_INFO")
public class SellerContactInfo extends AbstractEntity{

    @Id
    @SequenceGenerator(name="seller_sequence", initialValue=1, allocationSize=9999999)
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="seller_sequence")
    @Column(name = "SELLER_ID")
    private Integer sellerId;

    @OneToMany(fetch = FetchType.LAZY, targetEntity = Item.class)
    @JoinColumn(name = "itemId")
    private List<Item> item;

    @Column(name = "LAST_NAME")
    @Size(max = 24)
    private String lastName;

    @Column(name = "FIRST_NAME")
    @Size(max = 24)
    private String firstName;

    @Column(name = "EMAIL")
    @Size(max = 24)
    private String email;

    SellerContactInfo(){}

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getSellerId() {
        return sellerId;
    }

    public void setSellerId(Integer sellerId) {
        this.sellerId = sellerId;
    }

    public List<Item> getItem() {
        return item;
    }

    public void setItem(List<Item> item) {
        this.item = item;
    }
}
