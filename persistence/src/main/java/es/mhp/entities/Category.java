package es.mhp.entities;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Set;

/**
 * Created by Edu on 12/02/2016.
 */

@Entity
@Table(name = "CATEGORY")
public class Category extends AbstractEntity{

    @Id
    @Size(max = 10)
    @Column(name = "CATEGORYID")
    private String categoryId;

    @OneToMany(mappedBy = "category", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Product> products;

    @Column(name = "NAME")
    @Size(max = 25)
    private String name;

    @Column(name = "DESCRIPTION")
    @Size(max = 255)
    private String description;

    @Column(name = "IMAGEURL")
    @Size(max = 55)
    private String imageUrl;

    public Category(String imageUrl, String description, String name, String categoryId){
        setImageUrl(imageUrl);
        setDescription(description);
        setName(name);
        setCategoryId(categoryId);
    }

    public Category(){}

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

    public Set<Product> getProducts() {
        return products;
    }

    public void setProducts(Set<Product> products) {
        this.products = products;
    }

    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    public int getProductsCount() {
        if (getProducts() == null)
            return 0;
        return this.products.size();
    }
}