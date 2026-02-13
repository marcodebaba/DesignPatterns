package observer.mouseListener;

import lombok.extern.slf4j.Slf4j;

/**
 * Created by marcopan on 2018/9/12.
 */
@Slf4j
public class MickyMouse implements IMouse {
    private String name;

    public MickyMouse(String name) {
        this.name = name;
    }

    @Override
    public void runAway() {
        log.info("{} run away", name);
    }
}
