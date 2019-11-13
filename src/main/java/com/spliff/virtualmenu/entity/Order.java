package com.spliff.virtualmenu.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "ORDERS")
public class Order {
    @Id
    private String uuid;

    @Column(name = "total_price")
    private Integer totalPrice;

    @Column(name = "total_price_without_vat")
    private Integer totalPriceWithoutVAT;

    @Column(name = "order_date")
    private Date orderDate;

    @OneToMany(mappedBy = "order")
    @JsonIgnore
    private Set<OrderToProductRelation> orderToProductRelations;

    @ManyToOne
    @JoinColumn(name = "ORDERING_TABLE_ID")
    @JsonIgnore
    private OrderingTable orderingTable;

    private Order() {
    }

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
        return totalPriceWithoutVAT;
    }

    public void setTotalPriceWithVAT(Integer totalPriceWithVAT) {
        this.totalPriceWithoutVAT = totalPriceWithVAT;
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

    public OrderingTable getOrderingTable() {
        return orderingTable;
    }

    public void setOrderingTable(OrderingTable orderingTable) {
        this.orderingTable = orderingTable;
    }

    public static class Builder {
        private String uuid;
        private Integer totalPrice;
        private Integer totalPriceWithoutVAT;
        private Date orderDate;
        private Set<OrderToProductRelation> orderToProductRelations;
        private OrderingTable orderingTable;

        public Builder totalPrice(Integer totalPrice) {
            this.totalPrice = totalPrice;
            return this;
        }

        public Builder orderToProductRelations(Set<OrderToProductRelation> orderToProductRelations) {
            this.orderToProductRelations = orderToProductRelations;
            return this;
        }

        public Builder orderingTable(OrderingTable orderingTable) {
            this.orderingTable = orderingTable;
            return this;
        }

        public Order build() {
            Order order = new Order();
            order.setUuid(UUID.randomUUID().toString());
            order.orderDate = new Date();
            order.totalPrice = this.totalPrice;
            order.orderingTable = this.orderingTable;
            order.orderToProductRelations = this.orderToProductRelations;
            return order;
        }
    }
}
