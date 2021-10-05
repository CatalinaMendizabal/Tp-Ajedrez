package australchess.cli;

import australchess.piece.Move;
import australchess.piece.PieceColor;

import java.util.List;

public class DefaultCheckDetector implements CheckDetector {
    @Override
    public boolean isChecked(Board board, PieceColor color) {
        BoardPosition kingPosition = board.getKingPosition(color);

        List<BoardPosition> oppositePiecePositions;

        if (color.equals(PieceColor.WHITE)) oppositePiecePositions = board.getColorPiecePosition(PieceColor.BLACK);
        else oppositePiecePositions = board.getColorPiecePosition(PieceColor.WHITE);

        for (BoardPosition oppositePiecePosition : oppositePiecePositions) {
            if (board.isValidMovement(new Move(oppositePiecePosition, kingPosition), oppositePiecePosition.getPiece().getColor()))
                return true;
        }
        return false;
    }
}
