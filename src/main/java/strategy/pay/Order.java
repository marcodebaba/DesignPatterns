package strategy.pay;

import lombok.extern.slf4j.Slf4j;
import strategy.pay.payport.PayStrategy;
import strategy.pay.payport.Payment;

@Slf4j
public class Order {
    private String uid;
    private String orderId;
    private double amount;

    public Order(String uid, String orderId, double amount) {
        this.uid = uid;
        this.orderId = orderId;
        this.amount = amount;
    }

    //完美地解决了switch的过程，不需要在代码逻辑中写switch了
    //更不需要写if    else if
    public MsgResult pay() {
        return pay(PayStrategy.DEFAULT_PAY);
    }

    public MsgResult pay(String payKey) {
        Payment payment = PayStrategy.get(payKey);
        log.info("欢迎使用{}", payment.getName());
        log.info("本次交易金额为：{}，开始扣款...", amount);
        return payment.pay(uid, amount);
    }
}
