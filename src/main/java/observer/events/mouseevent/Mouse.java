package observer.events.mouseevent;

import lombok.extern.slf4j.Slf4j;
import observer.events.core.EventLisenter;

@Slf4j
public class Mouse extends EventLisenter {

    public void click() {
        log.info("调用单击方法");
        this.trigger(MouseEventType.ON_CLICK);
    }

    public void doubleClick() {
        log.info("调用双击方法");
        this.trigger(MouseEventType.ON_DOUBLE_CLICK);
    }

    public void up() {
        log.info("调用弹起方法");
        this.trigger(MouseEventType.ON_UP);
    }

    public void down() {
        log.info("调用按下方法");
        this.trigger(MouseEventType.ON_DOWN);
    }

    public void move() {
        log.info("调用移动方法");
        this.trigger(MouseEventType.ON_MOVE);
    }

    public void wheel() {
        log.info("调用滚动方法");
        this.trigger(MouseEventType.ON_WHEEL);
    }

    public void over() {
        log.info("调用悬停方法");
        this.trigger(MouseEventType.ON_OVER);
    }

    public void blur() {
        log.info("调用获焦方法");
        this.trigger(MouseEventType.ON_BLUR);
    }

    public void focus() {
        log.info("调用失焦方法");
        this.trigger(MouseEventType.ON_FOCUS);
    }
}
