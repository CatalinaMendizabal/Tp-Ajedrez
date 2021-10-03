package australchess.piece;

public class Queen extends Piece {


    public Queen(PieceColor color) {
        super(color, PieceType.QUEEN);
        this.pieceId = 'Q';
    }

    @Override
    public boolean isLegalMovement(Move move) {
        return false;
    }
}
