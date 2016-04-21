// CLR : aucune remarque !

package g42861.rushhour;

import g42861.rushhour.model.Car;
import g42861.rushhour.model.Orientation;
import g42861.rushhour.model.Position;
import g42861.rushhour.model.RushHourGame;
import g42861.rushhour.view.RushHourView;
import java.util.ArrayList;
import java.util.List;

/**
 * Main class of RushHourGame. Used to start the game
 *
 * @author G42861
 */
public class RushHour {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Position exit = new Position(2, 5);

        Car car1 = new Car('1', 3, Orientation.VERTICAL, new Position(0, 0));
        Car car2 = new Car('2', 2, Orientation.VERTICAL, new Position(4, 0));
        Car car3 = new Car('3', 2, Orientation.HORIZONTAL, new Position(0, 1));
        Car car4 = new Car('4', 2, Orientation.HORIZONTAL, new Position(4, 1));
        Car car5 = new Car('5', 3, Orientation.VERTICAL, new Position(1, 3));
        Car car6 = new Car('6', 3, Orientation.HORIZONTAL, new Position(5, 2));
        Car car7 = new Car('7', 3, Orientation.VERTICAL, new Position(3, 5));

        List<Car> cars = new ArrayList<>();
        cars.add(car1);
        cars.add(car2);
        cars.add(car3);
        cars.add(car4);
        cars.add(car5);
        cars.add(car6);
        cars.add(car7);

        Car redCar;
        redCar = new Car('R', 2, Orientation.HORIZONTAL, new Position(2, 1));

        RushHourGame game = null;
        try {
            game = new RushHourGame(6, 6, exit, cars, redCar);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        RushHourView view = new RushHourView(game);

        view.play();

    }

}
