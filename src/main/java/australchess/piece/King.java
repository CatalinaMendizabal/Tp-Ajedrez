package australchess.piece;

import australchess.generator.KingMoveGenerator;

public class King extends Piece {

    boolean moved;

    public King(PieceColor color) {
        super(color, PieceType.KING);
        this.pieceId = 'K';
        movementGenerator = new KingMoveGenerator();
        moved = false;
    }

    public void setMoved(boolean moved) { this.moved = moved; }


}
