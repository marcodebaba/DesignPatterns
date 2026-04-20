package chain.handler;

import chain.model.OrderRequest;
import chain.model.ValidationResult;

public interface OrderCheckHandler {
    ValidationResult handle(OrderRequest request);
}
