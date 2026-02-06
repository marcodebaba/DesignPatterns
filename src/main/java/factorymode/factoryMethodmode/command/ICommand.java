package factorymode.factoryMethodmode.command;

public interface ICommand {
    void execute(String command);

    String getResult();
}