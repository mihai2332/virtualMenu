package com.spliff.virtualmenu.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "ORDERS")
@Getter
@Setter
@NoArgsConstructor
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
}
