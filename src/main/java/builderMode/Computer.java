package builderMode;

import lombok.*;

/**
 * @author：marco.pan
 * @ClassName：Computer
 * @Description：
 * @date: 2026年02月06日 15:13
 */
@Getter
@ToString
public class Computer {
    private final String cpu;//必须
    private final String ram;//必须
    private final int usbCount;//可选
    private final String keyboard;//可选
    private final String display;//可选

    /**
     * 把变量分成两类，一类是必须的，还有一类是非必须的（也就是需要通过builder来构造的）
     */
    Computer(String cpu, String ram, int usbCount, String keyboard, String display) {
        if (cpu == null || cpu.isEmpty()) {
            throw new IllegalArgumentException("cpu is required");
        }
        if (ram == null || ram.isEmpty()) {
            throw new IllegalArgumentException("ram is required");
        }
        this.cpu = cpu;
        this.ram = ram;
        this.usbCount = usbCount;
        this.keyboard = keyboard;
        this.display = display;
    }
}
