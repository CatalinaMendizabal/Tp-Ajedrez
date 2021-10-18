package australchess.piece;

import australchess.cli.ChessGame;
import australchess.validator.CheckRule;
import australchess.validator.DiagonalFreeRoute;
import australchess.validator.TargetBoardPosition;

import java.util.List;

public class Bishop extends Piece {

    public Bishop(PieceColor color) {
        super(color, PieceType.BISHOP);
        this.pieceId = 'B';
        if (color == PieceColor.BLACK) pieceId = Character.toLowerCase(pieceId);
        this.validators = List.of(new DiagonalFreeRoute(), new TargetBoardPosition(), new CheckRule(ChessGame.checkDetector));
    }

    @Override
    public boolean isValidMove(Move move) {
        int offsetX = move.to.getNumber() - move.from.getNumber();
        int offsetY = move.to.getLetter() - move.from.getLetter();
        if(offsetX == 0 & offsetY == 0) return true;
        return (Math.abs(offsetX) != Math.abs(offsetY));
    }
}
