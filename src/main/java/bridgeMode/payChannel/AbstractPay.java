package bridgeMode.payChannel;

import bridgeMode.payMode.IPayMode;

import java.math.BigDecimal;

/**
 * @author：marco.pan
 * @ClassName：Pay
 * @Description：
 * @date: 2026年02月10日 13:40
 */
public abstract class AbstractPay {
    protected IPayMode payMode;

    public AbstractPay(IPayMode payMode) {
        this.payMode = payMode;
    }

    public abstract String transfer(String uId, String tradeId, BigDecimal
            amount);
}
