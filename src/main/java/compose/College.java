package compose;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

/**
 * @author：marco.pan
 * @ClassName：College
 * @Description：
 * @date: 2026年02月10日 15:58
 */
@Slf4j
public class College extends AbstractOrganizationComponent {
    //List 中 存放的Department
    List<AbstractOrganizationComponent> organizationComponents = new ArrayList<AbstractOrganizationComponent>();

    // 构造器
    public College(String name, String description) {
        super(name, description);
    }

    // 重写add
    @Override
    protected void add(AbstractOrganizationComponent organizationComponent) {
        //  将来实际业务中，College 的 add 和 University add 不一定完全一样
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
        //System.out.println("--------------" + getName() + "--------------");
        log.info("--------------{}--------------", this.getName());
        //遍历 organizationComponents
        for (AbstractOrganizationComponent organizationComponent : organizationComponents) {
            organizationComponent.print();
        }
    }
}
