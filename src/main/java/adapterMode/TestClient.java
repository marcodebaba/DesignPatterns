package adapterMode;

import adapterMode.adapter.RegisterForThirdPartyAdapter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TestClient {
    public static void main(String[] args) {
        IRegisterForThirdParty adapter = new RegisterForThirdPartyAdapter();

        ResultMsg qqResult = adapter.registerByThird("QQ_OpenId_123", "QQ");
        log.info("QQ: {}", qqResult.getData());

        ResultMsg weChatResult = adapter.registerByThird("WX_OpenId_456", "WeChat");
        log.info("WeChat: {}", weChatResult.getData());

        ResultMsg tokenResult = adapter.registerByThird("my_token_789", "Token");
        log.info("Token: {}", tokenResult.getData());

        ResultMsg aliPayResult = adapter.registerByThird("aliPay_OpenId_000", "Alipay");
        log.info("Alipay: {}", aliPayResult.getData());
    }
}
