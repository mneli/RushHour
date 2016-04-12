package g42861.rushhour.view;

import g42861.rushhour.model.Direction;

/**
 * Class Keyboard, Used to interact with the user via the keyboard.
 *
 * @author G42861
 * @group B231
 */
public class Keyboard {

    /**
     * Capture the first character from the sequence of character typed by the
     * user when asked
     *
     * @param msg The message to display in case of invalid input
     * @return the first character in uppercase
     */
    public static char scanChar(String msg) {
        java.util.Scanner scanner = new java.util.Scanner(System.in);
        while (!scanner.hasNext()) {
            System.out.print(msg);
            scanner.next();
        }
        return scanner.next().toUpperCase().charAt(0);
    }

    /*
    public static String scanWord() {
        java.util.Scanner scanner = new java.util.Scanner(System.in);
        while (!scanner.hasNext()) {
            scanner.next();
        }
        return scanner.next();
    }
     */
    /**
     * Capture the first letter of the direction the car should be moved.
     *
     * @param msg the message to display in case of invalid direction
     * @return the direction
     */
    public static Direction scanDirection(String msg) {
        char firstLetter = scanChar(msg);
        while (firstLetter != 'U'
                && firstLetter != 'D'
                && firstLetter != 'L'
                && firstLetter != 'R') {
            System.out.print(msg);
            firstLetter = scanChar(msg);
        }

        Direction direction = null;
        switch (firstLetter) {
            case 'U':
                direction = Direction.UP;
                break;
            case 'D':
                direction = Direction.DOWN;
                break;
            case 'L':
                direction = Direction.LEFT;
                break;
            case 'R':
                direction = Direction.RIGHT;
        }
        return direction;
    }
}
