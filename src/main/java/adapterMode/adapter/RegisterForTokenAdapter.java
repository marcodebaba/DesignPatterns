package adapterMode.adapter;

import adapterMode.PassportService;
import adapterMode.ResultMsg;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class RegisterForTokenAdapter implements IRegisterAdapter {

    private final PassportService passportService;

    public RegisterForTokenAdapter(PassportService passportService) {
        this.passportService = passportService;
    }

    @Override
    public boolean isSupport(String channel) {
        return "Token".equalsIgnoreCase(channel);
    }

    @Override
    public ResultMsg register(String id) {
        // 模拟解析 Token，提取用户信息后注册
        String username = "TOKEN_USER_" + id;
        String password = "TK@" + id.hashCode();
        log.info("Token Register logic: {}", id);
        return passportService.register(username, password, "Token");
    }
}
