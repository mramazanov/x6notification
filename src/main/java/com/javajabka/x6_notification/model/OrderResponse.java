package com.javajabka.x6_notification.model;

import lombok.Data;
import java.util.List;

@Data
public class OrderResponse {
    private final Long id;
    private final Long userId;
    private final List<ProductQuantity> products;
}