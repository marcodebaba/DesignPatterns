package builderMode;

/**
 * @author：marco.pan
 * @ClassName：ComputerBuilder
 * @Description：构造非必须属性
 * @date: 2026年02月06日 15:13
 */
public abstract class ComputerBuilder {
    public abstract ComputerBuilder setUsbCount(int usbCount);

    public abstract ComputerBuilder setKeyboard(String keyboard);

    public abstract ComputerBuilder setDisplay(String display);

    public abstract Computer getComputer();
}
