package observer.newspaper;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SubHuman implements ISubScribe {

    //订阅者的名字
    private String subScribeName;

    public SubHuman(String subScribeName) {
        this.subScribeName = subScribeName;
    }

    @Override
    public void getNewsPaper() {
        log.info("{}!! 有新的报纸了，请查收！", subScribeName);
    }
}
