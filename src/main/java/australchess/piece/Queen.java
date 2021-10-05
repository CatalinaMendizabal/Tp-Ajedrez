package australchess.piece;

import australchess.cli.ChessGame;
import australchess.validator.*;

import java.util.List;

public class Queen extends Piece {

    public Queen(PieceColor color) {
        super(color, PieceType.QUEEN);
        this.pieceId = 'Q';
        QueenFreeRoute queenFreeRoute = new QueenFreeRoute(new BishopFreeRoute(), new RookFreeRoute());
        this.validators = List.of(queenFreeRoute, new TargetBoardPosition(), new CheckRule(ChessGame.checkDetector));
    }

    @Override
    public boolean isValidMove(Move move) {
        int x = Math.abs(move.to.getNumber() - move.from.getNumber());
        int y = Math.abs(move.to.getLetter() - move.from.getLetter());
        if(x == 0 && y == 0) return false;
        return Math.abs(x) == Math.abs(y) || x == 0 || y == 0;
    }
}
