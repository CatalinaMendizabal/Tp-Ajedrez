package australchess.piece;

import australchess.cli.ChessGame;
import australchess.validator.CheckRule;
import australchess.validator.RookFreeRoute;
import australchess.validator.TargetBoardPosition;

import java.util.List;

public class Rook extends Piece{
    private boolean moved;

    public Rook(PieceColor color) {
        super(color, PieceType.ROOK);
        this.pieceId = 'R';
        if (color == PieceColor.BLACK) pieceId = Character.toLowerCase(pieceId);
        moved = false;
        this.validators = List.of(new RookFreeRoute(), new TargetBoardPosition(), new CheckRule(ChessGame.checkDetector));
    }

    public void setMoved(boolean moved) { this.moved = moved; }

    public boolean canCastle(){
        return !moved;
    }

    @Override
    public boolean isValidMove(Move move) {
        int offsetX = move.to.getNumber() - move.from.getNumber();
        int offsetY = move.to.getLetter() - move.from.getLetter();
        return (offsetX != 0 || offsetY == 0) && (offsetX == 0 || offsetY != 0);
    }
}
