package adapterMode;

import adapterMode.adapter.PassportForThirdAdapter;

public class TestClient {
    public static void main(String[] args) {
        IPassportForThird adapter = new PassportForThirdAdapter();

        ResultMsg qqResult = adapter.registerByThird("QQ_OpenId_123", "QQ");
        System.out.println("QQ: " + qqResult.getData().toString());

        ResultMsg wechatResult = adapter.registerByThird("WX_OpenId_456", "WeChat");
        System.out.println("WeChat: " + wechatResult.getData().toString());

        ResultMsg tokenResult = adapter.registerByThird("my_token_789", "Token");
        System.out.println("Token: " + tokenResult.getData().toString());

        ResultMsg aliPayResult = adapter.registerByThird("aliPay_OpenId_000", "Alipay");
        System.out.println("Alipay: " + aliPayResult.getData().toString());
    }
}
