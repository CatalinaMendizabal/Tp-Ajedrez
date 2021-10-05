package australchess.piece;

import australchess.cli.ChessGame;
import australchess.validator.CheckRule;
import australchess.validator.TargetBoardPosition;

import java.util.List;

public class Knight extends Piece {

    public Knight(PieceColor color) {

        super(color, PieceType.KNIGHT);
        this.pieceId = 'N';
        this.validators = List.of(new TargetBoardPosition(), new CheckRule(ChessGame.checkDetector));

    }

    @Override
    public boolean isValidMove(Move move) {
        int x = Math.abs(move.to.getNumber() - move.from.getNumber());
        int y = Math.abs(move.to.getLetter() - move.from.getLetter());
        return x * y == 2;
    }
}

