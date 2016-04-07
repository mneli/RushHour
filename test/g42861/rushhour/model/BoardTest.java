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
    public void testGetCarAtNull() {
        Position pos = new Position(2, 5);
        Board instance = new Board();
        Car expResult = null;
        Car result = instance.getCarAt(pos);
        assertEquals(expResult, result);

    }

    /**
     * Test of getCarAt method, of class Board.
     */
    @Test
    public void testGetCarAtHorizontal() {
        Position pos1 = new Position(2, 1);
        Position pos2 = new Position(2, 2);
        Position pos3 = new Position(2, 3);
        Car car = new Car('A', 3, Orientation.HORIZONTAL, pos1);
        Board instance = new Board();
        instance.put(car);
        Car result1 = instance.getCarAt(pos1);
        Car result2 = instance.getCarAt(pos2);
        Car result3 = instance.getCarAt(pos3);
        assertTrue(result1.equals(car)
                && result2.equals(car) && result3.equals(car));
    }

    /**
     * Test of getCarAt method, of class Board.
     */
    @Test
    public void testGetCarAtVertical() {
        Position pos1 = new Position(0, 0);
        Position pos2 = new Position(1, 0);
        Position pos3 = new Position(2, 0);
        Car car = new Car('A', 3, Orientation.VERTICAL, pos1);
        Board instance = new Board();
        instance.put(car);
        Car result1 = instance.getCarAt(pos1);
        Car result2 = instance.getCarAt(pos2);
        Car result3 = instance.getCarAt(pos3);
        assertTrue(result1.equals(car)
                && result2.equals(car) && result3.equals(car));
    }

    /**
     * Test of canPut method, of class Board. Orientation Horizontal
     */
    @Test
    public void testCanPutHorizontal() {
        Car car = new Car('A', 3, Orientation.HORIZONTAL, new Position(2, 2));
        Board instance = new Board();
        assertTrue(instance.canPut(car));
    }

    /**
     * Test of canPut method, of class Board. Orientation Vertical
     */
    @Test
    public void testCanPutVertical() {
        Car car = new Car('A', 3, Orientation.VERTICAL, new Position(2, 2));
        Board instance = new Board();
        assertTrue(instance.canPut(car));
    }

    /**
     * Test of canPut method, of class Board. All positions occupied
     */
    @Test
    public void testCanPutPosOccupiedAll() {
        Car car = new Car('A', 3, Orientation.HORIZONTAL, new Position(0, 0));
        Board instance = new Board();
        instance.put(car);
        assertFalse(instance.canPut(car));
    }

    /**
     * Test of canPut method, of class Board. One position occupied. The first.
     */
    @Test
    public void testCanPutPosOccupiedFirst() {
        Car car1 = new Car('A', 3, Orientation.HORIZONTAL, new Position(1, 0));
        Car car2 = new Car('B', 3, Orientation.VERTICAL, new Position(1, 0));
        Board instance = new Board();
        instance.put(car2);
        assertFalse(instance.canPut(car1));
    }

    /**
     * Test of canPut method, of class Board. One position occupied. The second.
     */
    @Test
    public void testCanPutPosOccupiedSecond() {
        Car car1 = new Car('A', 3, Orientation.HORIZONTAL, new Position(1, 0));
        Car car2 = new Car('B', 3, Orientation.VERTICAL, new Position(1, 1));
        Board instance = new Board();
        instance.put(car2);
        assertFalse(instance.canPut(car1));
    }

    /**
     * Test of canPut method, of class Board. One position occupied. The third.
     */
    @Test
    public void testCanPutPosOccupiedThird() {
        Car car1 = new Car('A', 3, Orientation.HORIZONTAL, new Position(1, 0));
        Car car2 = new Car('B', 3, Orientation.VERTICAL, new Position(1, 2));
        Board instance = new Board();
        instance.put(car2);
        assertFalse(instance.canPut(car1));
    }

    /**
     * Test of canPut method, of class Board. Car out of board. Left boundary.
     */
    @Test
    public void testCanPutBoundaryLeft() {
        Car car = new Car('A', 3, Orientation.HORIZONTAL, new Position(1, -1));
        Board instance = new Board();
        assertFalse(instance.canPut(car));
    }

    /**
     * Test of canPut method, of class Board. Car out of board. Right boundary.
     */
    @Test
    public void testCanPutBoundaryRight() {
        Car car = new Car('A', 3, Orientation.HORIZONTAL, new Position(1, 4));
        Board instance = new Board();
        assertFalse(instance.canPut(car));
    }

    /**
     * Test of canPut method, of class Board. Car out of board. Upper boundary.
     */
    @Test
    public void testCanPutBoundaryUp() {
        Car car = new Car('A', 3, Orientation.VERTICAL, new Position(-2, 3));
        Board instance = new Board();
        assertFalse(instance.canPut(car));
    }

    /**
     * Test of canPut method, of class Board. Car out of board. Lower boundary.
     */
    @Test
    public void testCanPutBoundaryDown() {
        Car car = new Car('A', 3, Orientation.VERTICAL, new Position(5, 3));
        Board instance = new Board();
        assertFalse(instance.canPut(car));
    }

    /**
     * Test of put method, of class Board.
     */
    @Test
    public void testPutHorizontal() {
        Position pos1 = new Position(0, 0);
        Position pos2 = new Position(0, 1);
        Position pos3 = new Position(0, 2);
        Car car = new Car('A', 3, Orientation.HORIZONTAL, new Position(0, 0));
        Board instance = new Board();
        instance.put(car);
        Car result1 = instance.getCarAt(pos1);
        Car result2 = instance.getCarAt(pos2);
        Car result3 = instance.getCarAt(pos3);
        assertTrue(result1.equals(car)
                && result2.equals(car) && result3.equals(car));
    }

    /**
     * Test of put method, of class Board.
     */
    @Test
    public void testPutVertical() {
        Position pos1 = new Position(0, 0);
        Position pos2 = new Position(1, 0);
        Position pos3 = new Position(2, 0);
        Car car = new Car('A', 3, Orientation.VERTICAL, new Position(0, 0));
        Board instance = new Board();
        instance.put(car);
        Car result1 = instance.getCarAt(pos1);
        Car result2 = instance.getCarAt(pos2);
        Car result3 = instance.getCarAt(pos3);
        assertTrue(result1.equals(car)
                && result2.equals(car) && result3.equals(car));
    }

    /**
     * Test of remove method, of class Board.
     */
    @Test
    public void testRemoveTrue() {
        char id = '1';
        Car car = new Car(id, 3, Orientation.HORIZONTAL, new Position(2, 0));
        Board instance = new Board();
        instance.put(car);
        instance.remove(car);
        Car result = instance.getCar(id);
        assertTrue(result == null);
    }

    /**
     * Test of remove method, of class Board.
     */
    @Test
    public void testRemoveFalse() {
        char id = '1';
        Car car1 = new Car(id, 3, Orientation.HORIZONTAL, new Position(0, 2));
        Car car2 = new Car(id, 3, Orientation.VERTICAL, new Position(2, 2));
        Board instance = new Board();
        instance.put(car1);
        instance.put(car2);
        instance.remove(car1);
        Car result = instance.getCar(id);
        assertFalse(result == null);
    }

    /**
     * Test of getCar method, of class Board.
     */
    @Test
    public void testGetCarHorizontal() {
        char id = '1';
        Board instance = new Board();
        Car car = new Car(id, 2, Orientation.HORIZONTAL, new Position(4, 2));
        instance.put(car);
        Car expResult = car;
        Car result = instance.getCar(id);
        assertEquals(expResult, result);
    }

    /**
     * Test of getCar method, of class Board.
     */
    @Test
    public void testGetCarVertical() {
        char id = 'A';
        Board instance = new Board();
        Car car = new Car(id, 2, Orientation.VERTICAL, new Position(4, 2));
        instance.put(car);
        Car expResult = car;
        Car result = instance.getCar(id);
        assertEquals(expResult, result);
    }

    /**
     * Test of canMove method, of class Board. Left
     */
    @Test
    public void testCanMoveBoundaryLeftTrue() {
        Car car = new Car('A', 2, Orientation.HORIZONTAL, new Position(0, 4));
        Direction direction = Direction.LEFT;
        Board instance = new Board();
        instance.put(car);
        boolean expResult = true;
        boolean result = instance.canMove(car, direction);
        assertEquals(expResult, result);
    }

    /**
     * Test of canMove method, of class Board. left boundary
     */
    @Test
    public void testCanMoveBoundaryLeftFalse() {
        Car car = new Car('A', 2, Orientation.HORIZONTAL, new Position(0, 0));
        Direction direction = Direction.LEFT;
        Board instance = new Board();
        instance.put(car);
        boolean expResult = false;
        boolean result = instance.canMove(car, direction);
        assertEquals(expResult, result);
    }

    /**
     * Test of canMove method, of class Board. Right
     */
    @Test
    public void testCanMoveBoundaryRightTrue() {
        Car car = new Car('A', 2, Orientation.HORIZONTAL, new Position(0, 0));
        Direction direction = Direction.RIGHT;
        Board instance = new Board();
        instance.put(car);
        boolean expResult = true;
        boolean result = instance.canMove(car, direction);
        assertEquals(expResult, result);
    }

    /**
     * Test of canMove method, of class Board. Right boundary
     */
    @Test
    public void testCanMoveBoundaryRightFalse() {
        Car car = new Car('A', 2, Orientation.HORIZONTAL, new Position(0, 4));
        Direction direction = Direction.RIGHT;
        Board instance = new Board();
        instance.put(car);
        boolean expResult = false;
        boolean result = instance.canMove(car, direction);
        assertEquals(expResult, result);
    }

    /**
     * Test of canMove method, of class Board. Up
     */
    @Test
    public void testCanMoveBoundaryUpTrue() {
        Car car = new Car('A', 2, Orientation.VERTICAL, new Position(4, 0));
        Direction direction = Direction.UP;
        Board instance = new Board();
        instance.put(car);
        boolean expResult = true;
        boolean result = instance.canMove(car, direction);
        assertEquals(expResult, result);
    }

    /**
     * Test of canMove method, of class Board. Upper boundary
     */
    @Test
    public void testCanMoveBoundaryUpFalse() {
        Car car = new Car('A', 2, Orientation.VERTICAL, new Position(0, 0));
        Direction direction = Direction.UP;
        Board instance = new Board();
        instance.put(car);
        boolean expResult = false;
        boolean result = instance.canMove(car, direction);
        assertEquals(expResult, result);
    }

    /**
     * Test of canMove method, of class Board. Down
     */
    @Test
    public void testCanMoveBoundaryDownTrue() {
        Car car = new Car('A', 2, Orientation.VERTICAL, new Position(0, 0));
        Direction direction = Direction.DOWN;
        Board instance = new Board();
        instance.put(car);
        boolean expResult = true;
        boolean result = instance.canMove(car, direction);
        assertEquals(expResult, result);
    }

    /**
     * Test of canMove method, of class Board. Lower boundary
     */
    @Test
    public void testCanMoveBoundaryDownFalse() {
        Car car = new Car('A', 2, Orientation.VERTICAL, new Position(4, 0));
        Direction direction = Direction.DOWN;
        Board instance = new Board();
        instance.put(car);
        boolean expResult = false;
        boolean result = instance.canMove(car, direction);
        assertEquals(expResult, result);
    }

    /**
     * Test of canMove method, of class Board. Left position occupied
     */
    @Test
    public void testCanMovePosOccupiedLeft() {
        Car car1 = new Car('A', 2, Orientation.HORIZONTAL, new Position(0, 4));
        Car car2 = new Car('B', 2, Orientation.VERTICAL, new Position(0, 3));
        Direction direction = Direction.LEFT;
        Board instance = new Board();
        instance.put(car1);
        instance.put(car2);
        boolean expResult = false;
        boolean result = instance.canMove(car1, direction);
        assertEquals(expResult, result);
    }

    /**
     * Test of canMove method, of class Board. Right position occupied
     */
    @Test
    public void testCanMovePosOccupiedRight() {
        Car car1 = new Car('A', 2, Orientation.HORIZONTAL, new Position(0, 0));
        Car car2 = new Car('B', 2, Orientation.VERTICAL, new Position(0, 2));
        Direction direction = Direction.RIGHT;
        Board instance = new Board();
        instance.put(car1);
        instance.put(car2);
        boolean expResult = false;
        boolean result = instance.canMove(car1, direction);
        assertEquals(expResult, result);
    }

    /**
     * Test of canMove method, of class Board. Upper position occupied
     */
    @Test
    public void testCanMovePosOccupiedUp() {
        Car car1 = new Car('A', 2, Orientation.VERTICAL, new Position(4, 3));
        Car car2 = new Car('B', 2, Orientation.HORIZONTAL, new Position(3, 2));
        Direction direction = Direction.UP;
        Board instance = new Board();
        instance.put(car1);
        instance.put(car2);
        boolean expResult = false;
        boolean result = instance.canMove(car1, direction);
        assertEquals(expResult, result);
    }

    /**
     * Test of canMove method, of class Board. Lower position occupied
     */
    @Test
    public void testCanMovePosOccupiedDown() {
        Car car1 = new Car('A', 2, Orientation.VERTICAL, new Position(0, 3));
        Car car2 = new Car('B', 2, Orientation.HORIZONTAL, new Position(2, 3));
        Direction direction = Direction.DOWN;
        Board instance = new Board();
        instance.put(car1);
        instance.put(car2);
        boolean expResult = false;
        boolean result = instance.canMove(car1, direction);
        assertEquals(expResult, result);
    }

}
