package com.entities;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "product", schema = "shopgiaymaster")
public class ProductEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String description;
    private Double price;
    private String title;
    private String image;

    @ManyToOne // lấy product thì lấy category luôn
    @JoinColumn(name = "cateID")
    private CategoryEntity category;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }



    public CategoryEntity getCategory() {
        return category;
    }

    public void setCategory(CategoryEntity category) {
        this.category = category;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }


//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//
//        ProductEntity that = (ProductEntity) o;
//
//        if (id != that.id) return false;
//        if (name != null ? !name.equals(that.name) : that.name != null) return false;
//        if (desciption != null ? !desciption.equals(that.desciption) : that.desciption != null) return false;
//        if (price != null ? !price.equals(that.price) : that.price != null) return false;
//        if (image != null ? !image.equals(that.image) : that.image != null) return false;
//
//        return true;
//    }
//
//    @Override
//    public int hashCode() {
//        int result = id;
//        result = 31 * result + (name != null ? name.hashCode() : 0);
//        result = 31 * result + (desciption != null ? desciption.hashCode() : 0);
//        result = 31 * result + (price != null ? price.hashCode() : 0);
//        result = 31 * result + (image != null ? image.hashCode() : 0);
//        return result;
//    }
}
