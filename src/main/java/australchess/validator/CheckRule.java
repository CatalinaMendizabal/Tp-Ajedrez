package australchess.validator;

import australchess.cli.Board;
import australchess.detector.CheckDetector;
import australchess.piece.Move;
import australchess.piece.Piece;

public class CheckRule implements MovementValidator {
    private final CheckDetector checkDetector;

    public CheckRule(CheckDetector checkDetector) {
        this.checkDetector = checkDetector;
    }

    @Override
    public boolean validate(Move move, Board board) {
        Piece pieceToMove = move.getFrom().getPiece();
        Piece pieceOnTarget = move.getTo().getPiece();
        if(pieceOnTarget != null && pieceOnTarget.getPieceId().equals('K') && !pieceOnTarget.getColor().equals(pieceToMove.getColor())) return true;
        move.getFrom().setPiece(null);
        move.getTo().setPiece(pieceToMove);
        boolean isValid = !checkDetector.isChecked(board, pieceToMove.getColor());
        move.getFrom().setPiece(pieceToMove);
        move.getTo().setPiece(pieceOnTarget);
        return isValid;
    }

}
