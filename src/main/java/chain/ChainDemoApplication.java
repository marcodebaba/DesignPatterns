package chain;

import chain.controller.OrderController;
import chain.model.OrderRequest;
import chain.service.CheckHandlerScanner;
import chain.service.OrderCheckChain;

import java.math.BigDecimal;

public class ChainDemoApplication {
    public static void main(String[] args) {
        OrderController controller = new OrderController(
                new OrderCheckChain(CheckHandlerScanner.scan("chain.handler"))
        );

        OrderRequest ok = new OrderRequest();
        ok.setUserId("u1");
        ok.setSkuId("sku1");
        ok.setQuantity(2);
        ok.setAmount(new BigDecimal("99.0"));

        OrderRequest noStock = new OrderRequest();
        noStock.setUserId("u2");
        noStock.setSkuId("sku2");
        noStock.setQuantity(99);
        noStock.setAmount(new BigDecimal("99.0"));

        System.out.println(controller.createOrder(ok));
        System.out.println(controller.createOrder(noStock));
    }
}
