package factorymode.factoryMethodmode.command;

/**
 * @author：marco.pan
 * @ClassName：PostgreSQLCommand
 * @Description：
 * @date: 2026年02月05日 13:19
 */
public class PostgreSQLCommand implements ICommand {
    private String result;

    @Override
    public void execute(String command) {
        this.result = "PostgreSQL执行命令: " + command;
        System.out.println(result);
    }

    @Override
    public String getResult() {
        return result;
    }
}
