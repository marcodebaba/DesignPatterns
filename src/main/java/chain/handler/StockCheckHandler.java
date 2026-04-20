package chain.handler;

import chain.model.OrderRequest;
import chain.model.ValidationResult;
import org.springframework.core.annotation.Order;

@CheckHandler
@Order(2)
public class StockCheckHandler implements OrderCheckHandler {
    @Override
    public ValidationResult handle(OrderRequest request) {
        int mockStock = 10;
        if (request.getQuantity() > mockStock) {
            return ValidationResult.fail("库存不足");
        }
        return ValidationResult.ok();
    }
}
