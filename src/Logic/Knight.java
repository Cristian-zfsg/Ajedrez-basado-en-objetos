package Logic;
/**
 *Esta clase describe la piez del caballo o Knight del juego ajedrez.
 * <p>
 * El caballo es la unica pieza capaz de saltar otras
 * Tiene el movimiento caracteristico de forma de L
 * </p>
 * @author CistianAMR
 * @version 1.0
 *
 * */

public class Knight extends Piece {
    /**
     * Constructor para inicializar un caballo.
     * @param x, coordenada x inicial (0-7)
     * @param y, coordenada y inicial (0-7)
     * @param isWhite true si es blanca, falsa si es negra
     * */

    public Knight(int x, int y, boolean isWhite) {
        super(x,y,isWhite,true);
    }
    /**
     * Asegura el movimiento valido para el caballo en el juego de ajedrez.
     * <p>
     * Reglas verificadas:
     * <ul>
     * <li>No puede moverse a el mismo sitio (no puede quedarse quieto)</li>
     * <li>Solo puede capturar piezas enemigas</li>
     * <li>El movimiento geometrico asemeja a una L mayuscula</li>
     * <li>Es capaz de saltar entre piezas</li>
     * </ul>
     * </p>
     * @param newY Coordenada de destino en Y (0-7)
     * @param newX Coordenada de destino en X (0-7)
     * @param board Tablero actual para verificar posibles capturas
     * @return true si el movimiento cumple con las reglas false para caso contrario
     * */


    @Override
    public boolean isValidMovement(int newX, int newY, Board board) {
        int deltaX = Math.abs(newX - x);
        int deltaY = Math.abs(newY - y);

        if (!((deltaX == 1 && deltaY == 2) || (deltaX == 2 && deltaY == 1))) {
            return false;
        }

        Piece target = board.getPiece(newX, newY);

        if(target == null){
            return true;
        }

        return (isWhite^target.isWhite());
    }
}
