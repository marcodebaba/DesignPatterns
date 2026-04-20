package bridgeMode.payChannel;

import bridgeMode.payMode.IPayMode;
import lombok.extern.slf4j.Slf4j;

import java.math.BigDecimal;

/**
 * Author：marco.pan
 * ClassName：Alipay
 * Description：
 * Date: 2026年02月10日 13:40
 */
@Slf4j
public class Alipay extends AbstractPay {
    public Alipay(IPayMode payMode) {
        super(payMode);
    }

    @Override
    public String transfer(String uId, String tradeId, BigDecimal amount) {
        log.info("支付宝渠道支付开始, uId: {} tradeId: {} amount: {}", uId, tradeId, amount);
        boolean security = payMode.security(uId);
        log.info("支付宝渠道风控校验, uId: {} tradeId {}: security: {}", uId, tradeId, security);
        if (!security) {
            log.info("支付宝渠道支付拦截, uId: {} tradeId: {} amount: {}", uId, tradeId, amount);
            return "0001";
        }
        log.info("支付宝渠道支付成功, uId: {} tradeId: {} amount: {}", uId, tradeId, amount);
        return "0000";
    }
}
