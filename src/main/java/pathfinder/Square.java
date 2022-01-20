package pathfinder;

public class Square {
    static final int BOARD_WIDTH = 8;
    static final int BOARD_HEIGHT = 8;

    private final int x;
    private final int y;
    private final String squareName;
    private static final Square[][] board = new Square[BOARD_WIDTH][BOARD_HEIGHT];

    static Square initialization(String squareName) {
        int x = squareName.charAt(0) - 'A';
        int y = squareName.charAt(1) - '1';
        if (board[x][y] == null) {
            board[x][y] = new Square(squareName, x, y);
        }
        return board[x][y];
    }

    static Square destination(int x, int y) {
        if (board[x][y] == null) {
            board[x][y] = new Square(x, y);
        }
        return board[x][y];
    }

    private Square(String squareName, int x, int y) {
        this.squareName = squareName;
        this.x = x;
        this.y = y;
    }

    private Square(int x, int y) {
        this.x = x;
        this.y = y;
        char c1 = (char) (x + 'A');
        char c2 = (char) (y + '1');
        this.squareName = String.valueOf(new char[]{c1, c2});
    }

    @Override
    public String toString() {
        return squareName;
    }

    int getX() {
        return x;
    }

    int getY() {
        return y;
    }

    String getSquareName() {
        return squareName;
    }

}