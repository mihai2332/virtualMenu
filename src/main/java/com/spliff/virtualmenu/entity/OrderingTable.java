package com.spliff.virtualmenu.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Set;

@Entity
@javax.persistence.Table(name = "ORDERING_TABLE")
public class OrderingTable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "number")
    private Integer number;

    @Column(name = "reserved")
    private Boolean reserved;

    @ManyToOne
    @JoinColumn(name = "RESTAURANT_ID")
    @JsonIgnore
    private Restaurant restaurant;

    @OneToMany(mappedBy = "orderingTable", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    private Set<Order> orders;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Boolean getReserved() {
        return reserved;
    }

    public void setReserved(Boolean reserved) {
        this.reserved = reserved;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    public Set<Order> getOrders() {
        return orders;
    }

    public void setOrders(Set<Order> orders) {
        this.orders = orders;
    }
}
