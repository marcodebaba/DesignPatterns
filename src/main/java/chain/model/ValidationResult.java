package chain.model;

public class ValidationResult {
    private final boolean pass;
    private final String message;

    private ValidationResult(boolean pass, String message) {
        this.pass = pass;
        this.message = message;
    }

    public static ValidationResult ok() {
        return new ValidationResult(true, "OK");
    }

    public static ValidationResult fail(String msg) {
        return new ValidationResult(false, msg);
    }

    public boolean isPass() {
        return pass;
    }

    public String getMessage() {
        return message;
    }
}
