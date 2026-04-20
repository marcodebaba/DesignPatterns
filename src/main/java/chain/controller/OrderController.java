package chain.controller;

import chain.handler.OrderCheckHandler;
import chain.handler.ParamCheckHandler;
import chain.handler.RiskCheckHandler;
import chain.handler.StockCheckHandler;
import chain.model.OrderRequest;
import chain.model.ValidationResult;
import chain.service.OrderCheckChain;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class OrderController {

    private final OrderCheckChain orderCheckChain;

    public OrderController() {
        OrderCheckHandler param = new ParamCheckHandler();
        OrderCheckHandler stock = new StockCheckHandler();
        OrderCheckHandler risk = new RiskCheckHandler();
        this.orderCheckChain = new OrderCheckChain(Arrays.asList(param, stock, risk));
    }

    public Map<String, Object> createOrder(OrderRequest request) {
        ValidationResult result = orderCheckChain.execute(request);
        Map<String, Object> resp = new HashMap<String, Object>();

        if (!result.isPass()) {
            resp.put("success", false);
            resp.put("message", result.getMessage());
            return resp;
        }

        resp.put("success", true);
        resp.put("orderId", UUID.randomUUID().toString());
        resp.put("message", "下单成功");
        return resp;
    }
}
