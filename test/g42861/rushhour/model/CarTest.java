package g42861.rushhour.model;

import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Class test of the class Car.
 *
 * @author G42861
 */
public class CarTest {

    public CarTest() {
        //to remove?
    }

    /**
     * Test of constructor, of class Car. Size negative.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testCarCaseSizeNegative() {
        Car instance;
        instance = new Car('A', -1, Orientation.HORIZONTAL, new Position(0, 0));
    }

    /**
     * Test of constructor, of class Car. Size 0.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testCarCaseSize0() {
        Car instance;
        instance = new Car('A', 0, Orientation.HORIZONTAL, new Position(0, 0));
    }

    /**
     * Test of constructor, of class Car. Size positive.
     */
    @Test
    public void testCarCaseSizePositive() {
        Car instance;
        instance = new Car('A', 1, Orientation.HORIZONTAL, new Position(0, 0));
    }

    /**
     * Test of move method, of class Car. Orientation HORIZONTAL and direction
     * UP.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testMoveHorizontalUp() {
        Direction direction = Direction.UP;
        Car instance;
        instance = new Car('A', 2, Orientation.HORIZONTAL, new Position(1, 1));
        instance.move(direction);
    }

    /**
     * Test of move method, of class Car. Orientation HORIZONTAL and direction
     * DOWN.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testMoveHorizontalDown() {
        Direction direction = Direction.DOWN;
        Car instance;
        instance = new Car('A', 2, Orientation.HORIZONTAL, new Position(1, 1));
        instance.move(direction);
    }

    /**
     * Test of move method, of class Car. Orientation VERTICAL and direction
     * LEFT.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testMoveVerticalLeft() {
        Direction direction = Direction.LEFT;
        Car instance;
        instance = new Car('A', 2, Orientation.VERTICAL, new Position(1, 1));
        instance.move(direction);
    }

    /**
     * Test of move method, of class Car. Orientation VERTICAL and direction
     * RIGHT.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testMoveVerticalRight() {
        Direction direction = Direction.RIGHT;
        Car instance;
        instance = new Car('A', 2, Orientation.VERTICAL, new Position(1, 1));
        instance.move(direction);
    }

    /**
     * Test of move method, of class Car. Orientation HORIZONTAL and direction
     * LEFT.
     */
    @Test
    public void testMoveHorizontalLeft() {
        Direction direction = Direction.LEFT;
        Car instance;
        instance = new Car('A', 2, Orientation.HORIZONTAL, new Position(1, 1));
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
        Car instance;
        instance = new Car('A', 2, Orientation.HORIZONTAL, new Position(1, 1));
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
        Car instance;
        instance = new Car('A', 2, Orientation.VERTICAL, new Position(1, 1));
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
        Car instance;
        instance = new Car('A', 2, Orientation.VERTICAL, new Position(1, 1));
        instance.move(direction);
        Position expResult = new Position(2, 1);
        Position result = instance.getCurrentPosition();
        assertEquals(expResult, result);
    }

    /**
     * Test of getPositions method, of class Car. Verification of returned list
     * size
     */
    @Test
    public void testGetPositionsListSize1() {
        Car instance;
        instance = new Car('A', 1, Orientation.HORIZONTAL, new Position(0, 0));
        List<Position> listPos = instance.getPositions();
        int expResult = 1;
        int result = listPos.size();
        assertEquals(expResult, result);
    }

    /**
     * Test of getPositions method, of class Car. Verification of returned list
     * size
     */
    @Test
    public void testGetPositionsListSize2() {
        Car instance;
        instance = new Car('A', 3, Orientation.VERTICAL, new Position(0, 0));
        List<Position> listPos = instance.getPositions();
        int expResult = 3;
        int result = listPos.size();
        assertEquals(expResult, result);
    }

    /**
     * Test of getPositions method, of class Car. Case car of size 2 oriented
     * horizontally.
     */
    @Test
    public void testGetPositionsHorizontal() {
        Position position1 = new Position(1, 2);
        Position position2 = new Position(1, 3);
        Car instance = new Car('A', 2, Orientation.HORIZONTAL, position1);
        List<Position> result = instance.getPositions();
        assertTrue(result.contains(position1) && result.contains(position2));
    }

    /**
     * Test of getPositions method, of class Car. Case car of size 3 oriented
     * vertically.
     */
    @Test
    public void testGetPositionsVertical() {
        Position position1 = new Position(1, 2);
        Position position2 = new Position(2, 2);
        Position position3 = new Position(3, 2);
        Car instance;
        instance = new Car('A', 3, Orientation.VERTICAL, new Position(1, 2));
        List<Position> result = instance.getPositions();
        assertTrue(result.contains(position1)
                && result.contains(position2) && result.contains(position3));
    }

    /**
     * Test of getPositions method, of class Car. Case car of size 3 oriented
     * vertically. Random order
     */
    @Test
    public void testGetPositionsVerticalRandomOrder() {
        Position position1 = new Position(1, 2);
        Position position2 = new Position(2, 2);
        Position position3 = new Position(3, 2);
        Car instance;
        instance = new Car('A', 3, Orientation.VERTICAL, new Position(1, 2));
        List<Position> result = instance.getPositions();
        assertTrue(result.contains(position2)
                && result.contains(position3) && result.contains(position1));
    }

    /**
     * Test of equals method, of class Car.
     */
    @Test
    public void testEquals1() {
        Object o;
        o = new Car('A', 2, Orientation.HORIZONTAL, new Position(0, 0));
        Car instance;
        instance = new Car('A', 2, Orientation.HORIZONTAL, new Position(0, 0));
        boolean expResult = true;
        boolean result = instance.equals(o);
        assertEquals(expResult, result);
    }

    /**
     * Test of equals method, of class Car.
     */
    @Test
    public void testEquals2() {
        Car instance;
        instance = new Car('A', 2, Orientation.HORIZONTAL, new Position(0, 0));
        Object o = instance;
        boolean expResult = true;
        boolean result = instance.equals(o);
        assertEquals(expResult, result);
    }

    /**
     * Test of hashCode method, of class Car.
     */
    @Test
    public void testHashCode() {
        Position currentPosition = new Position(0, 0);
        Car instance1 = new Car('A', 2, Orientation.HORIZONTAL, currentPosition);
        Car instance2 = new Car('A', 2, Orientation.HORIZONTAL, currentPosition);
        int expResult = instance1.hashCode();
        int result = instance2.hashCode();
        assertEquals(expResult, result);
    }

}
