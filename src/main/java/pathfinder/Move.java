package pathfinder;

import pathfinder.exception.OutOfBoundException;

public class Move {
    private final int dx;
    private final int dy;
    private final int distance;

    public Move(int dx, int dy) {
        this.dx = dx;
        this.dy = dy;
        this.distance = Math.abs(dx) + Math.abs(dy);
    }

    public Square calculateDestination(Square currentSquare) {
        try {
            return Square.destination(currentSquare.getX() + dx, currentSquare.getY() + dy);
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new OutOfBoundException();
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Move move = (Move) o;
        return dx == move.dx && dy == move.dy && distance == move.distance;
    }

    @Override
    public int hashCode() {
        int result = dx;
        result = 31 * result + dy;
        result = 31 * result + distance;
        return result;
    }

    public int getDx() {
        return dx;
    }

    public int getDy() {
        return dy;
    }

    public int getDistance() {
        return distance;
    }
}

