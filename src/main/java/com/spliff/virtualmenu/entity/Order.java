package com.spliff.virtualmenu.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "ORDERS")
public class Order {
    @Id
    private String uuid;

    @Column(name = "total_price")
    private Integer totalPrice;

    @Column(name = "total_price_vat")
    private Integer totalPriceWithVAT;

    @Column(name = "order_date")
    private Date orderDate;

    @OneToMany(mappedBy = "order")
    @JsonIgnore
    private Set<OrderToProductRelation> orderToProductRelations;

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public Integer getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Integer totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Integer getTotalPriceWithVAT() {
        return totalPriceWithVAT;
    }

    public void setTotalPriceWithVAT(Integer totalPriceWithVAT) {
        this.totalPriceWithVAT = totalPriceWithVAT;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public Set<OrderToProductRelation> getOrderToProductRelations() {
        return orderToProductRelations;
    }

    public void setOrderToProductRelations(Set<OrderToProductRelation> orderToProductRelations) {
        this.orderToProductRelations = orderToProductRelations;
    }
}
