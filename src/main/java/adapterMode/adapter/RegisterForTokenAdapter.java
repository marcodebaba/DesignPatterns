package adapterMode.adapter;

import adapterMode.PassportService;
import adapterMode.RegisterChannel;
import adapterMode.ResultMsg;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class RegisterForTokenAdapter extends AbstractRegisterAdapter {

    public RegisterForTokenAdapter(PassportService passportService) {
        super(passportService, RegisterChannel.TOKEN);
    }

    @Override
    public ResultMsg register(String id) {
        // 模拟解析 Token，提取用户信息后注册
        String username = "TOKEN_USER_" + id;
        String password = generatePassword("TK", id);
        log.info("Token Register logic: {}", id);
        return passportService.register(username, password, RegisterChannel.TOKEN);
    }
}
