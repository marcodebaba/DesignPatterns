package chain.handler;

import chain.model.OrderRequest;
import chain.model.ValidationResult;
import org.springframework.core.annotation.Order;

import java.math.BigDecimal;

@CheckHandler
@Order(3)
public class RiskCheckHandler implements OrderCheckHandler {
    private static final BigDecimal RISK_THRESHOLD = new BigDecimal("10000");

    @Override
    public ValidationResult handle(OrderRequest request) {
        if (request.getAmount() != null && request.getAmount().compareTo(RISK_THRESHOLD) > 0) {
            return ValidationResult.fail("触发风控规则");
        }
        return ValidationResult.ok();
    }
}
