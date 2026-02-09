package adapterMode.adapter;

import adapterMode.PassportService;
import adapterMode.ResultMsg;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class RegisterForQQAdapter implements IRegisterAdapter {

    private final PassportService passportService;

    public RegisterForQQAdapter(PassportService passportService) {
        this.passportService = passportService;
    }

    @Override
    public boolean support(String channel) {
        return "QQ".equalsIgnoreCase(channel);
    }

    @Override
    public ResultMsg register(String id) {
        // 模拟调用 QQ 开放平台 API，用 openId 生成内部密码
        String password = "QQ@" + id.hashCode();
        log.info("QQAdapter logic: {}", id);
        return passportService.register(id, password, "QQ");
    }
}
