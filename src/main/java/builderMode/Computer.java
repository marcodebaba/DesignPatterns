package builderMode;

import lombok.Getter;
import lombok.ToString;
import org.springframework.util.StringUtils;

/**
 * Author：marco.pan
 * ClassName：Computer
 * Description：
 * Date: 2026年02月06日 15:13
 */
@Getter
@ToString
public class Computer {
    private final String cpu;
    private final String ram;

    //usb接口数，可选
    private final int usbCount;
    //键盘，可选
    private final String keyboard;
    //显示器，可选
    private final String display;

    private Computer(Builder builder) {
        this(builder.cpu, builder.ram, builder.usbCount, builder.keyboard, builder.display);
    }

    /**
     * 包级别构造器，供同包的 ComputerBuilder（GoF风格）使用
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

    /**
     * 静态内部类 Builder
     */
    public static class Builder {
        // 必选参数
        private final String cpu;
        private final String ram;
        // 可选参数（给默认值）
        private int usbCount = 0;
        private String keyboard;
        private String display;

        /**
         * 必选参数通过构造器强制传入
         */
        public Builder(String cpu, String ram) {
            if (!StringUtils.hasLength(cpu)) {
                throw new IllegalArgumentException("cpu is required");
            }
            if (!StringUtils.hasLength(ram)) {
                throw new IllegalArgumentException("ram is required");
            }
            this.cpu = cpu;
            this.ram = ram;
        }

        public Builder usbCount(int usbCount) {
            this.usbCount = usbCount;
            return this;
        }

        public Builder keyboard(String keyboard) {
            this.keyboard = keyboard;
            return this;
        }

        public Builder display(String display) {
            this.display = display;
            return this;
        }

        public Computer build() {
            return new Computer(this);
        }
    }
}