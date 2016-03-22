package g42861.rushhour.view;

import g42861.rushhour.model.Board;
import g42861.rushhour.model.Car;
import g42861.rushhour.model.Orientation;
import g42861.rushhour.model.Position;

/**
 *
 * @author G42861
 * @group B231
 */
public class Display {

    public static void main(String[] args) {
        Board board = new Board();
        Car car1 = new Car('1', 2, Orientation.HORIZONTAL, new Position(2, 0));
        Car car2 = new Car('2', 3, Orientation.VERTICAL, new Position(2, 2));
        Car car3 = new Car('3', 3, Orientation.VERTICAL, new Position(2, 4));
        board.put(car1);
        board.put(car2);
        board.put(car3);
        displayBoard(board);
    }

    /**
     * Display the board with cars
     *
     * @param board the board to display
     */
    public static void displayBoard(Board board) {
        System.out.print(" ");
        for (int i = 0; i < board.getWidth(); i++) {
            System.out.print("_ ");
        }

        System.out.println();

        Car car;
        for (int row = 0; row < board.getHeight(); row++) {
            System.out.print("|");
            boolean showExit = false;
            for (int column = 0; column < board.getWidth(); column++) {
                car = board.getCarAt(new Position(row, column));
                if (car != null) {
                    System.out.print(car.getId() + " ");
                } else {
                    System.out.print("  ");
                }
                showExit = (row == board.getExit().getRow() && column == board.getExit().getColumn());

            }
            if (showExit)
                System.out.println("X");
            else
                System.out.println("|");
        }
        System.out.print(" ");
        for (int i = 0; i < board.getWidth(); i++) {
            System.out.print("_ ");
        }
        System.out.println();
    }
}
