package australchess.piece;

import australchess.cli.ChessGame;
import australchess.validator.*;

import java.util.List;

public class Queen extends Piece {

    public Queen(PieceColor color) {
        super(color, PieceType.QUEEN);
        this.pieceId = 'Q';
        if (color == PieceColor.BLACK) pieceId = Character.toLowerCase(pieceId);
        this.validators = List.of(new QueenFreeRoute(new StraightFreeRoute(), new DiagonalFreeRoute()), new TargetBoardPosition(), new CheckRule(ChessGame.checkDetector));
    }

    @Override
    public boolean isValidMove(Move move) {
        int offsetX = move.to.getNumber() - move.from.getNumber();
        int offsetY = move.to.getLetter() - move.from.getLetter();
        if(offsetX == 0 && offsetY == 0) return true;
        return Math.abs(offsetX) != Math.abs(offsetY) && offsetX != 0 && offsetY != 0;
    }
}
