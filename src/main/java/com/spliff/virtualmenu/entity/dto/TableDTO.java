package com.spliff.virtualmenu.entity.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.spliff.virtualmenu.entity.Restaurant;

@JsonIgnoreProperties(ignoreUnknown = true)
public class TableDTO {
    public Integer id;
    public Integer tableNumber;
    public Integer seats;
    public Restaurant restaurant;
}
