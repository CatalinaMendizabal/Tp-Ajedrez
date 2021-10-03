package australchess.piece;

import australchess.generator.KnightMoveGenerator;

public class Knight extends Piece {

    public Knight(PieceColor color) {

        super(color, PieceType.KNIGHT);
        this.pieceId = 'N';
        movementGenerator = new KnightMoveGenerator();

    }

}
