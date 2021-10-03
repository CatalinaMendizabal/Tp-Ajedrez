package australchess.piece;

import australchess.generator.BishopMoveGenerator;

public class Bishop extends Piece {

    public Bishop(PieceColor color) {

        super(color, PieceType.BISHOP);
        this.pieceId = 'B';
        movementGenerator = new BishopMoveGenerator();

    }
}
