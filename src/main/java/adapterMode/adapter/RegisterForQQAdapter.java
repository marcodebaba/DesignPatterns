package adapterMode.adapter;

import adapterMode.PassportService;
import adapterMode.RegisterChannel;
import adapterMode.ResultMsg;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class RegisterForQQAdapter extends AbstractRegisterAdapter {

    public RegisterForQQAdapter(PassportService passportService) {
        super(passportService, RegisterChannel.QQ);
    }

    @Override
    public ResultMsg register(String id) {
        // 模拟调用 QQ 开放平台 API，用 openId 生成内部密码
        String password = generatePassword("QQ", id);
        log.info("QQ Register logic: {}", id);
        return passportService.register(id, password, RegisterChannel.QQ);
    }
}
