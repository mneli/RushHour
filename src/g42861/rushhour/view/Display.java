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
        boolean exitUp = board.getExit().getRow() == 0;
        boolean exitDown = board.getExit().getRow() == board.getHeight() - 1;
        boolean exitLeft = board.getExit().getColumn() == 0;
        boolean exitRight = false;

        displayUpperLowerBorder(board, exitUp);

        for (int row = 0; row < board.getHeight(); row++) {
            //displayEmptyLine(board);

            if (exitLeft && row == board.getExit().getRow())
                System.out.print(Color.toRed("X"));
            else
                System.out.print(Color.toWhite("|"));

            for (int column = 0; column < board.getWidth(); column++) {
                exitRight = displayBoardCell(board, row, column);
            }

            if (exitRight)
                System.out.println(Color.toRed("X"));
            else
                System.out.println(Color.toWhite("|"));

            //displayEmptyLine(board);
        }
        displayUpperLowerBorder(board, exitDown);

    }

    /**
     * Display the upper or lower boarder of the board
     *
     * @param board the board
     * @param showExit used to determine if the exit should be display
     */
    private static void displayUpperLowerBorder(Board board, boolean showExit) {
        System.out.print(Color.toWhite(" "));
        for (int i = 0; i < board.getWidth(); i++) {
            if (showExit && i == board.getExit().getColumn())
                System.out.print(Color.toRed(" ") + Color.toRed("X") + Color.toRed(" "));
            else
                System.out.print(Color.toWhite("---"));
        }
        System.out.println(Color.toWhite(" "));
    }

    /**
     * Display an empty line with left border and right
     *
     * @param board the board
     */
    private static void displayEmptyLine(Board board) {
        System.out.print(Color.toMagenta("|"));
        for (int i = 0; i < board.getWidth(); i++) {
            System.out.print("   ");
        }
        System.out.println(Color.toMagenta("|"));
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
            displayColoredCell(car.getId());
        } else {
            System.out.print("   ");
        }
        return (row == board.getExit().getRow()
                && column == board.getExit().getColumn());
    }

    /**
     * Display a cell containing a car id to red if the cell contains the red
     * car or to blue, cyan, green, purple or yellow for any other car.
     *
     * @param id the id to display
     */
    private static void displayColoredCell(char id) {

        switch (id) {
            case 'R':
                System.out.print(Color.toRed(" " + id + " "));
                break;
            case '1':
            case '6':
                System.out.print(Color.toBlue(" " + id + " "));
                break;
            case '2':
            case '7':
                System.out.print(Color.toCyan(" " + id + " "));
                break;
            case '3':
            case '8':
                System.out.print(Color.toGreen(" " + id + " "));
                break;
            case '4':
            case '9':
                System.out.print(Color.toMagenta(" " + id + " "));
                break;
            case '5':
            case '0':
                System.out.print(Color.toYellow(" " + id + " "));
                break;
            default:
                System.out.print(Color.toWhite(" " + id + " "));
        }
    }
}
