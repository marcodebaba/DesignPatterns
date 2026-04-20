package chain.service;

import chain.handler.OrderCheckHandler;
import chain.model.OrderRequest;
import chain.model.ValidationResult;
import org.springframework.core.annotation.AnnotationAwareOrderComparator;

import java.util.ArrayList;
import java.util.List;

public class OrderCheckChain {

    private final List<OrderCheckHandler> handlers;

    public OrderCheckChain(List<OrderCheckHandler> handlers) {
        this.handlers = new ArrayList<OrderCheckHandler>(handlers);
        AnnotationAwareOrderComparator.sort(this.handlers);
    }

    public ValidationResult execute(OrderRequest request) {
        for (OrderCheckHandler handler : handlers) {
            ValidationResult result = handler.handle(request);
            if (!result.isPass()) {
                return result;
            }
        }
        return ValidationResult.ok();
    }
}
