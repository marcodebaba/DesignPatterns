package observer.events.mouseevent;

import lombok.extern.slf4j.Slf4j;
import observer.events.core.Event;

/**
 * 自己写的逻辑，用于回调
 */
@Slf4j
public class MouseEventCallback {

    public void onClick(Event e) {
        log.info("===========触发鼠标单击事件==========\n{}", e);
    }

    public void onDoubleClick(Event e) {
        log.info("===========触发鼠标双击事件==========\n{}", e);
    }

    public void onUp(Event e) {
        log.info("===========触发鼠标弹起事件==========\n{}", e);
    }

    public void onDown(Event e) {
        log.info("===========触发鼠标按下事件==========\n{}", e);
    }

    public void onMove(Event e) {
        log.info("===========触发鼠标移动事件==========\n{}", e);
    }

    public void onWheel(Event e) {
        log.info("===========触发鼠标滚动事件==========\n{}", e);
    }

    public void onOver(Event e) {
        log.info("===========触发鼠标悬停事件==========\n{}", e);
    }

    public void onBlur(Event e) {
        log.info("===========触发鼠标失焦事件==========\n{}", e);
    }

    public void onFocus(Event e) {
        log.info("===========触发鼠标获焦事件==========\n{}", e);
    }

}
