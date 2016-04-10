package g42861.rushhour.model;

import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author G42861
 */
public class RushHourGameTest {

    public RushHourGameTest() {
    }

    /**
     * Test of constructor, of class RushHourGame. Horizontal, row different
     *
     * @throws java.lang.Exception
     */
    @Test(expected = RushHourException.class)
    public void testRushHourGameHorizontalDifferentRow() throws Exception {
        Position exit = new Position(2, 5);
        Position posRedCar = new Position(3, 0);
        Car redCar = new Car('R', 2, Orientation.HORIZONTAL, posRedCar);
        List<Car> cars = new ArrayList<>();
        RushHourGame instance = new RushHourGame(6, 6, exit, cars, redCar);
    }

    /**
     * Test of constructor, of class RushHourGame. Vertical, column different
     *
     * @throws java.lang.Exception
     */
    @Test(expected = RushHourException.class)
    public void testRushHourGameVerticalDifferentColumn() throws Exception {
        Position exit = new Position(0, 3);
        Position posRedCar = new Position(3, 0);
        Car redCar = new Car('R', 2, Orientation.VERTICAL, posRedCar);
        List<Car> cars = new ArrayList<>();
        RushHourGame instance = new RushHourGame(6, 6, exit, cars, redCar);
    }

    /**
     * Test of constructor, of class RushHourGame. Horizontal, same row
     *
     * @throws java.lang.Exception
     */
    @Test
    public void testRushHourGameHorizontalSameRow() throws Exception {
        Position exit = new Position(3, 5);
        Position posRedCar = new Position(3, 0);
        Car redCar = new Car('R', 2, Orientation.HORIZONTAL, posRedCar);
        List<Car> cars = new ArrayList<>();
        RushHourGame instance = new RushHourGame(6, 6, exit, cars, redCar);
    }

    /**
     * Test of constructor, of class RushHourGame. Vertical, same column
     *
     * @throws java.lang.Exception
     */
    @Test
    public void testRushHourGameVerticalSameColumn() throws Exception {
        Position exit = new Position(0, 3);
        Position posRedCar = new Position(3, 3);
        Car redCar = new Car('R', 2, Orientation.VERTICAL, posRedCar);
        List<Car> cars = new ArrayList<>();
        RushHourGame instance = new RushHourGame(6, 6, exit, cars, redCar);
    }

    /**
     * Test of move method, of class RushHourGame. Left
     *
     * @throws java.lang.Exception
     */
    @Test
    public void testMoveLeft() throws Exception {

        Position exit = new Position(2, 5);
        Position posRedCar = new Position(2, 2);
        Car redCar = new Car('R', 2, Orientation.HORIZONTAL, posRedCar);
        List<Car> cars = new ArrayList<>();
        RushHourGame instance = new RushHourGame(6, 6, exit, cars, redCar);
        char id = redCar.getId();
        Direction direction = Direction.LEFT;
        instance.move(id, direction);
        Position result = redCar.getCurrentPosition();
        Position expResult = new Position(2, 1);
        assertEquals(expResult, result);
    }

    /**
     * Test of move method, of class RushHourGame. Right
     *
     * @throws java.lang.Exception
     */
    @Test
    public void testMoveRight() throws Exception {

        Position exit = new Position(2, 5);
        Position posRedCar = new Position(2, 2);
        Car redCar = new Car('R', 2, Orientation.HORIZONTAL, posRedCar);
        List<Car> cars = new ArrayList<>();
        RushHourGame instance = new RushHourGame(6, 6, exit, cars, redCar);
        char id = redCar.getId();
        Direction direction = Direction.RIGHT;
        instance.move(id, direction);
        Position result = redCar.getCurrentPosition();
        Position expResult = new Position(2, 3);
        assertEquals(expResult, result);
    }

    /**
     * Test of move method, of class RushHourGame. Up
     *
     * @throws java.lang.Exception
     */
    @Test
    public void testMoveUp() throws Exception {

        Position exit = new Position(0, 2);
        Position posRedCar = new Position(2, 2);
        Car redCar = new Car('R', 2, Orientation.VERTICAL, posRedCar);
        List<Car> cars = new ArrayList<>();
        RushHourGame instance = new RushHourGame(6, 6, exit, cars, redCar);
        char id = redCar.getId();
        Direction direction = Direction.UP;
        instance.move(id, direction);
        Position result = redCar.getCurrentPosition();
        Position expResult = new Position(1, 2);
        assertEquals(expResult, result);
    }

    /**
     * Test of move method, of class RushHourGame. Down
     *
     * @throws java.lang.Exception
     */
    @Test
    public void testMoveDown() throws Exception {

        Position exit = new Position(0, 2);
        Position posRedCar = new Position(2, 2);
        Car redCar = new Car('R', 2, Orientation.VERTICAL, posRedCar);
        List<Car> cars = new ArrayList<>();
        RushHourGame instance = new RushHourGame(6, 6, exit, cars, redCar);
        char id = redCar.getId();
        Direction direction = Direction.DOWN;
        instance.move(id, direction);
        Position result = redCar.getCurrentPosition();
        Position expResult = new Position(3, 2);
        assertEquals(expResult, result);
    }

    /**
     * Test of move method, of class RushHourGame. Car not on board
     *
     * @throws java.lang.Exception
     */
    @Test(expected = RushHourException.class)
    public void testMoveNull() throws Exception {

        Position exit = new Position(0, 2);
        Position posRedCar = new Position(2, 2);
        Car redCar = new Car('R', 2, Orientation.VERTICAL, posRedCar);
        List<Car> cars = new ArrayList<>();
        RushHourGame instance = new RushHourGame(6, 6, exit, cars, redCar);
        char id = 'A';
        Direction direction = Direction.DOWN;
        instance.move(id, direction);
    }

    /**
     * Test of isOver method, of class RushHourGame. Red car on exit
     *
     * @throws java.lang.Exception
     */
    @Test
    public void testIsOverTrue() throws Exception {
        Position exit = new Position(0, 2);
        Position posRedCar = new Position(1, 2);
        Car redCar = new Car('R', 2, Orientation.VERTICAL, posRedCar);
        List<Car> cars = new ArrayList<>();
        RushHourGame instance = new RushHourGame(6, 6, exit, cars, redCar);
        instance.move('R', Direction.UP);
        assertTrue(instance.isOver());
    }

    /**
     * Test of isOver method, of class RushHourGame. Null on position exit
     *
     * @throws java.lang.Exception
     */
    @Test
    public void testIsOverFalseEmpty() throws Exception {
        Position exit = new Position(0, 2);
        Position posRedCar = new Position(1, 2);
        Car redCar = new Car('R', 2, Orientation.VERTICAL, posRedCar);
        List<Car> cars = new ArrayList<>();
        Car carA = new Car('A', 2, Orientation.HORIZONTAL, exit);
        RushHourGame instance = new RushHourGame(6, 6, exit, cars, redCar);
        assertFalse(instance.isOver());
    }

    /**
     * Test of isOver method, of class RushHourGame. Another car on position
     * exit
     *
     * @throws java.lang.Exception
     */
    @Test
    public void testIsOverFalseAnotherCar() throws Exception {
        Position exit = new Position(0, 2);
        Position posRedCar = new Position(1, 2);
        Car redCar = new Car('R', 2, Orientation.VERTICAL, posRedCar);
        List<Car> cars = new ArrayList<>();
        Car carA = new Car('A', 2, Orientation.HORIZONTAL, exit);
        cars.add(carA);
        RushHourGame instance = new RushHourGame(6, 6, exit, cars, redCar);
        assertFalse(instance.isOver());
    }

}
