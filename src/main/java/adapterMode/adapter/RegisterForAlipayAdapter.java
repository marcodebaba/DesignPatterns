package adapterMode.adapter;

import adapterMode.PassportService;
import adapterMode.RegisterChannel;
import adapterMode.ResultMsg;
import lombok.extern.slf4j.Slf4j;

import java.util.Optional;
import java.util.Random;

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
        Optional<ResultMsg> invalid = this.validateId(id);
        if (invalid.isPresent()) {
            return invalid.get();
        }

        // 模拟调用 Alipay 开放平台 API，用 openId 生成内部密码
        String password = this.generatePassword("Alipay", id);
        log.info("Alipay Register logic, id: {}, password: {}", id, password);
        return passportService.register(id, password, RegisterChannel.ALIPAY);
    }

    @Override
    protected String generatePassword(String prefix, String id) {
        log.info("模拟调用 Alipay 开放平台 API，用 openId 生成内部密码");
        return id + new Random().nextInt(1000);
    }

    @Override
    protected Optional<ResultMsg> validateId(String id) {
        Optional<ResultMsg> base = super.validateId(id);
        if (base.isPresent()) {
            return base;
        }

        if (id.length() < 5) {
            return Optional.of(new ResultMsg(400, "id.length不能<5", null));
        }
        return Optional.empty();
    }
}
