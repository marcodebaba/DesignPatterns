package decorator;

public abstract class Decorator implements BoardHandler {
    private BoardHandler handler;

    public Decorator(BoardHandler handler) {
        this.handler = handler;
    }

    @Override
    public String hangUp(String name) {
        return handler.hangUp(name);
    }
}
