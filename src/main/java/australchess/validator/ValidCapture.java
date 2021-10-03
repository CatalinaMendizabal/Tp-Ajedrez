package australchess.validator;

import australchess.cli.Board;
import australchess.piece.Move;

public class ValidCapture implements MovementValidator {
    @Override
    public boolean validate(Move move, Board board) {
        if (move.getTo().getPiece() == null) return true;
        return (!move.getFrom().getPiece().getColor().equals(move.getTo().getPiece().getColor()));
    }

}
