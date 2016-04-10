package g42861.rushhour.view;

import g42861.rushhour.model.Direction;
import g42861.rushhour.model.RushHourException;
import g42861.rushhour.model.RushHourGame;
import java.util.Scanner;

/**
 *
 * @author G42861
 * @group B231
 */
public class RushHourView {

    private RushHourGame game;

    public RushHourView(RushHourGame game) {
        this.game = game;
    }

    public void play() throws RushHourException {
        System.out.println("Game start");
        Display.displayBoard(this.game.getBoard());
        while (!game.isOver()) {
            boolean invalidEntry = true;

            while (invalidEntry) {
                try {
                    System.out.print("Choose the car to move : ");
                    char id = scanChar("Enter car id : ");
                    System.out.print("Choose the direction to move : ");
                    Direction direction = scanDirection("Choose between left, right, up or down : ");

                    this.game.move(id, direction);
                    invalidEntry = false;

                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }

            //afficher plateau
            Display.displayBoard(this.game.getBoard());
        }

    }

    public static char scanChar(String msg) {
        Scanner scanner = new Scanner(System.in);
        while (!scanner.hasNext()) {
            System.out.print(msg);
            scanner.next();
        }
        return scanner.next().toUpperCase().charAt(0);
    }

    public static String scanWord() {
        Scanner scanner = new Scanner(System.in);
        while (!scanner.hasNext()) {
            scanner.next();
        }
        return scanner.next();
    }

    public Direction scanDirection(String msg) {
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
