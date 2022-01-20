package pathfinder;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class SquareTest {

    @Test
    public void createSquareWithNames() {
        Square actual = Square.initialization("A1");
        assertTrue(actual.getX() == 0 && actual.getY() == 0);
        actual = Square.initialization("H8");
        assertTrue(actual.getX() == 7 && actual.getY() == 7);
        actual = Square.initialization("B3");
        assertTrue(actual.getX() == 1 && actual.getY() == 2);
    }

    @Test
    public void createSquareWithCoordinates()  {
        Square actual = Square.destination(0, 0);
        assertEquals("A1", actual.getSquareName());
        actual = Square.destination(7, 7);
        assertEquals("H8", actual.getSquareName());
        actual = Square.destination(1, 2);
        assertEquals("B3", actual.getSquareName());
    }

}