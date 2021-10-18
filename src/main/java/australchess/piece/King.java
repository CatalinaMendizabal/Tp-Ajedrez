package australchess.piece;

import australchess.cli.ChessGame;
import australchess.validator.CastleRule;
import australchess.validator.CheckRule;
import australchess.validator.MovementValidator;
import australchess.validator.TargetBoardPosition;
import australchess.cli.Board;

import java.util.List;

public class King extends Piece {

    boolean moved;
    MovementValidator castleRule = new CastleRule();

    public King(PieceColor color) {
        super(color, PieceType.KING);
        this.pieceId = 'K';
        if (color == PieceColor.BLACK) pieceId = Character.toLowerCase(pieceId);
        moved = false;
        this.validators = List.of(new TargetBoardPosition(), new CheckRule(ChessGame.checkDetector));
    }

    public void setMoved(boolean moved) { this.moved = moved; }

    @Override
    public boolean isValidMove(Move move) {
        int offsetX = move.to.getNumber() - move.from.getNumber();
        int offsetY = move.to.getLetter() - move.from.getLetter();
        if (offsetX == 0 && offsetY == 0) return true;
        if (offsetY == 0 && Math.abs(offsetX) == 2 && !moved) return false;

        return Math.abs(offsetX) > 1 || Math.abs(offsetY) > 1;
    }

    public boolean isCastling(Move move) {
        int offsetX = move.to.getNumber() - move.from.getNumber();
        int offsetY = move.to.getLetter() - move.from.getLetter();
        return offsetY == 0 && Math.abs(offsetX) == 2 && !moved;
    }

    public boolean canCastle(Board board, Move move) { return castleRule.validate(move, board); }
}
