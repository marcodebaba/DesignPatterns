package adapterMode.adapter;

import adapterMode.PassportService;
import adapterMode.RegisterChannel;
import adapterMode.ResultMsg;
import lombok.extern.slf4j.Slf4j;

/**
 * @author：marco.pan
 * @ClassName：RegisterForAlipayAdapter
 * @Description：RegisterForAlipayAdapter
 * @date: 2026年02月09日 13:06
 */
@Slf4j
public class RegisterForAlipayAdapter extends AbstractRegisterAdapter {

    public RegisterForAlipayAdapter(PassportService passportService) {
        super(passportService, RegisterChannel.ALIPAY);
    }

    @Override
    public ResultMsg register(String id) {
        // 模拟调用 Alipay 开放平台 API，用 openId 生成内部密码
        String password = generatePassword("Alipay", id);
        log.info("Alipay Register logic: {}", id);
        return passportService.register(id, password, RegisterChannel.ALIPAY.name());
    }
}
