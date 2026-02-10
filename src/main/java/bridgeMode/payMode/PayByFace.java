package bridgeMode.payMode;

import lombok.extern.slf4j.Slf4j;

/**
 * @author：marco.pan
 * @ClassName：PayByFace
 * @Description：刷脸支付
 * @date: 2026年02月10日 13:46
 */
@Slf4j
public class PayByFace implements IPayMode {
    @Override
    public boolean security(String uId) {
        log.info("人脸支付，风控校验脸部识别 ");
        return true;
    }
}
