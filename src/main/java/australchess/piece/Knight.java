package australchess.piece;

import australchess.cli.ChessGame;
import australchess.validator.CheckRule;
import australchess.validator.TargetBoardPosition;

import java.util.List;

public class Knight extends Piece {

    public Knight(PieceColor color) {
        super(color, PieceType.KNIGHT);
        this.pieceId = 'N';
        if (color == PieceColor.BLACK) pieceId = Character.toLowerCase(pieceId);
        this.validators = List.of(new TargetBoardPosition(), new CheckRule(ChessGame.checkDetector));
    }

    @Override
    public boolean isValidMove(Move move) {
        int offsetX = move.to.getNumber() - move.from.getNumber();
        int offsetY = move.to.getLetter() - move.from.getLetter();
        return Math.abs(offsetX * offsetY) != 2;

    }
}


