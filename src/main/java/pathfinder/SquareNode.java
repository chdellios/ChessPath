package pathfinder;

import java.util.ArrayList;
import java.util.Objects;

public class SquareNode {

    final private Square square;
    final private int movesFromStart;
    final private int estimatedMoves;
    final private int totalMoves;
    final private SquareNode parent;

    public SquareNode(Square square, int movesFromStart, int estimatedMoves, SquareNode parent) {
        this.square = square;
        this.movesFromStart = movesFromStart;
        this.estimatedMoves = estimatedMoves;
        this.totalMoves = movesFromStart + estimatedMoves;
        this.parent = parent;
    }

    public ArrayList<Square> createPath() {
        if (parent != null) {
            ArrayList<Square> path = parent.createPath();
            path.add(this.square);
            return path;
        }
        ArrayList<Square> path = new ArrayList<>();
        path.add(this.square);
        return path;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SquareNode that = (SquareNode) o;
        return movesFromStart == that.movesFromStart && estimatedMoves == that.estimatedMoves && totalMoves == that.totalMoves && Objects.equals(square, that.square) && Objects.equals(parent, that.parent);
    }

    @Override
    public int hashCode() {
        return Objects.hash(square);
    }

    public Square getSquare() {
        return square;
    }

    public int getMovesFromStart() {
        return movesFromStart;
    }

    public int getEstimatedMovesToTheGoal() {
        return estimatedMoves;
    }

    public int getTotalMovesFromStartToGoal() {
        return totalMoves;
    }

    public SquareNode getParent() {
        return parent;
    }

    @Override
    public String toString() {
        return "SquareNode{" +
                "square=" + square +
                ", movesFromStart=" + movesFromStart +
                ", estimatedMoves=" + estimatedMoves +
                ", totalMoves=" + totalMoves +
                ", parent=" + parent +
                '}';
    }
}
