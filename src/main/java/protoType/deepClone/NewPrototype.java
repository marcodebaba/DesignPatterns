package protoType.deepClone;

import lombok.extern.slf4j.Slf4j;

/**
 * Created by marcopan on 17/10/20.
 */
@Slf4j
public class NewPrototype implements Cloneable {
    private String id;
    private Prototype prototype;

    public static void main(String[] args) {
        Prototype pro = new Prototype();
        pro.setName("original object");

        NewPrototype newObj = new NewPrototype();
        newObj.setId("test1");
        newObj.setPrototype(pro);

        NewPrototype clonObj = (NewPrototype) newObj.clone();
        clonObj.setId("testClone");
        clonObj.getPrototype().setName("changed object");

        log.info("original object id:{}", newObj.getId());
        log.info("original object name:{}", newObj.getPrototype().getName());

        log.info("cloned object id:{}", clonObj.getId());
        log.info("cloned object name:{}", clonObj.getPrototype().getName());
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Prototype getPrototype() {
        return prototype;
    }

    public void setPrototype(Prototype prototype) {
        this.prototype = prototype;
    }

    public Object clone() {
        try {
            NewPrototype ret = (NewPrototype) super.clone();
            ret.prototype = (Prototype) this.prototype.clone();
            return ret;
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
            return null;
        }
    }
}
