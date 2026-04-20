package chain.controller;

import chain.model.CreateOrderResponse;
import chain.model.OrderRequest;
import chain.model.ValidationResult;
import chain.service.OrderCheckChain;

import java.util.UUID;

public class OrderController {

    private final OrderCheckChain orderCheckChain;

    public OrderController(OrderCheckChain orderCheckChain) {
        this.orderCheckChain = orderCheckChain;
    }

    public CreateOrderResponse createOrder(OrderRequest request) {
        ValidationResult result = orderCheckChain.execute(request);
        if (!result.isPass()) {
            return CreateOrderResponse.fail(result.getMessage());
        }
        return CreateOrderResponse.success(UUID.randomUUID().toString());
    }
}
