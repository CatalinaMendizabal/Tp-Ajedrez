package australchess.piece;

import australchess.cli.ChessGame;
import australchess.validator.CheckRule;
import australchess.validator.TargetBoardPosition;

import java.util.List;

public class King extends Piece {

    boolean moved;

    public King(PieceColor color) {
        super(color, PieceType.KING);
        this.pieceId = 'K';
        moved = false;
        this.validators = List.of(new TargetBoardPosition(), new CheckRule(ChessGame.checkDetector));

    }

    public void setMoved(boolean moved) { this.moved = moved; }


    @Override
    public boolean isValidMove(Move move) {
        int x = Math.abs(move.to.getNumber() - move.from.getNumber());
        int y = Math.abs(move.to.getLetter() - move.from.getLetter());

        if(x * y == 0) return false;
        if(y == 0 && Math.abs(x) > 1 && !moved) return true;

        return Math.abs(x) <= 1 && Math.abs(y) <= 1;
    }

}

