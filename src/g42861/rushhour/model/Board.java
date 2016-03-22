package g42861.rushhour.model;

import java.util.List;

/**
 *
 * @author G42861
 * @group B231
 */
public class Board {

    private Car[][] grid;
    private Position exit;

    /**
     * Construct an instance of Board.
     *
     * @param height the number of rows of the board
     * @param width the number of columns of the board
     * @param exit the position of the exit
     */
    public Board(int height, int width, Position exit) {
        if (height <= 0)
            throw new IllegalArgumentException("Invalid height");
        if (width <= 0)
            throw new IllegalArgumentException("Invalid width");
        if ((exit.getRow() <= 0 || exit.getRow() >= height - 1)
                && (exit.getColumn() != width - 1))
            throw new IllegalArgumentException("Invalid exit position");

        this.grid = new Car[height][width];
        this.exit = exit;
    }

    /**
     * Construct an instance of Board with default values. The default values
     * are :
     * <li>height : 6</li>
     * <li>width : 6</li>
     * <li>exit at Position (2,5)</li>
     */
    public Board() {
        this(6, 6, new Position(2, 5));
    }

    /**
     * Get the exit of an instance of Board.
     *
     * @return the position of the exit
     */
    public Position getExit() {
        return this.exit;
    }

    /**
     * Get the height(number of rows) of a board.
     *
     * @return the height
     */
    public int getHeight() {
        return this.grid.length;
    }

    /**
     * Get the width(number of columns) of a board.
     *
     * @return the width
     */
    public int getWidth() {
        return this.grid[0].length;
    }

    /**
     * Get the car at the position received in parameter.
     *
     * @param pos the position to check
     * @return a car or null if the position received in parameter doesn't
     * contains a car
     */
    public Car getCarAt(Position pos) {
        return this.grid[pos.getRow()][pos.getColumn()];
    }

    /**
     * Verify if a car can be placed on board.
     * <li>Check if every position that the car received in parameter want to
     * occupy on board doesn't contain already an another car</li>
     * <li>Check if every position that the car received in parameter want to
     * occupy on board are on board and not outside</li>
     *
     * @param car the instance of Car
     * @return true if the car can be placed
     */
    public boolean canPut(Car car) {
        List<Position> listPos = car.getPositions();
        int counter = 0;
        while (counter < listPos.size()
                && getCarAt(listPos.get(counter)) == null
                && listPos.get(counter).getRow() >= getHeight()
                && listPos.get(counter).getColumn() >= getWidth()) {
            counter++;
        }
        return counter == listPos.size();
    }

    /**
     * Place a car on board.
     *
     * @param car the instance of Car to place on board
     */
    public void put(Car car) {
        List<Position> listPos = car.getPositions();
        for (Position pos : listPos) {
            this.grid[pos.getRow()][pos.getColumn()] = car;
        }
    }

    //todo
    public Car getCar(char id) {
        return null;
    }

    //todo
    public void remove(Car car) {
    }

    //todo
    public boolean canMove(Car car, Direction direction) {
        return false;
    }
}
/*
    @issues
    condition can put method too long
    warning for each put
    redéfinir la méthode equals?
 */
