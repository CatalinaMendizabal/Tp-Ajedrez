package australchess.piece;


import australchess.generator.PawnMoveGenerator;

public class Pawn extends Piece {

    boolean moved;

    public Pawn(PieceColor color) {
        super(color, PieceType.PAWN);
        this.pieceId = 'P';
        movementGenerator = new PawnMoveGenerator();
        moved = false;
    }

    public boolean isMoved() {
        return moved;
    }

    public void setMoved(boolean moved) {
        this.moved = moved;
    }

}
