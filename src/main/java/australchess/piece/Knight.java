package australchess.piece;

public class Knight extends Piece {

    public Knight(PieceColor color) {

        super(color, PieceType.KNIGHT);
        this.pieceId = 'N';
    }

    @Override
    public boolean isLegalMovement(Move move) {
        return false;
    }
}
