package adapterMode.adapter;

import adapterMode.PassportService;
import adapterMode.ResultMsg;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class RegisterForWeChatAdapter implements IRegisterAdapter {

    private final PassportService passportService;

    public RegisterForWeChatAdapter(PassportService passportService) {
        this.passportService = passportService;
    }

    @Override
    public boolean isSupport(String channel) {
        return "WeChat".equalsIgnoreCase(channel);
    }

    @Override
    public ResultMsg register(String id) {
        // 模拟调用微信 API，用 openId 生成内部密码
        String password = "WX@" + id.hashCode();
        log.info("WeChat Register logic: {}", id);
        return passportService.register(id, password, "WeChat");
    }
}
