package bridgeMode.payChannel;

import bridgeMode.payMode.IPayMode;
import lombok.extern.slf4j.Slf4j;

import java.math.BigDecimal;

/**
 * @author：marco.pan
 * @ClassName：WeChatPay
 * @Description：
 * @date: 2026年02月10日 13:41
 */
@Slf4j
public class WeChatPay extends AbstractPay {
    public WeChatPay(IPayMode payMode) {
        super(payMode);
    }

    @Override
    public String transfer(String uId, String tradeId, BigDecimal amount) {
        log.info("微信渠道支付开始: uId {}, tradeId: {}, amount: {}",
                uId, tradeId, amount);
        boolean security = payMode.security(uId);
        log.info("微信渠道风控校验, uId: {}, tradeId: {}, security: {} ", uId, tradeId, security);
        if (!security) {
            log.info("微信渠道支付拦截, uId: {}, tradeId: {}, amount {} ", uId, tradeId, amount);
            return "0001";
        }
        log.info("微信渠道支付成功 uId {} tradeId {} amount {}",
                uId, tradeId, amount);
        return "0000";
    }
}
