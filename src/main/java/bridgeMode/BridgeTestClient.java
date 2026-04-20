package bridgeMode;

import bridgeMode.payChannel.AbstractPay;
import bridgeMode.payChannel.Alipay;
import bridgeMode.payChannel.WeChatPay;
import bridgeMode.payMode.PayByFace;
import bridgeMode.payMode.PayByFinger;
import lombok.extern.slf4j.Slf4j;

import java.math.BigDecimal;

/**
 * Author：marco.pan
 * ClassName：BridgeTestClient
 * Description：
 * Date: 2026年02月10日 13:56
 */
@Slf4j
public class BridgeTestClient {
    public static void main(String[] args) {
        AbstractPay weChatPay = new WeChatPay(new PayByFace());
        weChatPay.transfer("weixin_1092033111", "100000109893", new
                BigDecimal(100));

        AbstractPay alipay = new Alipay(new PayByFinger());
        alipay.transfer("jlu19dlxo111", "100000109894", new BigDecimal(1000));
    }
}
