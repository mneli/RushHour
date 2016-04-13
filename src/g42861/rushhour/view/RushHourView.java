package g42861.rushhour.view;

import g42861.rushhour.model.Direction;
import g42861.rushhour.model.RushHourGame;

/**
 * Class RushHourView. Display the game.
 *
 * @author G42861
 */
public class RushHourView {

    private final RushHourGame game;

    /**
     * Construct an instance of RushHourView.
     *
     * @param game an instance of RushHourGame
     */
    public RushHourView(RushHourGame game) {
        this.game = game;
    }

    /**
     * This method lets a player play one session of RushHourGame
     */
    public void play() {
        System.out.println("Rush Hour Game!");
        System.out.println("The red car represented by R have to reach "
                + "the exit marked with an X to finish the game.");
        Display.displayBoard(this.game.getBoard());
        while (!game.isOver()) {
            boolean invalidEntry = true;

            while (invalidEntry) {
                try {
                    System.out.print("Choose the car to move : ");
                    char id = Keyboard.scanChar("Enter car id : ");
                    System.out.print("Choose the direction to move : ");
                    Direction direction = Keyboard.scanDirection("Choose "
                            + "between left, right, up or down : ");

                    this.game.move(id, direction);
                    invalidEntry = false;

                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }
            Display.displayBoard(this.game.getBoard());
        }
        System.out.println("The red car reached the exit !");

    }

}
