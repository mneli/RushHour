package g42861.rushhour.model;

/**
 * Class RushHourException, a sub class of Exception. Used to throw exception
 * controlled by the compiler.
 *
 * @author G42861
 */
public class RushHourException extends Exception {

    private static final long serialVersionUID = 1L;

    /**
     * Constructs an instance of <code>RushHourException</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public RushHourException(String msg) {
        super(msg);
    }
}
