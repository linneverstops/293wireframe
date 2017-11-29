public class WireframeException extends Exception {

    private String message;

    WireframeException(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("WireframeException: ");
        builder.append(this.message);
        return builder.toString();
    }
}
