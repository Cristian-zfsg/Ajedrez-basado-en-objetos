package Logic;
/**
 * Representa un pieza abstracta del juego de ajedrez
 * define propiedades comunes de posicion, color y movimiento
 * @author CristianAMR
 * @version 1.0
 * */
public abstract class Piece {
    //uso de variables protected para acceder solo en esta capa de logica
    //encapsulado para el exterior
    protected int x;
    protected int y;
    protected boolean isWhite;
    protected boolean isFirstMove;
    protected String simbolo;
    /**
     * Constructor principal de la pieza
     * @param x, coordenada x inicial (0-7)
     * @param y, coordenada y inicial (0-7)
     * @param isWhite true si es blanca, falsa si es negra
     * */

    public Piece(int x, int y, boolean isWhite, boolean isFirstMove) {
        this.x = x;
        this.y = y;
        this.isWhite = isWhite;
        this.isFirstMove = isFirstMove; //true por defecto
    }


    /**
     * Verificaremos si un movimiento es valido o no segun el tipo de pieza y logica del juego
     *
     * @param newX
     * @param newY
     * @param board
     * @return true si el movimiento es posible y legal
     * */

    public abstract boolean isValidMovement(int newX, int newY, Board board);

    public String toSymbol(){
        return this.simbolo;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public boolean isWhite() {
        return isWhite;
    }

    public void setWhite(boolean white) {
        isWhite = white;
    }

    public boolean isFirstMove() {
        return isFirstMove;
    }

    public void setFirstMove(boolean firstMove) {
        isFirstMove = firstMove;
    }

    public void setSymbol(String simbolo){ this.simbolo = simbolo;}

    public String getSimbolo(){return simbolo;}



    @Override
    public String toString(){
        return this.getClass().getSimpleName() + " " + "\n"+ this.x +  " " +  this.y;
    }
}
