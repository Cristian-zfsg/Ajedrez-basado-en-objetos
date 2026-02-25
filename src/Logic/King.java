package Logic;
/**
 * Esta clase representa al Rey en el juego de ajedrez
 * <p>
 * Este es capaz de moverse 1 sola casilla a la vez en cualquier direccion
 * Es participe del movimiento especial (castling)
 * </p>
 * @author CristianAMR
 * @version 1.0
 * */

public class King extends Piece {

    /**
     * Constructor para inicializar un Rey
     * @param isWhite true para blancas, false para negras
     * @param y posicion inicial en y dentro del tablero (0-7)
     * @param x posicion inicial en x dentro del tablero (0-7)
     * */

    public King(int x, int y, boolean isWhite) {
        super(x,y,isWhite,true);

    }
    /**
     * isValidMovement asegura que el movimiento sea valido acorde a las reglas de ajedrez.
     * Reglas verificadas:
     Reglas verificadas:
     * <ul>
     * <li>El movimiento implica un cambio de posición (no quedarse quieto).</li>
     * <li>El desplazamiento es de máximo 1 casilla de distancia en cualquier eje.</li>
     * <li>La casilla destino no está ocupada por una pieza del mismo color.</li>
     * </ul>
     * </p>
     * Note: La validación de "Jaque" (movimiento suicida) se gestionará a nivel de Tablero.
     *
     * @param newX Coordenada destino en X.
     * @param newY Coordenada destino en Y.
     * @param board Tablero actual para verificar colisiones.
     * @return true si el movimiento es geométricamente posible y legal (sin contar jaques).
     */

    @Override
    public boolean isValidMovement(int newX, int newY, Board board) {

        if(x == newX && y == newY)return false;
        if (Math.abs(newX - this.x) > 1 || Math.abs(newY - this.y) > 1 )return false;

        Piece target = board.getPiece(newX, newY);

        if(target == null)return true;

        return (this.isWhite ^ target.isWhite());


    }
}
