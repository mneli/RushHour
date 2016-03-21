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

    public Board() {
        this(6, 6, new Position(2, 5));
    }

    public Position getExit() {
        return this.exit;
    }

    public int getHeight() {
        return this.grid.length;
    }

    public int getWidth() {
        return this.grid[0].length;
    }

    public Car getCarAt(Position pos) {
        return this.grid[pos.getRow()][pos.getColumn()];
    }

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
 */
