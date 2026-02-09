package factorymode.factoryMethodmode.command;

/**
 * @author：marco.pan
 * @ClassName：OracleCommand
 * @Description：
 * @date: 2026年02月09日 15:44
 */
public class OracleCommand  implements ICommand {
    private String result;

    @Override
    public void execute(String command) {
        this.result = "Oracle执行命令: " + command;
        System.out.println(result);
    }

    @Override
    public String getResult() {
        return result;
    }
}
