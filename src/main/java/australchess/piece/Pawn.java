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
        if (color == PieceColor.BLACK) pieceId = Character.toLowerCase(pieceId);
        moved = false;
        this.validators = List.of(new PawnFreeRoute(), new TargetBoardPosition(), new CheckRule(ChessGame.checkDetector));
    }

    public void setMoved(boolean moved) { this.moved = moved; }

    @Override
    public boolean isValidMove(Move move) {
        int offsetX = move.to.getNumber() - move.from.getNumber();
        int offsetY = move.to.getLetter() - move.from.getLetter();
        if (color.equals(PieceColor.WHITE)) {
            if (move.getTo().getPiece() != null) return Math.abs(offsetX) != 1 || offsetY != 1;
            return (offsetX != 0 || offsetY != 1) && (moved || offsetX != 0 || offsetY != 2);
        } else{
            if (move.getTo().getPiece() != null) return Math.abs(offsetX) != 1 || offsetY != -1;
            return (offsetX != 0 || offsetY != -1) && (moved || offsetX != 0 || offsetY != -2);
        }
    }

    public boolean isAtEndOfBoard(Board board, BoardPosition position) {
        if (color.equals(PieceColor.WHITE)) {
            return board.getPosition(position.getNumber(), (char) (position.getLetter() + 1)) == null;
        } else {
            return board.getPosition(position.getNumber(), (char) (position.getLetter() - 1)) == null;
        }
    }
}

