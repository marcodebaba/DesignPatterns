package decorator;

public class ColorFilter extends Decorator {

    public ColorFilter(BoardHandler handler) {
        super(handler);
    }

    @Override
    public String hangUp(String content) {
        String temp = super.hangUp(content);
        temp += "add color ";
        return temp;
    }
}
