package chain;

import chain.controller.OrderController;
import chain.model.OrderRequest;
import chain.service.CheckHandlerScanner;
import chain.service.OrderCheckChain;

import java.math.BigDecimal;

public class ChainDemoApplication {
    public static void main(String[] args) {
        OrderController controller = new OrderController();

        OrderRequest okRequest = new OrderRequest();
        okRequest.setUserId("u1");
        okRequest.setSkuId("sku1");
        okRequest.setQuantity(2);
        okRequest.setAmount(new BigDecimal("99.0"));

        OrderRequest noStockRequest = new OrderRequest();
        noStockRequest.setUserId("u2");
        noStockRequest.setSkuId("sku2");
        noStockRequest.setQuantity(99);
        noStockRequest.setAmount(new BigDecimal("99.0"));

        System.out.println(controller.createOrder(okRequest));
        System.out.println(controller.createOrder(noStockRequest));
    }
}
