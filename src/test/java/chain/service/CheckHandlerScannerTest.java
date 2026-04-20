package chain.service;

import chain.handler.OrderCheckHandler;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class CheckHandlerScannerTest {

    @Test
    public void shouldScanAllCheckHandlers() {
        List<OrderCheckHandler> handlers = CheckHandlerScanner.scan("chain.handler");

        Assert.assertEquals(3, handlers.size());
    }
}
