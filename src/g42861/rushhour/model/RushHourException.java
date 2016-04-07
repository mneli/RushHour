package g42861.rushhour.model;

/**
 * Class RushHourException, a sub class of Exception. Used to throw exception
 * controlled by the compiler.
 *
 * @author G42861
 * @group B231
 */
public class RushHourException extends Exception {

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
