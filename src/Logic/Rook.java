package Logic;
/**
 * Esta clase representa la clase Rook o torre del juego de ajedrez
 * <p>
 *  Es capaz de moverse N numero de casillas vacias siempre que sea horizontal o vertical dicho movimiento
 *  Es participe del movimiento especial Enroque (Castling)
 * </p>
 * @author CristianAMR
 * @version 1.0
 * */
public class Rook extends Piece {
    /**
     * Constructor para Inicializar una torre
     * @param x Coordenada inicial en X (0-7)
     * @param y Coordenada inicial en y (0-7)
     * @param isWhite true para blancas, false para negras
     * */
    public Rook(int x, int y, boolean isWhite) {
        super(x,y,isWhite,true);
    }

    /**
     * Verifica que el movimiento de la torre sea valido segun las reglas del ajedrez
     * <p>
     *     Reglas Validadas:
     *    <ul>
     *        <li>Movimiento ortogonal (solo horizontal o vertical)</li>
     *        <li>Que exista un movimiento (No te puedes quedar donde estas)</li>
     *        <li>Que el camino del movimiento no se encuentre obstruido por piezas propias o contrarias</li>
     *        <li>No puedes capturar piezas amigas</li>
     *    </ul>
     * </p>
     * @param board Tablero actual donde evitaremos las colisiones
     * @param newX Coordenada destino en X
     * @param newY Coordenada destino en Y
     * @return true si es legal, false si no es asi
     * */

    @Override
    public boolean isValidMovement(int newX, int newY, Board board) {
        ///Verificamos que exista un movimiento, no te quedas en el mismo lugar
        if(newX == this.x && newY == this.y){
            return false;
        }
        ////Solo sera valido un movimiento en vertical u horizontal
        boolean isOrthogonal = (newX == this.x || newY == this.y);
        if (!isOrthogonal) {
            return false; // No es un movimiento de Torre
        }
        ////siempre que no existan piezas en el camino pasaremos al siguiente paso
        if(!board.isPathClear(this.x, this.y, newX, newY)){
            return false;
        }

        Piece target = board.getPiece(newX, newY);
        ///si se han cumplido las anteriores y ademas no hay piezas en el destino podras moverte
        if(target == null){
            return true;
        }
        ////en caso de que existan piezas, solo sera un movimiento valido si comes una pieza de distinto color
        return (this.isWhite ^ target.isWhite());


    }
}
