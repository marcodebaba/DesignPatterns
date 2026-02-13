package strategy.promotion;

import lombok.extern.slf4j.Slf4j;

/**
 * 优惠券
 */
@Slf4j
public class CouponStrategy implements IPromotionStrategy {

    public void doPromotion() {
        log.info("领取优惠券,课程的价格直接减优惠券面值抵扣");
    }
}
