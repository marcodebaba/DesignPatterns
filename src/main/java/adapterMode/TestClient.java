package adapterMode;

import adapterMode.adapter.PassportForThirdAdapter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TestClient {
    public static void main(String[] args) {
        IPassportForThird adapter = new PassportForThirdAdapter();

        ResultMsg qqResult = adapter.registerByThird("QQ_OpenId_123", "QQ");
        log.info("QQ: {}", qqResult.getData());

        ResultMsg wechatResult = adapter.registerByThird("WX_OpenId_456", "WeChat");
        log.info("WeChat: {}", wechatResult.getData());

        ResultMsg tokenResult = adapter.registerByThird("my_token_789", "Token");
        log.info("Token: {}", tokenResult.getData());

        ResultMsg aliPayResult = adapter.registerByThird("aliPay_OpenId_000", "Alipay");
        log.info("Alipay: {}", aliPayResult.getData());
    }
}
