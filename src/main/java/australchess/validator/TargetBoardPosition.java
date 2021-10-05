package australchess.validator;

import australchess.cli.Board;
import australchess.piece.Move;
import australchess.piece.Piece;

public class TargetBoardPosition implements MovementValidator{
    @Override
    public boolean validate(Move movement, Board board) {
        Piece movingPiece = movement.getFrom().getPiece();
        Piece pieceOnTarget = movement.getTo().getPiece();
        if(pieceOnTarget == null) return true;
        return !pieceOnTarget.getColor().equals(movingPiece.getColor());
    }
}
