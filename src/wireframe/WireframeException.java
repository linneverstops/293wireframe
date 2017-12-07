package wireframe;

/**
 * Class WireframeException
 *
 * Represents an exception when there is an error in wireframe operations
 * @author TungHo Lin
 * @see java.lang.Exception
 */
class WireframeException extends Exception {

    /**
     * The String error message
     */
    private String message;

    /**
     * Constructor of Class WireframeException
     * @param message The String error message
     */
    WireframeException(String message) {
        this.message = message;
    }

    /**
     * Return the String of the WireframeException
     * @return the String of the WireframeException
     */
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("WireframeException: ");
        builder.append(this.message);
        return builder.toString();
    }

}
