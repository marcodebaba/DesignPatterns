package builder;

/**
 * @author：marco.pan
 * @ClassName：ComputerDirector
 * @Description：
 * @date: 2026年02月06日 15:15
 */
public class ComputerDirector {
    public void makeComputer(ComputerBuilder builder) {
        builder.setUsbCount();
        builder.setDisplay();
        builder.setKeyboard();
    }
}
