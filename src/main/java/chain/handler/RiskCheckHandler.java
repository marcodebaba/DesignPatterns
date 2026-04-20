package chain.handler;

import chain.model.OrderRequest;
import chain.model.ValidationResult;
import org.springframework.core.annotation.Order;

@Order(3)
public class RiskCheckHandler implements OrderCheckHandler {
    @Override
    public ValidationResult handle(OrderRequest request) {
        if (request.getAmount() != null && request.getAmount() > 10000) {
            return ValidationResult.fail("触发风控规则");
        }
        return ValidationResult.ok();
    }
}
