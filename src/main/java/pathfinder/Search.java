package pathfinder;

import pathfinder.extention.Piece;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

public class Search {
    private int movesAllowed;
    private final Queue<SquareNode> queue = new PriorityQueue<>(new NodeComparator());
    private final Map<Square, SquareNode> bestNodesQueued = new HashMap<>();
    private Calculate calculate;

    public Search(int movesAllowed, Piece piece) {
        this.movesAllowed = movesAllowed;
        calculate = new Calculate(piece);
    }


    ArrayList<Square> findPath(Square startSquare, Square goalSquare) {
        addStartNodeToQueue(startSquare, goalSquare);

        while (!queue.isEmpty()) {
            SquareNode currentBestNode = queue.remove();
            System.out.println("currentBestNode = " + currentBestNode);

            if (reachedGoal(goalSquare, currentBestNode)) {
                return currentBestNode.createPath();
            } else if (reachedMoveLimit(currentBestNode)) {
                return null;
            }

            Set<SquareNode> neighborNodes = calculate.determineNeighborNodes(currentBestNode, goalSquare);

            for (SquareNode neighborNode : neighborNodes) {
                addNodeToQueue(neighborNode);
            }
        }
        return null;
    }

    private void addStartNodeToQueue(Square startSquare, Square goalSquare) {
        int estimatedCostToTheGoal = calculate.estimateMinMovesNeeded(startSquare, goalSquare);
        SquareNode startNode = new SquareNode(startSquare, 0, estimatedCostToTheGoal, null);
        queue.add(startNode);
        bestNodesQueued.put(startSquare, startNode);
    }

    private boolean reachedGoal(Square goalSquare, SquareNode currentBestNode) {
        return currentBestNode.getSquare() == goalSquare && currentBestNode.getMovesFromStart() <= movesAllowed;
    }

    private boolean reachedMoveLimit(SquareNode currentBestNode) {
        return currentBestNode.getMovesFromStart() >= movesAllowed;
    }

    private void addNodeToQueue(SquareNode neighborNode) {
        SquareNode recordedNode = bestNodesQueued.get(neighborNode.getSquare());
        if (recordedNode == null || recordedNode.getMovesFromStart() > neighborNode.getMovesFromStart()) {
            queue.add(neighborNode);
            bestNodesQueued.put(neighborNode.getSquare(), neighborNode);
        }
    }
}
