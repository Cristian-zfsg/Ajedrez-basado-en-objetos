package Logic;
/**
 * Esta clase describe a la reina en un juego de ajedrez
 * <p>
 *  Es capaz de moverse como alfil o torre
 * </p>
 * @author CristianAMR
 * @version 1.0
 * */

public class Queen extends Piece {
    /**
     * Constructor para Inicializar una Reina
     * @param x Coordenada inicial en X (0-7)
     * @param y Coordenada inicial en y (0-7)
     * @param isWhite true para blancas, false para negras
     * */

    public Queen(int x, int y,boolean isWhite) {
        super(x, y, isWhite, true);
    }
    /**
     * Verifica que el movimiento de la Reina sea valido segun las reglas del ajedrez
     * <p>
     *     Reglas Validadas:
     *    <ul>
     *        <li>puede hacer movimiento ortogonal </li>
     *        <li>Que exista un movimiento (No te puedes quedar donde estas)</li>
     *        <li>Que el camino del movimiento no se encuentre obstruido por piezas propias o contrarias</li>
     *        <li>No puedes capturar piezas amigas</li>
     *        <li>Puedes moverte en diagonal</li>
     *    </ul>
     * </p>
     * @param board Tablero actual donde evitaremos las colisiones
     * @param newX Coordenada destino en X
     * @param newY Coordenada destino en Y
     * @return true si es legal, false si no es asi
     * */


    @Override
    public boolean isValidMovement(int newX, int newY, Board board) {
        int deltaX = Math.abs(newX - this.x);
        int deltaY = Math.abs(newY - this.y);

        if (newX == this.x && newY == this.y) {
            return false;
        }

        Piece target = board.getPiece(newX, newY);


        boolean isStraight = (deltaX == 0 || deltaY == 0); // Torre
        boolean isDiagonal = (deltaX == deltaY);

        if (!isStraight && !isDiagonal) {
            return false;
        }

        if (!board.isPathClear(x,y,newX,newY)) {
            return false;
        }

        if (target == null) {
            return true;
        }


        return (isWhite^target.isWhite());
    }
}
