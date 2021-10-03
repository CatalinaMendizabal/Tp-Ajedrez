package australchess.piece;

public class Rook extends Piece{

    public Rook(PieceColor color) {
        super(color, PieceType.ROOK);
        this.pieceId = 'R';
    }

    @Override
    public boolean isLegalMovement(Move move) {
        return false;
    }
}
