package adapterMode;

import adapterMode.adapter.*;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

@Slf4j
public class TestClient {
    public static void main(String[] args) {
        PassportService passportService = new PassportService();
        IRegisterForThirdParty adapter = new RegisterForThirdPartyAdapter(Arrays.asList(
                new RegisterForQQAdapter(passportService),
                new RegisterForWeChatAdapter(passportService),
                new RegisterForTokenAdapter(passportService),
                new RegisterForAlipayAdapter(passportService)
        ));

        ResultMsg qqResult = adapter.registerByThird("QQ_OpenId_123", RegisterChannel.QQ);
        log.info("QQ: {}", qqResult.getData());

        ResultMsg weChatResult = adapter.registerByThird("WX_OpenId_456", RegisterChannel.WECHAT);
        log.info("WeChat: {}", weChatResult.getData());

        ResultMsg tokenResult = adapter.registerByThird("my_token_789", RegisterChannel.TOKEN);
        log.info("Token: {}", tokenResult.getData());

        ResultMsg aliPayResult = adapter.registerByThird("aliPay_OpenId_000", RegisterChannel.ALIPAY);
        log.info("Alipay: {}", aliPayResult.getData());
    }
}
