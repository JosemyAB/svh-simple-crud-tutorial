package es.mhp.entities;

import javax.persistence.*;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.util.List;


/**
 * Created by Edu on 11/02/2016.
 */

@Entity
@Table(name = "ITEM")
public class Item extends AbstractEntity {

    @Id
    @SequenceGenerator(name="item_sequence", initialValue=1, allocationSize=9999999)
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="item_sequence")
    @Column(name = "ITEMID")
    private Integer itemId;

    @ManyToMany(cascade = {CascadeType.ALL},mappedBy="items")
    private List<Tag> tags;

    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Product.class)
    @JoinColumn(name = "productId")
    private Product product;

    @Column(name = "IMAGETHUMBURL")
    @Size(max = 55)
    private String imageThumbUrl;

    @Column(name = "PRICE")
    @Digits(integer = 12, fraction = 2)
    private BigDecimal price;

    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Address.class)
    @JoinColumn(name = "ADDRESS_ADDRESSID")
    private Address address;

    @ManyToOne(fetch = FetchType.LAZY, targetEntity = SellerContactInfo.class)
    @JoinColumn(name = "CONTACTINFO_CONTACTINFOID")
    private SellerContactInfo seller;

    @Column(name = "TOTALSCORE")
    private Integer totalScore;

    @Column(name = "NUMBEROFVOTES")
    private Integer numberOfVotes;

    //@Doubt: default value true, this could be done in the constructor too?
    @Column(name = "DISABLED", columnDefinition = "boolean default true")
    private boolean disabled = true;

    @Column(name = "NAME")
    @Size(max = 30)
    private String name;

    @Column(name = "DESCRIPTION")
    @Size(max = 500)
    private String description;

    @Column(name = "IMAGEURL")
    @Size(max = 55)
    private String imageUrl;

    public Item() {}

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isDisabled() {
        return disabled;
    }

    public void setDisabled(boolean disabled) {
        this.disabled = disabled;
    }

    public int getNumberOfVotes() {
        return numberOfVotes;
    }

    public void setNumberOfVotes(int numberOfVotes) {
        this.numberOfVotes = numberOfVotes;
    }

    public int getTotalScore() {
        return totalScore;
    }

    public void setTotalScore(int totalScore) {
        this.totalScore = totalScore;
    }

    public SellerContactInfo getSeller() {
        return seller;
    }

    public void setSeller(SellerContactInfo seller) {
        this.seller = seller;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getImageThumbUrl() {
        return imageThumbUrl;
    }

    public void setImageThumbUrl(String imageThumbUrl) {
        this.imageThumbUrl = imageThumbUrl;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public List<Tag> getTags() {
        return tags;
    }

    public void setTags(List<Tag> tags) {
        this.tags = tags;
    }

    public Integer getItemId() {
        return itemId;
    }

    public void setItemId(Integer itemId) {
        this.itemId = itemId;
    }
}