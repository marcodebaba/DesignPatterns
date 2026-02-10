package bridgeMode.payMode;

import lombok.extern.slf4j.Slf4j;

/**
 * @author：marco.pan
 * @ClassName：PayByFinger
 * @Description：指纹支付
 * @date: 2026年02月10日 13:46
 */
@Slf4j
public class PayByFinger implements IPayMode {
    @Override
    public boolean security(String uId) {
        log.info("指纹支付，风控校验指纹 ");
        return true;
    }
}
