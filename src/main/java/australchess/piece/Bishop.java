package australchess.piece;

import australchess.cli.ChessGame;
import australchess.validator.BishopFreeRoute;
import australchess.validator.CheckRule;
import australchess.validator.TargetBoardPosition;

import java.util.List;

public class Bishop extends Piece {

    public Bishop(PieceColor color) {

        super(color, PieceType.BISHOP);
        this.pieceId = 'B';
        this.validators = List.of(new BishopFreeRoute(), new TargetBoardPosition(), new CheckRule(ChessGame.checkDetector));
    }

    @Override
    public boolean isValidMove(Move move) {
        int x = Math.abs(move.to.getNumber() - move.from.getNumber());
        int y = Math.abs(move.to.getLetter() - move.from.getLetter());

        if (x == 0 & y == 0) return false;
        return (Math.abs(x) == Math.abs(y));
    }
}
