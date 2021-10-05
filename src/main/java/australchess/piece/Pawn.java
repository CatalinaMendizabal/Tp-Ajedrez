package australchess.piece;


import australchess.cli.Board;
import australchess.cli.BoardPosition;
import australchess.cli.ChessGame;
import australchess.validator.CheckRule;
import australchess.validator.PawnFreeRoute;
import australchess.validator.TargetBoardPosition;

import java.util.List;

public class Pawn extends Piece {

    boolean moved;

    public Pawn(PieceColor color) {
        super(color, PieceType.PAWN);
        this.pieceId = 'P';
        moved = false;
        this.validators = List.of(new PawnFreeRoute(), new TargetBoardPosition(), new CheckRule(ChessGame.checkDetector));
    }

    public void setMoved(boolean moved) {
        this.moved = moved;
    }

    public boolean reachedBoardEnd(Board board, BoardPosition position) {
        if (color.equals(PieceColor.WHITE)) {
            return board.getPosition(position.getNumber(), (char) (position.getLetter() + 1)) == null;
        } else {
            return board.getPosition(position.getNumber(), (char) (position.getLetter() - 1)) == null;
        }
    }

    @Override
    public boolean isValidMove(Move move) {
        int x = Math.abs(move.to.getNumber() - move.from.getNumber());
        int y = Math.abs(move.to.getLetter() - move.from.getLetter());
        if (color.equals(PieceColor.WHITE)) {
            if (move.getTo().getPiece() != null) return Math.abs(x) == 1 && y == 1;
            return (x == 0 && y == 1) || (!moved && x == 0 && y == 2);
        } else {
            if (move.getTo().getPiece() != null) return Math.abs(x) == 1 && y == -1;
            return (x == 0 && y == -1) || (!moved && x == 0 && y == -2);
        }
    }
}
