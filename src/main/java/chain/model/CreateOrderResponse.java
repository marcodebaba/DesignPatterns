package chain.model;

public class CreateOrderResponse {
    private final boolean success;
    private final String message;
    private final String orderId;

    private CreateOrderResponse(boolean success, String message, String orderId) {
        this.success = success;
        this.message = message;
        this.orderId = orderId;
    }

    public static CreateOrderResponse fail(String message) {
        return new CreateOrderResponse(false, message, null);
    }

    public static CreateOrderResponse success(String orderId) {
        return new CreateOrderResponse(true, "下单成功", orderId);
    }

    public boolean isSuccess() {
        return success;
    }

    public String getMessage() {
        return message;
    }

    public String getOrderId() {
        return orderId;
    }

    @Override
    public String toString() {
        return "CreateOrderResponse{"
                + "success=" + success
                + ", message='" + message + '\''
                + ", orderId='" + orderId + '\''
                + '}';
    }
}
