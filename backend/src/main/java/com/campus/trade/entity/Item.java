package com.campus.trade.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "items")
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String title;

    @Column(columnDefinition = "TEXT")
    private String description;

    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal price;

    @Column(name = "orig_price", precision = 10, scale = 2)
    private BigDecimal origPrice;

    @Column(length = 20)
    private String category;

    @Column(name = "seller_id", nullable = false)
    private Long sellerId;

    @Column(name = "seller_name", length = 50)
    private String sellerName;

    @Column(columnDefinition = "MEDIUMTEXT")
    private String image;

    @Column(name = "created_date")
    private LocalDate createdDate = LocalDate.now();

    @Column(nullable = false)
    private Boolean sold = false;

    public Item() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    public BigDecimal getPrice() { return price; }
    public void setPrice(BigDecimal price) { this.price = price; }
    public BigDecimal getOrigPrice() { return origPrice; }
    public void setOrigPrice(BigDecimal origPrice) { this.origPrice = origPrice; }
    public String getCategory() { return category; }
    public void setCategory(String category) { this.category = category; }
    public Long getSellerId() { return sellerId; }
    public void setSellerId(Long sellerId) { this.sellerId = sellerId; }
    public String getSellerName() { return sellerName; }
    public void setSellerName(String sellerName) { this.sellerName = sellerName; }
    public String getImage() { return image; }
    public void setImage(String image) { this.image = image; }
    public LocalDate getCreatedDate() { return createdDate; }
    public void setCreatedDate(LocalDate createdDate) { this.createdDate = createdDate; }
    public Boolean getSold() { return sold; }
    public void setSold(Boolean sold) { this.sold = sold; }
}
