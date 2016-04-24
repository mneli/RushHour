package g42861.rushhour.view;

import g42861.rushhour.model.Direction;

/**
 * Class Keyboard, Used to interact with the user via the keyboard.
 *
 * @author G42861
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
        System.out.print(msg);
        while (!scanner.hasNext()) {
            System.out.print(msg);
            scanner.next();
        }
        return scanner.next().toUpperCase().charAt(0);
    }

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

    /**
     * Capture an integer from the sequence of character typed by the user. Ask
     * to input a number while the input is different then an integer
     *
     * @return an integer
     */
    public static int scanInt() {
        java.util.Scanner scanner = new java.util.Scanner(System.in);
        while (!scanner.hasNextInt()) {
            System.out.println("Please enter a number:");
            scanner.next();
        }
        return scanner.nextInt();
    }

    /**
     * Display a valid choice of keyboard entry and capture an integer. If the
     * entry is not in the valid range, display the valid range and wait for
     * keyboard entry
     *
     * @param levels the upper range
     * @return the chosen level number minus 1
     */
    public static int scanLevel(int levels) {

        for (int level = 1; level <= levels; level++) {
            System.out.println(level);
        }
        int levelNumber = scanInt();
        while (levelNumber < 1 || levelNumber > levels) {
            System.out.println("The level number must be between 1 and " + levels);
            levelNumber = scanInt();
        }
        return levelNumber - 1;
    }
}
