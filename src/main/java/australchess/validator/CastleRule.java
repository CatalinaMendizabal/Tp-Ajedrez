package australchess.validator;

import australchess.cli.Board;
import australchess.cli.BoardPosition;
import australchess.piece.*;


public class CastleRule implements MovementValidator {

    MovementValidator straightFreeRoute = new StraightFreeRoute();

    @Override
    public boolean validate(Move move, Board board) {
        int dirX = move.getTo().getNumber() > move.getFrom().getNumber() ? 1 : -1;
        BoardPosition rookPosition = board.findCastlingRookPosition(move, dirX);
        if (rookPosition == null) return false;
        Rook rook = (Rook) rookPosition.getPiece();
        if (!rook.canCastle()) return false;
        return straightFreeRoute.validate(new Move(move.getFrom(), rookPosition), board);
    }
}
