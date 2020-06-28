package com.spliff.Virtualmenu.entity.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.spliff.Virtualmenu.entity.Restaurant;

@JsonIgnoreProperties(ignoreUnknown = true)
public class TableDTO {
    public Integer id;
    public Integer tableNumber;
    public Integer seats;
    public Restaurant restaurant;
}
