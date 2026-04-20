package chain.handler;

import chain.model.OrderRequest;
import chain.model.ValidationResult;
import org.springframework.core.annotation.Order;

@Order(1)
public class ParamCheckHandler implements OrderCheckHandler {
    @Override
    public ValidationResult handle(OrderRequest request) {
        if (isBlank(request.getUserId())) {
            return ValidationResult.fail("userId不能为空");
        }
        if (isBlank(request.getSkuId())) {
            return ValidationResult.fail("skuId不能为空");
        }
        if (request.getQuantity() == null || request.getQuantity() <= 0) {
            return ValidationResult.fail("quantity必须大于0");
        }
        return ValidationResult.ok();
    }

    private boolean isBlank(String value) {
        return value == null || value.trim().isEmpty();
    }
}
