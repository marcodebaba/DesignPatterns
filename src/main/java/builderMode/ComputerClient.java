package builderMode;

import lombok.extern.slf4j.Slf4j;

/**
 * @author：marco.pan
 * @ClassName：ComputerClient
 * @Description：
 * @date: 2026年02月06日 15:15
 */
@Slf4j
public class ComputerClient {
    public static void main(String[] args) {
        Computer macComputer = new Computer.Builder("Mac处理器", "三星125")
                .usbCount(4)
                .display("Mac 显示器")
                .keyboard("Mac 键盘")
                .build();
        log.info("Mac computer:{}", macComputer);

        Computer lenovoComputer = new Computer.Builder("I7处理器", "海力士222")
                .usbCount(2)
                .keyboard("Lenovo 键盘")
                .build();
        log.info("Lenovo computer:{}", lenovoComputer);
    }
}
