package chain.service;

import chain.handler.OrderCheckHandler;
import chain.model.OrderRequest;
import chain.model.ValidationResult;
import org.springframework.core.annotation.AnnotationAwareOrderComparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class OrderCheckChain {

    private final List<OrderCheckHandler> checkHandlers;

    public OrderCheckChain(List<OrderCheckHandler> handlers) {
        Objects.requireNonNull(handlers, "handlers不能为空");
        List<OrderCheckHandler> sortedHandlers = new ArrayList<OrderCheckHandler>(handlers);
        AnnotationAwareOrderComparator.sort(sortedHandlers);
        this.checkHandlers = Collections.unmodifiableList(sortedHandlers);
    }

    public ValidationResult execute(OrderRequest request) {
        if (request == null) {
            return ValidationResult.fail("request不能为空");
        }
        for (OrderCheckHandler handler : checkHandlers) {
            ValidationResult result = handler.handle(request);
            if (!result.isPass()) {
                return result;
            }
        }
        return ValidationResult.ok();
    }
}
