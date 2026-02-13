package observer;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ConcreteSubject extends Subject {
    private String state;

    public String getState() {
        return state;
    }

    public void change(String newState) {
        state = newState;
        log.info("change state{}", state);
        this.nodifyObservers(state);
    }
}
