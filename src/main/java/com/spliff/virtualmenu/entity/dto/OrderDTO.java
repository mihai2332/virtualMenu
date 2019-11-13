package com.spliff.virtualmenu.entity.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class OrderDTO {
    public static class OrderedItem {
        public Integer productId;
        public Integer quantity;
    }

    public List<OrderedItem> orderedItems;
    public Integer tableId;
}
