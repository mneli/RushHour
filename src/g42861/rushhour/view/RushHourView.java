package g42861.rushhour.view;

import g42861.rushhour.model.Board;
import g42861.rushhour.model.Car;
import g42861.rushhour.model.Direction;
import g42861.rushhour.model.Position;
import g42861.rushhour.model.RushHourException;
import g42861.rushhour.model.RushHourGame;
import java.util.ArrayList;
import java.util.List;

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
        List<Character> listId = getListId(this.game.getBoard());
        int gameCounter = 0;
        System.out.println("The red car represented by R have to reach "
                + "the exit marked with an X to finish the game.");
        Display.displayBoard(this.game.getBoard());
        while (!game.isOver()) {
            boolean invalidEntry = true;
            while (invalidEntry) {
                try {
                    System.out.print("Choose the car to move. ");
                    char id = Keyboard.scanChar("Enter car id "
                            + "or X to abort the game: ");
                    while (!listId.contains(id)) {
                        id = Keyboard.scanChar("Invalid car id, insert an "
                                + "valid id or X to abort the game: ");
                    }

                    if (id == 'X')
                        return;

                    System.out.print("Choose the direction to move : ");
                    Direction direction = Keyboard.scanDirection("\nL for LEFT "
                            + "\nR for RIGHT \nU for UP \nD for DOWN : ");

                    this.game.move(id, direction);
                    moveAgain(id, direction);
                    invalidEntry = false;
                    gameCounter++;
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }
            Display.displayBoard(this.game.getBoard());
        }
        System.out.println("The red car reached the exit !");
        System.out.println("Number of move : " + gameCounter);
    }

    /**
     * Get a list of car id's on board
     *
     * @param board the board
     * @return the list of car id's on board
     */
    private List<Character> getListId(Board board) {
        List<Character> listId = new ArrayList<>();
        listId.add('X');
        for (int row = 0; row < board.getHeight(); row++) {
            for (int column = 0; column < board.getWidth(); column++) {
                Car car = board.getCarAt(new Position(row, column));
                if (car != null && !listId.contains(car.getId()))
                    listId.add(car.getId());
            }
        }
        return listId;
    }

    /**
     * After a move, this method offers to the player to move the same car to
     * the same direction if the move is allowed.
     *
     * @param id the car id
     * @param direction the direction to move again
     * @throws RushHourException in case of id or direction invalid
     */
    private void moveAgain(char id, Direction direction)
            throws RushHourException {
        char moveAgain = 'M';
        while (moveAgain == 'M'
                && this.game.getBoard().canMove(
                        this.game.getBoard().getCar(id), direction)) {
            Display.displayBoard(this.game.getBoard());
            moveAgain = Keyboard.scanChar("The car can be moved to " + direction
                    + " again.\nPress M to move the car to " + direction
                    + " again or any other key to move another car : ");
            if (moveAgain == 'M')
                this.game.move(id, direction);
        }
    }
}
