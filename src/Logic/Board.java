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

        x+= (int) Math.signum(deltaX );
        y+= (int) Math.signum(deltaY );

    while (newX != x || newY != y) {
        if(getPiece(x, y) != null) {
            return false;
        }
        x+= (int) Math.signum(deltaX );
        y+= (int) Math.signum(deltaY );
    }
        return true;
    }
    /**
    * Logica para mover una pieza en el tablero
    * */

    public boolean movePiece(int x, int y, int newX, int newY){



        Piece pieza = getPiece(x,y);

        if (pieza == null)return false;

        if (pieza.isValidMovement(newX,newY,this)){

            setPiece(x,y,null);
            setPiece(newX,newY,pieza);

            pieza.setX(newX);
            pieza.setY(newY);

            pieza.setFirstMove(false);

            return  true;
        }

        return false;
    }



    public void ImprimirConsola(){

        for(int y = SIZE - 1; y >= 0; y--){

            System.out.print((y + 1) + " ");

            for(int x = 0; x < SIZE; x++){
                Piece aux = getPiece(x, y); // Coordenadas correctas (x, y)
                if(aux != null){
                    System.out.print(aux.getSimbolo() + " ");
                } else {
                    System.out.print(". ");
                }
            }
            System.out.print("\n");
        }

        System.out.println("  a b c d e f g h");
    }

    public void setAllPieces(){
        // ========== PEONES ==========
        for(int i = 0; i < SIZE; i++){
            // Peones blancos (fila 1)
            Pawn whitepawn = new Pawn(i, 1, true);
            whitepawn.setSymbol("♙");
            this.setPiece(i, 1, whitepawn);

            // Peones negros (fila 6)
            Pawn blackpawn = new Pawn(i, 6, false);
            blackpawn.setSymbol("♟");
            this.setPiece(i, 6, blackpawn);
        }

        // ========== TORRES ==========
        // Torres blancas
        Rook whiteRookLeft = new Rook(0, 0, true);
        whiteRookLeft.setSymbol("♖");
        this.setPiece(0, 0, whiteRookLeft);

        Rook whiteRookRight = new Rook(7, 0, true);
        whiteRookRight.setSymbol("♖");
        this.setPiece(7, 0, whiteRookRight);

        // Torres negras
        Rook blackRookLeft = new Rook(0, 7, false);
        blackRookLeft.setSymbol("♜");
        this.setPiece(0, 7, blackRookLeft);

        Rook blackRookRight = new Rook(7, 7, false);
        blackRookRight.setSymbol("♜");
        this.setPiece(7, 7, blackRookRight);

        // ========== CABALLOS ==========
        // Caballos blancos
        Knight whiteKnight1 = new Knight(1, 0, true);
        whiteKnight1.setSymbol("♘");
        this.setPiece(1, 0, whiteKnight1);

        Knight whiteKnight2 = new Knight(6, 0, true);
        whiteKnight2.setSymbol("♘");
        this.setPiece(6, 0, whiteKnight2);

        // Caballos negros
        Knight blackKnight1 = new Knight(1, 7, false);
        blackKnight1.setSymbol("♞");
        this.setPiece(1, 7, blackKnight1);

        Knight blackKnight2 = new Knight(6, 7, false);
        blackKnight2.setSymbol("♞");
        this.setPiece(6, 7, blackKnight2);

        // ========== ALFILES ==========
        // Alfiles blancos
        Bishop whiteBishop1 = new Bishop(2, 0, true);
        whiteBishop1.setSymbol("♗");
        this.setPiece(2, 0, whiteBishop1);

        Bishop whiteBishop2 = new Bishop(5, 0, true);
        whiteBishop2.setSymbol("♗");
        this.setPiece(5, 0, whiteBishop2);

        // Alfiles negros
        Bishop blackBishop1 = new Bishop(2, 7, false);
        blackBishop1.setSymbol("♝");
        this.setPiece(2, 7, blackBishop1);

        Bishop blackBishop2 = new Bishop(5, 7, false);
        blackBishop2.setSymbol("♝");
        this.setPiece(5, 7, blackBishop2);

        // ========== REINAS ==========
        // Reina blanca
        Queen whiteQueen = new Queen(3, 0, true);
        whiteQueen.setSymbol("♕");
        this.setPiece(3, 0, whiteQueen);

        // Reina negra
        Queen blackQueen = new Queen(3, 7, false);
        blackQueen.setSymbol("♛");
        this.setPiece(3, 7, blackQueen);

        // ========== REYES ==========
        // Rey blanco
        King whiteKing = new King(4, 0, true);
        whiteKing.setSymbol("♔");
        this.setPiece(4, 0, whiteKing);

        // Rey negro
        King blackKing = new King(4, 7, false);
        blackKing.setSymbol("♚");
        this.setPiece(4, 7, blackKing);
    }

    public void mostrarMovimientos(Piece piece){

        for(int y = SIZE - 1; y >= 0; y--){

            System.out.print((y + 1) + " ");

            for(int x = 0; x < SIZE; x++){
                Piece aux = getPiece(x, y); // Coordenadas correctas (x, y)
                if(aux != null){
                    System.out.print(aux.getSimbolo() + " ");
                } else if (piece.isValidMovement(x,y,this)) {
                    System.out.print("* ");
                } else {
                    System.out.print(". ");
                }
            }
            System.out.print("\n");
        }

        System.out.println("  a b c d e f g h");
    }

}
