package chain.controller;

import chain.handler.OrderCheckHandler;
import chain.model.CreateOrderResponse;
import chain.model.OrderRequest;
import chain.model.ValidationResult;
import chain.service.CheckHandlerScanner;
import chain.service.OrderCheckChain;

import java.util.List;
import java.util.UUID;

public class OrderController {

    private final OrderCheckChain orderCheckChain;

    public OrderController() {
        List<OrderCheckHandler> checkHandlers = CheckHandlerScanner.scan("chain.handler");
        this.orderCheckChain = new OrderCheckChain(checkHandlers);
    }

    public CreateOrderResponse createOrder(OrderRequest request) {
        ValidationResult result = orderCheckChain.execute(request);
        if (!result.isPass()) {
            return CreateOrderResponse.fail(result.getMessage());
        }
        return CreateOrderResponse.success(UUID.randomUUID().toString());
    }
}
