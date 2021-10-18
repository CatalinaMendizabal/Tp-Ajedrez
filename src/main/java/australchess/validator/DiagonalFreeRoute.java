package australchess.validator;

import australchess.cli.Board;
import australchess.cli.BoardPosition;
import australchess.piece.Move;

public class DiagonalFreeRoute implements MovementValidator {
    @Override
    public boolean validate(Move move, Board board) {

        int offsetX = move.getTo().getNumber() - move.getFrom().getNumber();
        int offsetY = move.getTo().getLetter() - move.getFrom().getLetter();
        if (Math.abs(offsetX) != Math.abs(offsetY)) return false;

        int srcX = move.getFrom().getNumber();
        int srcY = move.getFrom().getLetter();
        int destX = move.getTo().getNumber();
        int destY = move.getTo().getLetter();

        int dirX = destX > srcX ? 1 : -1;
        int dirY = destY > srcY ? 1 : -1;

        for (int i = 1; i < Math.abs(destX - srcX); ++i) {
            BoardPosition position = board.getPosition(srcX + i * dirX, (char) (srcY + i * dirY));
            if (position != null)
                if (position.getPiece() != null) return false;
        }
        return true;
    }
}
