package builderMode;

/**
 * @author：marco.pan
 * @ClassName：ComputerBuilder
 * @Description：构造非必须属性
 * @date: 2026年02月06日 15:13
 */
public abstract class ComputerBuilder {
    private final String cpu;
    private final String ram;
    private int usbCount;
    private String keyboard;
    private String display;

    protected ComputerBuilder(String cpu, String ram) {
        this.cpu = cpu;
        this.ram = ram;
    }

    public ComputerBuilder setUsbCount(int usbCount) {
        this.usbCount = usbCount;
        return this;
    }

    public ComputerBuilder setKeyboard(String keyboard) {
        this.keyboard = keyboard;
        return this;
    }

    public ComputerBuilder setDisplay(String display) {
        this.display = display;
        return this;
    }

    public Computer build() {
        return new Computer(cpu, ram, usbCount, keyboard, display);
    }
}