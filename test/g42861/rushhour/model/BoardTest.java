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
     * Test of constructor, of class Board. Invalid height
     */
    @Test(expected = IllegalArgumentException.class)
    public void testBoardInvalidHeight() {
        Position exit = new Position(2, 5);
        Board instance = new Board(0, 6, exit);
    }

    /**
     * Test of constructor, of class Board. Invalid width
     */
    @Test(expected = IllegalArgumentException.class)
    public void testBoardInvalidWidth() {
        Position exit = new Position(2, 5);
        Board instance = new Board(6, 0, exit);
    }

    /**
     * Test of constructor, of class Board. Exit row 0
     */
    @Test(expected = IllegalArgumentException.class)
    public void testBoardExitRowColumnInvalid1() {
        Position exit = new Position(0, 6);
        Board instance = new Board(6, 6, exit);
    }

    /**
     * Test of constructor, of class Board. Exit row 5
     */
    @Test(expected = IllegalArgumentException.class)
    public void testBoardExitRowColumnInvalid2() {
        Position exit = new Position(5, 6);
        Board instance = new Board(6, 6, exit);
    }

    /**
     * Test of constructor, of class Board.
     */
    @Test
    public void testBoard() {
        Position exit = new Position(3, 6);
        Board instance = new Board(7, 7, exit);
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
     * Test of getCarAt method, of class Board. Null expected
     */
    @Test
    public void testGetCarAt1() {
        Position pos = new Position(0, 0);
        Board instance = new Board();
        Car expResult = null;
        Car result = instance.getCarAt(pos);
        assertEquals(expResult, result);

    }

    /**
     * Test of getCarAt method, of class Board.
     */
    @Test
    public void testGetCarAt2() {
        Position pos1 = new Position(0, 0);
        Position pos2 = new Position(0, 1);
        Position pos3 = new Position(0, 2);
        Car car = new Car('A', 3, Orientation.HORIZONTAL, pos1);
        Board instance = new Board();
        instance.put(car);
        Car result1 = instance.getCarAt(pos1);
        Car result2 = instance.getCarAt(pos2);
        Car result3 = instance.getCarAt(pos3);
        assertTrue(result1.equals(car) && result2.equals(car) && result3.equals(car));
    }

    /**
     * Test of getCarAt method, of class Board.
     */
    @Test
    public void testGetCarAt3() {
        Position pos1 = new Position(0, 0);
        Position pos2 = new Position(1, 0);
        Position pos3 = new Position(2, 0);
        Car car = new Car('A', 3, Orientation.VERTICAL, pos1);
        Board instance = new Board();
        instance.put(car);
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
     * Test of remove method, of class Board.
     */
    @Test
    public void testRemove() {
        char id = '1';
        Car car = new Car(id, 3, Orientation.HORIZONTAL, new Position(0, 0));
        Board instance = new Board();
        instance.put(car);
        instance.remove(car);
        Car result = instance.getCar(id);
        assertTrue(result == null);
    }

    /**
     * Test of getCar method, of class Board.
     */
    @Test
    public void testGetCar() {
        char id = '1';
        Board instance = new Board();
        Car car = new Car(id, 2, Orientation.HORIZONTAL, new Position(4, 2));
        instance.put(car);
        Car expResult = car;
        Car result = instance.getCar(id);
        assertEquals(expResult, result);
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
