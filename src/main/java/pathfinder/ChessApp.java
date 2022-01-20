package pathfinder;

import java.util.List;

public class ChessApp {

    public static void main(String[] args) {

        Square start = Square.initialization(args[0]);
        Square goal = Square.initialization(args[1]);
        int movesAllowed = Integer.parseInt(args[2]);

        System.out.println("start = " + start + " end = " + goal);

        Search search = new Search(movesAllowed, new Knight());
        List<Square> path = search.findPath(start, goal);

        System.out.println("path = " + path.toString());
    }
}

