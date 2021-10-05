package australchess.piece;

import australchess.cli.ChessGame;
import australchess.validator.CheckRule;
import australchess.validator.RookFreeRoute;
import australchess.validator.TargetBoardPosition;

import java.util.List;

public class Rook extends Piece{

    boolean moved = false;

    public Rook(PieceColor color) {
        super(color, PieceType.ROOK);
        this.pieceId = 'R';
        this.validators = List.of(new RookFreeRoute(), new TargetBoardPosition(), new CheckRule(ChessGame.checkDetector));

    }

    public void setMoved(boolean moved) {
        this.moved = moved;
    }

    @Override
    public boolean isValidMove(Move move) {
        int x = Math.abs(move.to.getNumber() - move.from.getNumber());
        int y = Math.abs(move.to.getLetter() - move.from.getLetter());

        return (x == 0 && y != 0) || (x != 0 && y == 0);
    }
}
