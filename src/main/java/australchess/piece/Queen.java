package australchess.piece;

import australchess.generator.QueenMoveGenerator;

public class Queen extends Piece {


    public Queen(PieceColor color) {
        super(color, PieceType.QUEEN);
        this.pieceId = 'Q';
        movementGenerator = new QueenMoveGenerator();
    }

}
