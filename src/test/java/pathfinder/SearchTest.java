package pathfinder;

import org.junit.Test;
import pathfinder.extention.Piece;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class SearchTest {

    @Test
    public void findAllPathsWithThreeMoves() {


        SquarePath path1 = new SquarePath("B3", "C5", "B7", "D8");
        SquarePath path2 = new SquarePath("B3", "C5", "A5", "D8");
        SquarePath path3 = new SquarePath("B3", "D4", "C6", "D8");
        SquarePath path4 = new SquarePath("B3", "D4", "E6", "D8");

        int movesAllowed = 3;
        Search search = new Search(movesAllowed, new Knight());

        Square start = Square.initialization("B3");
        Square goal = Square.initialization("D8");

        SquarePath path = new SquarePath(search.findPath(start, goal));

        System.out.println("path = " + path);
        assertTrue(path.equals(path1) || path.equals(path2) || path.equals(path3) || path.equals(path4));
    }

    @Test
    public void findPathWithTwoMoves() {

        String[][] goal = {
                {"B3", "B7"},
                {"F3", "F7"},
        };

        int expectedPathSize = 3;
        int maxMovesAllowed = 2;
        for (String[] pair : goal) {
            assertForPair(pair, maxMovesAllowed, new Knight(), expectedPathSize);
        }

    }

    private void assertForPair(String[] pair, int maxMovesAllowed, Piece piece, int expectedPathSize) {

        Square start = Square.initialization(pair[0]);
        Square goal = Square.initialization(pair[1]);

        System.out.println("start = " + start + " end = " + goal);

        Search search = new Search(maxMovesAllowed, piece);
        ArrayList<Square> path = search.findPath(start, goal);

        System.out.println("path = " + path.toString());
        assertEquals(expectedPathSize, path.size());
    }
}
