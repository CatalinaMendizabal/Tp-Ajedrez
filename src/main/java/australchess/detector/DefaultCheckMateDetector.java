package australchess.detector;

import australchess.cli.Board;
import australchess.cli.BoardPosition;
import australchess.piece.PieceColor;
import australchess.piece.PieceMovementValidator;

import java.util.List;

public class DefaultCheckMateDetector implements CheckMateDetector {

    @Override
    public boolean isCheckMated(Board board, PieceColor movingColor) {
        List<BoardPosition> piecePositions = board.getPiecePositions(movingColor);
        for (BoardPosition piecePosition : piecePositions) {
            PieceMovementValidator pieceValidator = new PieceMovementValidator(piecePosition.getPiece());
            if (pieceValidator.canMove(board, piecePosition)) {
                return false;
            }
        }
        return true;
    }
}
