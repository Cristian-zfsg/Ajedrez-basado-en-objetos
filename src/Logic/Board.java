package Logic;

public class Board {
    static final int SIZE = 8;
    private Piece[][] board = new Piece[SIZE][SIZE];

    public Board() {
        this.board = new Piece[SIZE][SIZE];
    }

    /**
     * Obtiene una pieza en una coordenada
     * */
    public Piece getPiece(int x, int y) {
        if (x >= 0 && x < SIZE && y >= 0 && y < SIZE) {
            return board[x][y];
        } else {
            return null;
        }
    }

    /**
     * Coloca una pieza en el tablero
     * */

    public void setPiece(int x, int y, Piece piece) {
        board[x][y] = piece;
        if (piece != null) {

            piece.setX(x);
            piece.setY(y);

        }
    }
    /**
     *
     *  */
    public boolean isPathClear(int x, int y, int newX, int newY) {

        int deltaX = newX - x;
        int deltaY = newY - y;
    while (newX != x || newY != y) {
        if(getPiece(x, y) != null) {
            return false;
        }
        x+= (int) Math.signum(deltaX );
        y+= (int) Math.signum(deltaY );
    }
        return true;
    }

}
