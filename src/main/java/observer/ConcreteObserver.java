package observer;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ConcreteObserver implements Observer {
    private String observerState;

    @Override
    public void update(String state) {
        observerState = state;
        log.info("״̬Ϊ��{}", observerState);
    }
}
