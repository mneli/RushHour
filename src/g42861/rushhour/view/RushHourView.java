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
            //demander id
            char id = scanChar("Enter car id : ");
            //demander direction
            Direction direction = scanDirection("Enter direction");
            //deplacer car
            this.game.move(id, direction);
            //afficher plateau
            Display.displayBoard(this.game.getBoard());
        }
        
    }

    /**
     * Lit des caractères au clavier
     *
     * @return le premier caractère lu
     */
    public static char scanChar(String msg) {
        Scanner scanner = new Scanner(System.in);
        while (!scanner.hasNext()) {
            System.out.print(msg);
            scanner.next();
        }
        return scanner.next().charAt(0);
    }

    /**
     * Lit des caractères au clavier
     *
     * @return le premier caractère lu
     */
    public Direction scanDirection(String msg) {
        Scanner scanner = new Scanner(System.in);
        while (!scanner.hasNext()
                && !scanner.next().toUpperCase().equals("UP")
                && !scanner.next().toUpperCase().equals("DOWN")
                && !scanner.next().toUpperCase().equals("LEFT")
                && !scanner.next().toUpperCase().equals("RIGHT")) {
            System.out.print(msg);
            scanner.next();
        }
        Direction direction = null;
        switch (scanner.next().toUpperCase()) {
            case "UP":
                direction = Direction.UP;
                break;
            case "DOWN":
                direction = Direction.DOWN;
                break;
            case "LEFT":
                direction = Direction.LEFT;
                break;
            case "RIGHT":
                direction = Direction.RIGHT;
        }
        return direction;
    }
}
