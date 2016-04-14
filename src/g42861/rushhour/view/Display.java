package g42861.rushhour.view;

import g42861.rushhour.model.Board;
import g42861.rushhour.model.Car;
import g42861.rushhour.model.Orientation;
import g42861.rushhour.model.Position;

/**
 * Class Display. Methods of this class can be used to display the board and
 * it's content.
 *
 * @author G42861
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
     * Display the board with cars. Third version, colored version
     *
     * @param board the board to display
     */
    public static void displayBoard(Board board) {
        displayUpperLowerBorder(board);

        for (int row = 0; row < board.getHeight(); row++) {
            displayEmptyLine(board);
            System.out.print(Color.toPurple("|"));
            boolean showExit = false;

            for (int column = 0; column < board.getWidth(); column++) {
                showExit = displayBoardCell(board, row, column);
            }

            if (showExit)
                System.out.println(Color.toGreen("X"));
            else
                System.out.println(Color.toPurple("|"));

            displayEmptyLine(board);
        }
        displayUpperLowerBorder(board);

    }

    /**
     * Display the upper or lower boarder of the board
     *
     * @param board the board
     */
    private static void displayUpperLowerBorder(Board board) {
        System.out.print(" ");
        for (int i = 0; i < board.getWidth(); i++) {
            System.out.print(Color.toPurple("___"));
        }
        System.out.println();
    }

    /**
     * Display an empty line with left border and right
     *
     * @param board the board
     */
    private static void displayEmptyLine(Board board) {
        System.out.print(Color.toPurple("|"));
        for (int i = 0; i < board.getWidth(); i++) {
            System.out.print("   ");
        }
        System.out.println(Color.toPurple("|"));
    }

    /**
     * Display a cell of the board and verify if the coordinates of the position
     * received is the same as at the coordinates of the exit position
     *
     * @param board the board
     * @param row the row number of the cell
     * @param column the column number of the cell
     * @return true if the position to display is the same as the exit position
     */
    private static boolean displayBoardCell(Board board, int row, int column) {
        Car car = board.getCarAt(new Position(row, column));
        if (car != null) {
            if (car.getId() == 'R')
                System.out.print(Color.toRed(" " + car.getId() + " "));
            else
                System.out.print(Color.toCyan(" " + car.getId() + " "));
        } else {
            System.out.print("   ");
        }
        return (row == board.getExit().getRow()
                && column == board.getExit().getColumn());
    }
}
