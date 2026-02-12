package compose;

import lombok.Data;

/**
 * @author：marco.pan
 * @ClassName：OrganizationComponent
 * @Description：
 * @date: 2026年02月10日 15:54
 */
@Data
public abstract class AbstractOrganizationComponent {
    private String name;
    private String description;

    protected void add(AbstractOrganizationComponent component) {
        //默认实现
        throw new UnsupportedOperationException();
    }

    protected void remove(AbstractOrganizationComponent component) {
        //默认实现
        throw new UnsupportedOperationException();
    }

    //构造器
    public AbstractOrganizationComponent(String name, String description) {
        this.name = name;
        this.description = description;
    }

    //方法print, 做成抽象的, 子类都需要实现
    protected abstract void print();
}
