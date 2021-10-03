package australchess.piece;


public class Pawn extends Piece {

    public Pawn(PieceColor color) {
        super(color, PieceType.PAWN);
        this.pieceId = 'P';
    }

    @Override
    public boolean isLegalMovement(Move move) {
        return false;
    }
}
