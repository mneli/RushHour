package g42861.rushhour.model;

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
     * Test of getBoard method, of class RushHourGame.
     */
    @Test
    public void testGetBoard() {
        //to remove
    }

    /**
     * Test of constructor, of class RushHourGame.
     */
    @Test(expected = RushHourException.class)
    public void testRushHourGame() throws Exception {

    }

    /**
     * Test of move method, of class RushHourGame.
     */
    @Test
    public void testMove() throws Exception {
        System.out.println("move");
        char id = ' ';
        Direction direction = null;
        RushHourGame instance = null;
        instance.move(id, direction);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isOver method, of class RushHourGame.
     */
    @Test
    public void testIsOver() throws Exception {
        System.out.println("isOver");
        RushHourGame instance = null;
        boolean expResult = false;
        boolean result = instance.isOver();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

}
