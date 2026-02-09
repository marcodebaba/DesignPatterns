package builderMode;

import lombok.*;

/**
 * @author：marco.pan
 * @ClassName：Computer
 * @Description：
 * @date: 2026年02月06日 15:13
 */
@Data
@NoArgsConstructor
public class Computer {
    private String cpu;//必须
    private String ram;//必须
    private int usbCount;//可选
    private String keyboard;//可选
    private String display;//可选

    /**
     * 把变量分成两类，一类是必须的，还有一类是非必须的（也就是需要通过builder来构造的）
     * @param cpu
     * @param ram
     */
    public Computer(String cpu, String ram) {
        this.cpu = cpu;
        this.ram = ram;
    }
}
