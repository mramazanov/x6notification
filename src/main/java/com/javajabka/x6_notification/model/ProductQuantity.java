package com.javajabka.x6_notification.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ProductQuantity {
    private final Long productId;
    private final Long quantity;
}