package com.example.giftlist.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;
@Entity
@Table(name = "item")
public class ItemGift {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "list_id", nullable = false)
    private ListGift listId;

    @Column(name = "name", nullable = true)
    private String name;

    @Column(name = "price", nullable = true)
    private BigDecimal price;

    @Column(name = "link", nullable = true)
    private String link;

    @Column(name = "description")
    private String description;

    @Column(name ="is_purchased")
    private Boolean is_purchased;

    @ManyToOne
    @JoinColumn(name = "purchased_by", nullable = false)
    private User purchasedBy;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ListGift getListId() {
        return listId;
    }

    public void setListId(ListGift listId) {
        this.listId = listId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public Boolean getIs_purchased() {
        return is_purchased;
    }

    public void setIs_purchased(Boolean is_purchased) {
        this.is_purchased = is_purchased;
    }

    public User getPurchasedBy() {
        return purchasedBy;
    }

    public void setPurchasedBy(User purchasedBy) {
        this.purchasedBy = purchasedBy;
    }
}
