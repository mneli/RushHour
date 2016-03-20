package g42861.rushhour.model;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author G42861
 */
public class PositionTest {

    public PositionTest() {
    }

    /**
     * Test of getRow method, of class Position.
     */
    @Test
    public void testGetRow() {
        Position instance = new Position(2, 7);
        int expResult = 2;
        int result = instance.getRow();
        assertEquals(expResult, result);
    }

    /**
     * Test of getColumn method, of class Position.
     */
    @Test
    public void testGetColumn() {
        Position instance = new Position(2, 7);
        int expResult = 7;
        int result = instance.getColumn();
        assertEquals(expResult, result);
    }

    /**
     * Test of gePosition method, of class Position.
     */
    @Test
    public void testGePositionUp() {
        Direction direction = Direction.UP;
        Position instance = new Position(2, 7);
        Position expResult = new Position(1, 7);
        Position result = instance.gePosition(direction);
        assertEquals(expResult, result);
    }

    /**
     * Test of gePosition method, of class Position.
     */
    @Test
    public void testGePositionDown() {
        Direction direction = Direction.DOWN;
        Position instance = new Position(2, 7);
        Position expResult = new Position(3, 7);
        Position result = instance.gePosition(direction);
        assertEquals(expResult, result);
    }

    /**
     * Test of gePosition method, of class Position.
     */
    @Test
    public void testGePositionLeft() {
        Direction direction = Direction.LEFT;
        Position instance = new Position(2, 7);
        Position expResult = new Position(2, 6);
        Position result = instance.gePosition(direction);
        assertEquals(expResult, result);
    }

    /**
     * Test of gePosition method, of class Position.
     */
    @Test
    public void testGePositionRight() {
        Direction direction = Direction.RIGHT;
        Position instance = new Position(2, 7);
        Position expResult = new Position(2, 8);
        Position result = instance.gePosition(direction);
        assertEquals(expResult, result);
    }

}
