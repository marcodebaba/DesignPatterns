package builder;

/**
 * @author：marco.pan
 * @ClassName：ComputerClient
 * @Description：
 * @date: 2026年02月06日 15:15
 */
public class ComputerClient {
    public static void main(String[] args) {
        Computer macComputer = new MacComputerBuilder("Mac处理器", "三星125")
                .setUsbCount(4)
                .setDisplay("Mac 显示器")
                .setKeyboard("Mac 键盘")
                .getComputer();
        System.out.println("mac computer:" + macComputer.toString());

        Computer lenovoComputer = new LenovoComputerBuilder("I7处理器", "海力士222")
                .setUsbCount(2)
                .setKeyboard("Lenovo 键盘")
                .getComputer();
        System.out.println("lenovo computer:" + lenovoComputer.toString());
    }
}
