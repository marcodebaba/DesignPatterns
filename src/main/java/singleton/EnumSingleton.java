package singleton;

import lombok.extern.slf4j.Slf4j;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

@Slf4j
public enum EnumSingleton {

    INSTANCE;
    private Object data;

    public static EnumSingleton getInstance() {
        return INSTANCE;
    }

    public static void main(String[] args) {
        try {
            EnumSingleton instance1 = EnumSingleton.getInstance();
            instance1.setData(new Object());

            FileOutputStream fos = new FileOutputStream("EnumSingleton.obj");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(instance1);
            oos.flush();
            oos.close();

            FileInputStream fis = new FileInputStream("EnumSingleton.obj");
            ObjectInputStream ois = new ObjectInputStream(fis);
            EnumSingleton instance2 = (EnumSingleton) ois.readObject();
            ois.close();

            log.info("{}", instance1.getData());
            log.info("{}", instance2.getData());
            log.info("{}", instance1.getData() == instance2.getData());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
