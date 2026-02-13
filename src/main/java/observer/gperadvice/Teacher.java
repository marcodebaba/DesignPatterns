package observer.gperadvice;

import lombok.extern.slf4j.Slf4j;

import java.util.Observable;
import java.util.Observer;

/**
 * 观察者
 */
@Slf4j
public class Teacher implements Observer {
    private String name;

    public Teacher(String name) {
        this.name = name;
    }

    public void update(Observable o, Object arg) {
        GPer gper = (GPer) o;
        Question question = (Question) arg;
        log.info("===============================");
        log.info("{}老师，你好！\n您收到了一个来自{}的提问，希望您解答，问题内容如下：\n{}\n提问者：{}",
                name, gper.getName(), question.getContent(), question.getUserName());
    }
}
