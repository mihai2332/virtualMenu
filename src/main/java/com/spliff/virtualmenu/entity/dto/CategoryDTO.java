package com.spliff.virtualmenu.entity.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CategoryDTO {
    public Integer id;
    public String name;
    public String description;
    public String restaurantUUID;
}
