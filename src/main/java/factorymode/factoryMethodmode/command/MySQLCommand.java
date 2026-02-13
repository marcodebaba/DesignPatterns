package factorymode.factoryMethodmode.command;

import lombok.extern.slf4j.Slf4j;

/**
 * @author：marco.pan
 * @ClassName：MySQLCommand
 * @Description：
 * @date: 2026年02月05日 13:17
 */
@Slf4j
public class MySQLCommand implements ICommand {
    private String result;

    @Override
    public void execute(String command) {
        this.result = "MySQL执行命令: " + command;
        log.info("{}", result);
    }

    @Override
    public String getResult() {
        return result;
    }
}
