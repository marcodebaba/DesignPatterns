package chain.service;

import chain.handler.OrderCheckHandler;
import chain.model.OrderRequest;
import chain.model.ValidationResult;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.core.annotation.Order;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class OrderCheckChainTest {

    @Test
    public void shouldRunHandlersByOrder() {
        List<String> execution = new ArrayList<String>();
        List<OrderCheckHandler> handlers = Arrays.asList(
                new ThirdHandler(execution),
                new FirstHandler(execution),
                new SecondHandler(execution)
        );
        OrderCheckChain chain = new OrderCheckChain(handlers);

        ValidationResult result = chain.execute(createValidRequest());

        Assert.assertTrue(result.isPass());
        Assert.assertEquals(Arrays.asList("first", "second", "third"), execution);
    }

    @Test
    public void shouldShortCircuitWhenValidationFailed() {
        List<String> execution = new ArrayList<String>();
        List<OrderCheckHandler> handlers = Arrays.asList(
                new FirstHandler(execution),
                new StopHandler(execution),
                new ThirdHandler(execution)
        );
        OrderCheckChain chain = new OrderCheckChain(handlers);

        ValidationResult result = chain.execute(createValidRequest());

        Assert.assertFalse(result.isPass());
        Assert.assertEquals("stop", result.getMessage());
        Assert.assertEquals(Arrays.asList("first", "stop"), execution);
    }

    @Test
    public void shouldFailWhenRequestIsNull() {
        OrderCheckChain chain = new OrderCheckChain(Arrays.asList(new FirstHandler(new ArrayList<String>())));

        ValidationResult result = chain.execute(null);

        Assert.assertFalse(result.isPass());
        Assert.assertEquals("request不能为空", result.getMessage());
    }

    private static OrderRequest createValidRequest() {
        OrderRequest request = new OrderRequest();
        request.setUserId("u1");
        request.setSkuId("sku1");
        request.setQuantity(1);
        return request;
    }

    @Order(1)
    private static class FirstHandler implements OrderCheckHandler {
        private final List<String> execution;

        private FirstHandler(List<String> execution) {
            this.execution = execution;
        }

        @Override
        public ValidationResult handle(OrderRequest request) {
            execution.add("first");
            return ValidationResult.ok();
        }
    }

    @Order(2)
    private static class SecondHandler implements OrderCheckHandler {
        private final List<String> execution;

        private SecondHandler(List<String> execution) {
            this.execution = execution;
        }

        @Override
        public ValidationResult handle(OrderRequest request) {
            execution.add("second");
            return ValidationResult.ok();
        }
    }

    @Order(3)
    private static class ThirdHandler implements OrderCheckHandler {
        private final List<String> execution;

        private ThirdHandler(List<String> execution) {
            this.execution = execution;
        }

        @Override
        public ValidationResult handle(OrderRequest request) {
            execution.add("third");
            return ValidationResult.ok();
        }
    }

    @Order(2)
    private static class StopHandler implements OrderCheckHandler {
        private final List<String> execution;

        private StopHandler(List<String> execution) {
            this.execution = execution;
        }

        @Override
        public ValidationResult handle(OrderRequest request) {
            execution.add("stop");
            return ValidationResult.fail("stop");
        }
    }
}
