package pathfinder;

import pathfinder.extention.Piece;

import java.util.HashSet;
import java.util.Set;


public class Knight implements Piece {

    private final Set<Move> moves;

    public Knight() {
        this.moves = initializeKnightMoves();
    }

    @Override
    public Set<Move> getMoves() {
        return moves;
    }

    private Set<Move> initializeKnightMoves() {
        Set<Move> moves = new HashSet<>();

        moves.add(new Move(1, 2));
        moves.add(new Move(1, -2));
        moves.add(new Move(-1, 2));
        moves.add(new Move(-1, -2));
        moves.add(new Move(2, 1));
        moves.add(new Move(2, -1));
        moves.add(new Move(-2, 1));
        moves.add(new Move(-2, -1));

        return moves;
    }

}
