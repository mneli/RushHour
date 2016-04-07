package g42861.rushhour.model;

import java.util.List;

/**
 * Class RushHourGame. Each game rush hour is represented by an instance of this
 * class.
 *
 * @author G42861
 * @group B231
 */
public class RushHourGame {

    private Board board;
    private Car redCar;

    /**
     * Construct an instance of RushHourGame.
     *
     * @param height the number of rows of the board
     * @param width the number of columns of the board
     * @param exit the position of the exit
     * @param cars a list of cars to be placed on the board
     * @param redCar the car that have to reach the exit position
     * @throws RushHourException if the red car is not aligned to the exit
     * position.<li>If the red car's orientation is horizontal, the red car's
     * row must be the same as the row of the exit position</li><li>If the red
     * car's orientation is vertical, the red car's column must be the same as
     * the column of the exit position</li>
     *
     */
    public RushHourGame(int height, int width, Position exit,
            List<Car> cars, Car redCar) throws RushHourException {

        if ((redCar.getOrientation() == Orientation.HORIZONTAL
                && redCar.getCurrentPosition().getRow() != exit.getRow())
                || (redCar.getOrientation() == Orientation.VERTICAL
                && redCar.getCurrentPosition().getColumn() != exit.getColumn()))
            throw new RushHourException("The red car must be "
                    + "positionned on the same line as the exit");

        this.board = new Board(height, width, exit);
        this.redCar = redCar;
        for (Car car : cars) {
            if (board.canPut(car))
                board.put(car);
        }
        if (board.canPut(this.redCar))
            board.put(this.redCar);
    }

    /**
     * Get the board
     *
     * @return the board
     */
    public Board getBoard() {
        return this.board;
    }

    /**
     * Move a car to the direction mentioned in parameter.
     *
     * @param id the identity of the car to move
     * @param direction the direction the car have to move
     * @throws RushHourException
     */
    public void move(char id, Direction direction) throws RushHourException {
        /*
        L'incompatibilté entre la direction et l'orientation sont géré par la 
        classe Position et Car, doit-on la gérer de nouveau avec RushHourException ?
         */
        Car car = this.board.getCar(id);
        if (car != null && this.board.canMove(car, direction)) {
            this.board.remove(car);
            car.move(direction);
            this.board.put(car);
        }
    }

    /**
     * Determine if the game is over
     *
     * @return @throws RushHourException
     */
    public boolean isOver() throws RushHourException {
        //RushHourException inutile?
        return this.board.getCarAt(this.board.getExit()).equals(this.redCar);
    }
}
