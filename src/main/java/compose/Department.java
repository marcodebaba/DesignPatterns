package compose;

import lombok.extern.slf4j.Slf4j;

/**
 * @author：marco.pan
 * @ClassName：Department
 * @Description：
 * @date: 2026年02月10日 16:00
 */
@Slf4j
public class Department extends AbstractOrganizationComponent {
    //没有集合
    public Department(String name, String description) {
        super(name, description);
    }

    @Override
    protected void add(AbstractOrganizationComponent component) {
        // add 就不用写了，因为他是叶子节点
        super.add(component);
    }

    @Override
    protected void remove(AbstractOrganizationComponent component) {
        // remove 就不用写了，因为他是叶子节点
        super.remove(component);
    }

    @Override
    public String getName() {
        return super.getName();
    }

    @Override
    public String getDescription() {
        return super.getDescription();
    }

    @Override
    protected void print() {
        //System.out.println(getName());
        log.info("{}", this.getName());
    }
}
