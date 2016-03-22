package g42861.rushhour.model;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author G42861
 */
public class BoardTest {

    public BoardTest() {
    }

    /**
     * Test of getExit method, of class Board.
     */
    @Test
    public void testGetExit() {
        //to remove
    }

    /**
     * Test of getHeight method, of class Board.
     */
    @Test
    public void testGetHeight() {
        Board instance = new Board();
        int expResult = 6;
        int result = instance.getHeight();
        assertEquals(expResult, result);
    }

    /**
     * Test of getWidth method, of class Board.
     */
    @Test
    public void testGetWidth() {
        Board instance = new Board();
        int expResult = 6;
        int result = instance.getWidth();
        assertEquals(expResult, result);
    }

    /**
     * Test of getCarAt method, of class Board.
     */
    @Test
    public void testGetCarAt() {
        Position pos1 = new Position(0, 0);
        Position pos2 = new Position(0, 1);
        Position pos3 = new Position(0, 2);
        Car car = new Car('A', 3, Orientation.HORIZONTAL, pos1);
        Board instance = new Board();
        instance.put(car);
        Car expResult = car;
        Car result1 = instance.getCarAt(pos1);
        Car result2 = instance.getCarAt(pos2);
        Car result3 = instance.getCarAt(pos3);
        assertTrue(result1.equals(car) && result2.equals(car) && result3.equals(car));
    }

    /**
     * Test of canPut method, of class Board.
     */
    @Test
    public void testCanPut() {
        Car car = new Car('A', 3, Orientation.HORIZONTAL, new Position(0, 0));
        Board instance = new Board();
        instance.put(car);
        assertFalse(instance.canPut(car));
    }

    /**
     * Test of put method, of class Board.
     */
    @Test
    public void testPut() {
        Car car = new Car('A', 3, Orientation.HORIZONTAL, new Position(0, 0));
        Board instance = new Board();
        instance.put(car);
        assertFalse(instance.canPut(car));
    }

    /**
     * Test of getCar method, of class Board.
     */
    @Test
    public void testGetCar() {
        System.out.println("getCar");
        char id = ' ';
        Board instance = new Board();
        Car expResult = null;
        Car result = instance.getCar(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of remove method, of class Board.
     */
    @Test
    public void testRemove() {
        System.out.println("remove");
        Car car = null;
        Board instance = new Board();
        instance.remove(car);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of canMove method, of class Board.
     */
    @Test
    public void testCanMove() {
        System.out.println("canMove");
        Car car = null;
        Direction direction = null;
        Board instance = new Board();
        boolean expResult = false;
        boolean result = instance.canMove(car, direction);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

}
