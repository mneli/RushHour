package g42861.rushhour.view;

/**
 * This class lets color a text
 *
 * @author MCD
 */
public class Color {

    /**
     * Default color method of the BASH .
     *
     * @return the default color.
     */
    private static String toDefault() {
        return "\033[0m";
    }

    /**
     * Color a Sting to black
     *
     * @param a the String to color.
     * @return the colored String.
     */
    public static String toBlack(String a) {
        return "\033[30m" + a + toDefault();
    }

    /**
     * Color a Sting to red.
     *
     * @param a the String to color.
     * @return the colored String.
     */
    public static String toRed(String a) {
        return "\033[31m" + a + toDefault();
    }

    /**
     * Color a Sting to green.
     *
     * @param a the String to color.
     * @return the colored String.
     */
    public static String toGreen(String a) {
        return "\033[32m" + a + toDefault();
    }

    /**
     * Color a Sting to yellow
     *
     * @param a the String to color.
     * @return the colored String.
     */
    public static String toYellow(String a) {
        return "\033[33m" + a + toDefault();
    }

    /**
     * Color a Sting to blue
     *
     * @param a the String to color.
     * @return the colored String.
     */
    public static String toBlue(String a) {
        return "\033[34m" + a + toDefault();
    }

    /**
     * Color a Sting to purple
     *
     * @param a the String to color.
     * @return the colored String.
     */
    public static String toPurple(String a) {
        return "\033[35m" + a + toDefault();
    }

    /**
     * Color a Sting to cyan
     *
     * @param a the String to color.
     * @return the colored String.
     */
    public static String toCyan(String a) {
        return "\033[36m" + a + toDefault();
    }

    /**
     * Color a Sting to white.
     *
     * @param a the String to color.
     * @return the colored String.
     */
    public static String toWhite(String a) {
        return "\033[37m" + a + toDefault();
    }

}
