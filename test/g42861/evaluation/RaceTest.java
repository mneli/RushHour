/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package g42861.evaluation;

import g42861.rushhour.model.Direction;
import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 *
 * @author G42861
 */
public class RaceTest {

    /**
     * Test of distance method, of class Race.
     *
     * @throws g42861.evaluation.RaceException
     */
    @Test
    public void testDistanceUp() throws RaceException {
        List<Direction> directions = new ArrayList<>();
        directions.add(Direction.UP);
        List<Snail> snails = new ArrayList<>();
        snails.add(new Snail("Turbo 1"));
        snails.add(new Snail("Turbo 2"));
        Race instance = new Race(snails);
        int expResult = 1;
        int result = instance.distance(directions);
        assertEquals(expResult, result);
    }

    /**
     * Test of distance method, of class Race.
     *
     * @throws g42861.evaluation.RaceException
     */
    @Test
    public void testDistanceDown() throws RaceException {
        List<Direction> directions = new ArrayList<>();
        directions.add(Direction.DOWN);
        List<Snail> snails = new ArrayList<>();
        snails.add(new Snail("Turbo 1"));
        snails.add(new Snail("Turbo 2"));
        Race instance = new Race(snails);
        int expResult = -1;
        int result = instance.distance(directions);
        assertEquals(expResult, result);
    }

    /**
     * Test of distance method, of class Race.
     *
     * @throws g42861.evaluation.RaceException
     */
    @Test
    public void testDistanceLeft() throws RaceException {
        List<Direction> directions = new ArrayList<>();
        directions.add(Direction.LEFT);
        List<Snail> snails = new ArrayList<>();
        snails.add(new Snail("Turbo 1"));
        snails.add(new Snail("Turbo 2"));
        Race instance = new Race(snails);
        int expResult = 0;
        int result = instance.distance(directions);
        assertEquals(expResult, result);
    }

    /**
     * Test of distance method, of class Race.
     *
     * @throws g42861.evaluation.RaceException
     */
    @Test
    public void testDistanceRight() throws RaceException {
        List<Direction> directions = new ArrayList<>();
        directions.add(Direction.RIGHT);
        List<Snail> snails = new ArrayList<>();
        snails.add(new Snail("Turbo 1"));
        snails.add(new Snail("Turbo 2"));
        Race instance = new Race(snails);
        int expResult = 0;
        int result = instance.distance(directions);
        assertEquals(expResult, result);
    }

    /**
     * Test of distance method, of class Race.
     *
     * @throws g42861.evaluation.RaceException
     */
    @Test
    public void testDistance() throws RaceException {
        List<Direction> directions = new ArrayList<>();
        directions.add(Direction.UP);
        directions.add(Direction.UP);
        directions.add(Direction.UP);
        directions.add(Direction.DOWN);
        directions.add(Direction.DOWN);
        directions.add(Direction.LEFT);
        directions.add(Direction.LEFT);
        directions.add(Direction.LEFT);
        directions.add(Direction.RIGHT);
        directions.add(Direction.RIGHT);
        List<Snail> snails = new ArrayList<>();
        snails.add(new Snail("Turbo 1"));
        snails.add(new Snail("Turbo 2"));
        Race instance = new Race(snails);
        int expResult = 1;
        int result = instance.distance(directions);
        assertEquals(expResult, result);
    }
}
