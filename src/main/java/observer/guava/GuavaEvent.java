package observer.guava;

import com.google.common.eventbus.Subscribe;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class GuavaEvent {

    @Subscribe
    public void subscribe(String str) {
        log.info("执行subscribe方法，传入的参数是：{}", str);
    }

}
