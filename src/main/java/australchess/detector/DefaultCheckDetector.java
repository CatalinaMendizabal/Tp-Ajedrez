package australchess.detector;

import australchess.cli.Board;
import australchess.cli.BoardPosition;
import australchess.piece.Move;
import australchess.piece.PieceColor;

import java.util.List;

public class DefaultCheckDetector implements CheckDetector {

    @Override
    public boolean isChecked(Board board, PieceColor color) {

        BoardPosition kingPosition = board.getKingPosition(color);
        List<BoardPosition> oppositeColorPositions;

        if (color.equals(PieceColor.WHITE)) oppositeColorPositions = board.getPiecePositions(PieceColor.BLACK);
        else oppositeColorPositions = board.getPiecePositions(PieceColor.WHITE);

        for (BoardPosition oppositePiecePosition : oppositeColorPositions) {
            if (board.validateMovement(new Move(oppositePiecePosition, kingPosition), oppositePiecePosition.getPiece().getColor()))
                return true;
        }
        return false;
    }

}
