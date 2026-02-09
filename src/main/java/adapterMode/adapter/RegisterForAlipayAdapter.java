package adapterMode.adapter;

import adapterMode.PassportService;
import adapterMode.ResultMsg;

/**
 * @author：marco.pan
 * @ClassName：RegisterForAlipayAdapter
 * @Description：
 * @date: 2026年02月09日 13:06
 */
public class RegisterForAlipayAdapter implements IRegisterAdapter {

    private final PassportService passportService;

    public RegisterForAlipayAdapter(PassportService passportService) {
        this.passportService = passportService;
    }

    @Override
    public boolean support(String channel) {
        return "Alipay".equalsIgnoreCase(channel);
    }

    @Override
    public ResultMsg register(String id) {
        // 模拟调用 QQ 开放平台 API，用 openId 生成内部密码
        String password = "Alipay@" + id.hashCode();
        return passportService.register(id, password, "Alipay");
    }
}
