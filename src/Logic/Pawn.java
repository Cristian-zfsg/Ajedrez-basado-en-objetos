package Logic;
/**
 * En esta clase se describe la pieza del ajedrez del peon
 * <p>
 * El peon tiene la caracteristica de avanzar una casilla por movimiento
 * no puede retroceder, es usado en el movimiento especial (promotion)
 * solo captura en diagonal
 * </p>
 * */
public class Pawn extends Piece {
    /**
     * Constructor para Inicializar un peon
     * @param x Coordenada inicial en X (0-7)
     * @param y Coordenada inicial en y (0-7)
     * @param isWhite true para blancas, false para negras
     * */
    public Pawn(int x, int y, boolean isWhite) {
        super(x,y,isWhite,true);
    }

    public void Promotion() {

    }

    /**
     * Verifica que el movimiento dek=l peon sea valido segun las reglas del ajedrez
     * <p>
     *     Reglas Validadas:
     *    <ul>
     *        <li>puede hacer movimiento ortogonal </li>
     *        <li>Que exista un movimiento (No te puedes quedar donde estas)</li>
     *        <li>Que el camino del movimiento no se encuentre obstruido por piezas propias o contrarias</li>
     *        <li>No puedes capturar piezas amigas</li>
     *        <li>Puedes capturar unicamente en diagonal</li>
     *    </ul>
     * </p>
     * @param board Tablero actual donde evitaremos las colisiones
     * @param newX Coordenada destino en X
     * @param newY Coordenada destino en Y
     * @return true si es legal, false si no es asi
     * */
    @Override
    public boolean isValidMovement(int newX, int newY, Board board) {

        int color = -1;
        if (isWhite) color = 1;
        if(newX == x && newY == y )return false;

        Piece target = board.getPiece(newX, newY);

        if(newX == x && newY == y+color && board.getPiece(newX,newY) == null)return true;

        if (board.getPiece(newX, newY) != null && newY == (y + color) && Math.abs(newX-x) == 1 && isWhite ^ target.isWhite ){
            return true;
        }


        if(isFirstMove && newY == y + color*2  && board.isPathClear(x,y,newX,newY) && target == null && newX == x)return true;


        return false;
    }
}
