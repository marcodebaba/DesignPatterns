package factorymode.factoryMethodmode.command;

import lombok.extern.slf4j.Slf4j;

/**
 * @author：marco.pan
 * @ClassName：OracleCommand
 * @Description：
 * @date: 2026年02月09日 15:44
 */
@Slf4j
public class OracleCommand  implements ICommand {
    private String result;

    @Override
    public void execute(String command) {
        this.result = "Oracle执行命令: " + command;
        log.info("{}", result);
    }

    @Override
    public String getResult() {
        return result;
    }
}
