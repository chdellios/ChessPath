package pathfinder;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CalculateTest {
    Calculate calculate;

    @Before
    public void runBeforeEachTest() {
        this.calculate = new Calculate(new Knight());
    }

    @Test
    public void threeMovesGoalReach() {
        Square sq1 = Square.initialization("B3");
        Square sq2 = Square.initialization("D8");
        assertEquals(3, calculate.estimateMinMovesNeeded(sq1, sq2));
    }

    @Test
    public void twoMovesGoalReach() {
        Square sq1 = Square.initialization("B3");
        Square sq2 = Square.initialization("B7");
        assertEquals(2, calculate.estimateMinMovesNeeded(sq1, sq2));
    }

    @Test
    public void zeroMovesGoalReach() {
        Square sq1 = Square.initialization("H8");
        Square sq2 = Square.initialization("H8");
        assertEquals(0, calculate.estimateMinMovesNeeded(sq1, sq2));
    }
}