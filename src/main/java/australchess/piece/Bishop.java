package australchess.piece;

public class Bishop extends Piece {

    public Bishop(PieceColor color) {

        super(color, PieceType.BISHOP);
        this.pieceId = 'B';
    }

    @Override
    public boolean isLegalMovement(Move move) {
        return false;
    }
}
