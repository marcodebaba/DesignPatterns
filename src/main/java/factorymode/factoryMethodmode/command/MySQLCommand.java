package factorymode.factoryMethodmode.command;

/**
 * @author：marco.pan
 * @ClassName：MySQLCommand
 * @Description：
 * @date: 2026年02月05日 13:17
 */
public class MySQLCommand implements ICommand {
    private String result;

    @Override
    public void execute(String command) {
        this.result = "MySQL执行命令: " + command;
        System.out.println(result);
    }

    @Override
    public String getResult() {
        return result;
    }
}
