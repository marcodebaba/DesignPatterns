package bridgeMode.payMode;

import lombok.extern.slf4j.Slf4j;

/**
 * Author：marco.pan
 * ClassName：PayCypher
 * Description：密码支付
 * Date: 2026年02月10日 13:45
 */
@Slf4j
public class PayByCypher implements IPayMode {
    @Override
    public boolean security(String uId) {
        log.info("密码支付，风控校验密码 ");
        return true;
    }
}
