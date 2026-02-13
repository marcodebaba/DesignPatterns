package strategy.promotion;

import lombok.extern.slf4j.Slf4j;

/**
 * 返现活动
 */
@Slf4j
public class CashbackStrategy implements IPromotionStrategy {

    public void doPromotion() {
        log.info("返现促销,返回的金额转到支付宝账号");
    }
}
