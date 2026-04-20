package chain.service;

import chain.handler.OrderCheckHandler;
import chain.model.OrderRequest;
import chain.model.ValidationResult;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class OrderCheckChain {

    private final List<OrderCheckHandler> checkHandlers;

    public OrderCheckChain(List<OrderCheckHandler> handlers) {
        Objects.requireNonNull(handlers, "handlers不能为空");
        this.checkHandlers = Collections.unmodifiableList(handlers);
    }

    public ValidationResult execute(OrderRequest request) {
        assert request != null : "request不能为空";

        for (OrderCheckHandler handler : checkHandlers) {
            ValidationResult result = handler.handle(request);
            if (!result.isPass()) {
                return result;
            }
        }
        return ValidationResult.ok();
    }
}
