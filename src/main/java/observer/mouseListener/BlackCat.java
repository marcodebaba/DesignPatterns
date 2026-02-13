package observer.mouseListener;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by marcopan on 2018/9/12.
 */
@Slf4j
public class BlackCat implements ICat {

    String name;
    List<IMouse> mouseList = new ArrayList<IMouse>();

    public BlackCat(String name) {
        this.name = name;
    }

    @Override
    public void registerSubscriber(IMouse mouse) {
        mouseList.add(mouse);
    }

    @Override
    public void removeSubscriber(IMouse mouse) {
        mouseList.remove(mouse);
    }

    @Override
    public void catchMouse() {
        log.info("{} is coming!!!", this.name);
        for (IMouse mouse : mouseList) {
            mouse.runAway();
        }
    }
}
