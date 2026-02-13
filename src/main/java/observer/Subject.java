package observer;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public abstract class Subject {

    private List<Observer> observers = new ArrayList<>();

    public void registerObserver(Observer observer) {
        observers.add(observer);
        log.info("Attached an observer");
    }

    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    public void nodifyObservers(String newState) {
        for (Observer observer : observers) {
            observer.update(newState);
        }
    }
}
