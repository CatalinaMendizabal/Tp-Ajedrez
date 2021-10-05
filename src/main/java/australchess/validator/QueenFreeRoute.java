package australchess.validator;

import australchess.cli.Board;
import australchess.piece.Move;

public class QueenFreeRoute implements FreeRoute {

    final private BishopFreeRoute bishopFreeRoute;
    final private RookFreeRoute rookFreeRoute;

    public QueenFreeRoute(BishopFreeRoute bishopFreeRoute, RookFreeRoute rookFreeRoute) {
        this.bishopFreeRoute = bishopFreeRoute;
        this.rookFreeRoute = rookFreeRoute;
    }

    @Override
    public boolean validate(Move move, Board board) {
        int x = move.getTo().getNumber() - move.getFrom().getNumber();
        int y = move.getTo().getLetter() - move.getFrom().getLetter();

        if (x == 0 || y == 0) {
            return rookFreeRoute.validate(move, board);
        } else return bishopFreeRoute.validate(move, board);
    }
}
