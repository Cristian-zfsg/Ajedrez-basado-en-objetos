import Logic.Piece;
import Logic.Board;
import Logic.Board;
import Logic.Rook;

public class Main {
    public static void main(String[] args) {

        Board board = new Board();

        Rook torre = new Rook(0,0, true);

        board.setPiece(0,0,torre);

        System.out.println("Prueba de torre en 0,0");

        boolean test1 = torre.isValidMovement(0,5,board);
        System.out.println("Puede ir la torre a 0,5, esperado -> true obtenido: " + test1);
        boolean test2 = torre.isValidMovement(0,7,board);
        System.out.println("Puede ir la torre a 0,5, esperado -> true obtenido: " + test2);
        boolean test3 = torre.isValidMovement(5, 5, board);
        System.out.println("¿Puede ir a (5,5)? Esperado: false -> Resultado: " + test3);
        boolean test4 = torre.isValidMovement(0, 0, board);
        System.out.println("¿Puede ir a (0,0)? Esperado: false -> Resultado: " + test4);
    }
}