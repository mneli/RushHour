package g42861.rushhour.model;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author G42861
 */
public class CarTest {

    public CarTest() {
    }

    /**
     * Test of constructor, of class Car. Size negative.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testCarCaseSizeNegative() {
        Car instance = new Car('A', -1, Orientation.HORIZONTAL, new Position(0, 0));
    }

    /**
     * Test of constructor, of class Car. Size 0.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testCarCaseSize0() {
        Car instance = new Car('A', 0, Orientation.HORIZONTAL, new Position(0, 0));
    }

    /**
     * Test of constructor, of class Car. Size positive.
     */
    @Test
    public void testCarCaseSizePositive() {
        Car instance = new Car('A', 1, Orientation.HORIZONTAL, new Position(0, 0));
    }

    /**
     * Test of move method, of class Car. Orientation HORIZONTAL and direction
     * UP.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testMoveHorizontalUp() {
        Direction direction = Direction.UP;
        Car instance = new Car('A', 2, Orientation.HORIZONTAL, new Position(1, 1));
        instance.move(direction);
    }

    /**
     * Test of move method, of class Car. Orientation HORIZONTAL and direction
     * DOWN.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testMoveHorizontalDown() {
        Direction direction = Direction.DOWN;
        Car instance = new Car('A', 2, Orientation.HORIZONTAL, new Position(1, 1));
        instance.move(direction);
    }

    /**
     * Test of move method, of class Car. Orientation VERTICAL and direction
     * LEFT.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testMoveVerticalLeft() {
        Direction direction = Direction.LEFT;
        Car instance = new Car('A', 2, Orientation.VERTICAL, new Position(1, 1));
        instance.move(direction);
    }

    /**
     * Test of move method, of class Car. Orientation VERTICAL and direction
     * RIGHT.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testMoveVerticalRight() {
        Direction direction = Direction.RIGHT;
        Car instance = new Car('A', 2, Orientation.VERTICAL, new Position(1, 1));
        instance.move(direction);
    }

    /**
     * Test of move method, of class Car. Orientation HORIZONTAL and direction
     * LEFT.
     */
    @Test
    public void testMoveHorizontalLeft() {
        Direction direction = Direction.LEFT;
        Car instance = new Car('A', 2, Orientation.HORIZONTAL, new Position(1, 1));
        instance.move(direction);
        Position expResult = new Position(1, 0);
        Position result = instance.getCurrentPosition();
        assertEquals(expResult, result);
    }

    /**
     * Test of move method, of class Car. Orientation HORIZONTAL and direction
     * RIGHT.
     */
    @Test
    public void testMoveHorizontalRight() {
        Direction direction = Direction.RIGHT;
        Car instance = new Car('A', 2, Orientation.HORIZONTAL, new Position(1, 1));
        instance.move(direction);
        Position expResult = new Position(1, 2);
        Position result = instance.getCurrentPosition();
        assertEquals(expResult, result);
    }

    /**
     * Test of move method, of class Car. Orientation VERTICAL and direction UP.
     */
    @Test
    public void testMoveVerticalUp() {
        Direction direction = Direction.UP;
        Car instance = new Car('A', 2, Orientation.VERTICAL, new Position(1, 1));
        instance.move(direction);
        Position expResult = new Position(0, 1);
        Position result = instance.getCurrentPosition();
        assertEquals(expResult, result);
    }

    /**
     * Test of move method, of class Car. Orientation VERTICAL and direction
     * DOWN.
     */
    @Test
    public void testMoveVerticalDown() {
        Direction direction = Direction.DOWN;
        Car instance = new Car('A', 2, Orientation.VERTICAL, new Position(1, 1));
        instance.move(direction);
        Position expResult = new Position(2, 1);
        Position result = instance.getCurrentPosition();
        assertEquals(expResult, result);
    }

}
