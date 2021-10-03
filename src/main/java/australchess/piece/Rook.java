package australchess.piece;

import australchess.generator.RookMoveGenerator;

public class Rook extends Piece{

    boolean moved = false;

    public Rook(PieceColor color) {
        super(color, PieceType.ROOK);
        this.pieceId = 'R';
        movementGenerator = new RookMoveGenerator();
    }

    public void setMoved(boolean moved) {
        this.moved = moved;
    }

}
