package adapterMode.adapter;

import adapterMode.PassportService;
import adapterMode.RegisterChannel;
import adapterMode.ResultMsg;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class RegisterForWeChatAdapter extends AbstractRegisterAdapter {

    public RegisterForWeChatAdapter(PassportService passportService) {
        super(passportService, RegisterChannel.WECHAT);
    }

    @Override
    public ResultMsg register(String id) {
        // 模拟调用微信 API，用 openId 生成内部密码
        String password = generatePassword("WX", id);
        log.info("WeChat Register logic: {}", id);
        return passportService.register(id, password, RegisterChannel.WECHAT);
    }
}
