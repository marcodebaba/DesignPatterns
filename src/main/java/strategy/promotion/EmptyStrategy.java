package strategy.promotion;

import lombok.extern.slf4j.Slf4j;

/**
 * 无优惠
 */
@Slf4j
public class EmptyStrategy implements IPromotionStrategy {
    public void doPromotion() {
        log.info("无促销活动");
    }
}
