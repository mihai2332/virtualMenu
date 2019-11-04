package com.spliff.virtualmenu.entity.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ProductDTO {
    public String name;
    public String description;
    public Integer price;
    public Integer category;
    public Integer id;
}
