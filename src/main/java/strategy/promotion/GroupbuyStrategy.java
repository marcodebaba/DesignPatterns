package strategy.promotion;

import lombok.extern.slf4j.Slf4j;

/**
 * 拼团优惠
 */
@Slf4j
public class GroupbuyStrategy implements IPromotionStrategy {

    public void doPromotion() {
        log.info("拼团，满20人成团，全团享受团购价");
    }
}
