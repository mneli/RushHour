package g42861.rushhour.model;

import java.util.List;

/**
 *
 * @author G42861
 * @group B231
 */
public class RushHourGame {

    private Board board;
    private Car redCar;

    //todo case exception
    public RushHourGame(int height, int width, Position exit, List<Car> cars, Car redCar) throws RushHourException {
        this.board = new Board(height, width, exit);
        this.redCar = redCar;
        for (Car car : cars) {
            if (board.canPut(car))
                board.put(car);
        }
        if (board.canPut(this.redCar))
            board.put(this.redCar);
    }

    public Board getBoard() {
        return this.board;
    }

    //todo case exception
    public void move(char id, Direction direction) throws RushHourException {
        Car car = this.board.getCar(id);
        if (car != null && this.board.canMove(car, direction)) {
            this.board.remove(car);
            car.move(direction);
            this.board.put(car);
        }
    }

    //todo case exception
    public boolean isOver() throws RushHourException {
        return this.board.getCarAt(this.board.getExit()).equals(this.redCar);
    }
}
