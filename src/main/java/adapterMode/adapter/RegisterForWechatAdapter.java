package adapterMode.adapter;

import adapterMode.PassportService;
import adapterMode.ResultMsg;

public class RegisterForWechatAdapter implements IRegisterAdapter {

    private final PassportService passportService;

    public RegisterForWechatAdapter(PassportService passportService) {
        this.passportService = passportService;
    }

    @Override
    public boolean support(String channel) {
        return "WeChat".equalsIgnoreCase(channel);
    }

    @Override
    public ResultMsg register(String id) {
        // 模拟调用微信 API，用 openId 生成内部密码
        String password = "WX@" + id.hashCode();
        return passportService.register(id, password, "WeChat");
    }
}
