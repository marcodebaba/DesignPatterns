package builderMode;

/**
 * @author：marco.pan
 * @ClassName：LenovoComputerBuilder
 * @Description：
 * @date: 2026年02月06日 15:14
 */
public class LenovoComputerBuilder extends ComputerBuilder {
    private Computer computer;

    public LenovoComputerBuilder(String cpu, String ram) {
        computer = new Computer(cpu, ram);
    }

    @Override
    public ComputerBuilder setUsbCount(int usbCount) {
        computer.setUsbCount(usbCount);
        return this;
    }

    @Override
    public ComputerBuilder setKeyboard(String keyboard) {
        computer.setKeyboard(keyboard);
        return this;
    }

    @Override
    public ComputerBuilder setDisplay(String display) {
        computer.setDisplay(display);
        return this;
    }

    @Override
    public Computer getComputer() {
        return computer;
    }
}

