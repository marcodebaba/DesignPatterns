package builder;

/**
 * @author：marco.pan
 * @ClassName：ComputerBuilder
 * @Description：构造非必须属性
 * @date: 2026年02月06日 15:13
 */
public abstract class ComputerBuilder {
    public abstract void setUsbCount();

    public abstract void setKeyboard();

    public abstract void setDisplay();

    public abstract Computer getComputer();
}
