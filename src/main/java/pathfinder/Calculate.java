package pathfinder;

import pathfinder.exception.OutOfBoundException;
import pathfinder.extention.Piece;

import java.util.HashSet;
import java.util.Set;

public class Calculate {
    private static final int EXTRA_MOVE_NEEDED = 1;
    private final Piece piece;

    public Calculate(Piece piece) {
        this.piece = piece;
    }

    public Set<SquareNode> determineNeighborNodes(SquareNode currentNode, Square goalSquare) {
        Set<SquareNode> neighborNodes = new HashSet<>();
        Set<Move> moves = piece.getMoves();
        for (Move move : moves) {
            Square neighborSquare;
            try {
                neighborSquare = move.calculateDestination(currentNode.getSquare());
            } catch (OutOfBoundException e) {
                continue;
            }
            int movesFromStart = currentNode.getMovesFromStart() + EXTRA_MOVE_NEEDED;
            int estimatedMovesToGoal = estimateMinMovesNeeded(neighborSquare, goalSquare);
            neighborNodes.add(new SquareNode(neighborSquare, movesFromStart, estimatedMovesToGoal, currentNode));
        }
        return neighborNodes;
    }

    public int estimateMinMovesNeeded(Square sq1, Square sq2) {
        Set<Move> moves = piece.getMoves();
        int squaresDistance = Math.abs(sq1.getX() - sq2.getX()) + Math.abs(sq1.getY() - sq2.getY());
        assert squaresDistance >= 0;

        int minMovesNeeded = Integer.MAX_VALUE;
        for (Move move : moves) {
            int movesNeeded = squaresDistance / move.getDistance();
            if (squaresDistance % move.getDistance() > 0) {
                movesNeeded += EXTRA_MOVE_NEEDED;
            }
            if (minMovesNeeded > movesNeeded) {
                minMovesNeeded = movesNeeded;
            }
        }
        return minMovesNeeded;
    }

}