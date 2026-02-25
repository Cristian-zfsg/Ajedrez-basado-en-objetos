    package Logic;
    /**
     * Esta clase describe al alfil del juego de ajedrez
     * <p>
     *  El movimiento del alfil solo puede ser en diagonal, por lo que cualquier movimiento que no sea asi, sera considerado ilegal
     * </p>
     * @author CristianAMR
     * @version 1.0
     * */

    public class Bishop extends Piece {
        /**
         * Constructor para inicializar un alfil.
         * @param x, coordenada x inicial (0-7)
         * @param y, coordenada y inicial (0-7)
         * @param isWhite true si es blanca, falsa si es negra
         * */
        public Bishop(int x, int y, boolean isWhite){
            super(x,y,isWhite,true);
        }


        /**
         * Asegura el movimiento valido para el alfil en el juego de ajedrez.
         * <p>
         * Reglas verificadas:
         * <ul>
         * <li>No puede moverse a el mismo sitio (no puede quedarse quieto)</li>
         * <li>Solo puede capturar piezas enemigas</li>
         * <li>El movimiento geometrico es unicamente diagonal</li>
         * <li>Es incapaz de saltar entre piezas</li>
         * </ul>
         * </p>
         * @param newY Coordenada de destino en Y (0-7)
         * @param newX Coordenada de destino en X (0-7)
         * @param board Tablero actual para verificar posibles capturas
         * @return true si el movimiento cumple con las reglas false para caso contrario
         * */


        @Override
        public boolean isValidMovement(int newX, int newY, Board board) {
            if(newX == x && newY == y)return false ;
            int deltaX = Math.abs(newX - this.x);
            int deltaY = Math.abs(newY - this.y);

            if(deltaX - deltaY != 0)return false;

            if(!board.isPathClear(x,y,newX, newY)) return false;

            Piece target = board.getPiece(newX,newY);

            if(target == null) return true;

            return (isWhite^ target.isWhite);

        }
    }
