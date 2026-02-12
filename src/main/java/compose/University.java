package compose;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

/**
 * @author：marco.pan
 * @ClassName：University
 * @Description：
 * @date: 2026年02月10日 15:56
 */
@Slf4j
public class University extends AbstractOrganizationComponent {

    List<AbstractOrganizationComponent> organizationComponents = new ArrayList<>();

    // 构造器
    public University(String name, String description) {
        super(name, description);
    }

    // 重写add
    @Override
    protected void add(AbstractOrganizationComponent organizationComponent) {
        organizationComponents.add(organizationComponent);
    }

    // 重写remove
    @Override
    protected void remove(AbstractOrganizationComponent organizationComponent) {
        organizationComponents.remove(organizationComponent);
    }

    @Override
    public String getName() {
        return super.getName();
    }

    @Override
    public String getDescription() {
        return super.getDescription();
    }

    // print方法，就是输出University 包含的学院
    @Override
    protected void print() {
        log.info("{}", this.getName());
        for (AbstractOrganizationComponent organizationComponent : organizationComponents) {
            organizationComponent.print();
        }
    }
}
