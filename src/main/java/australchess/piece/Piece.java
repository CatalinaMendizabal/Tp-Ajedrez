package australchess.piece;

import australchess.generator.MovementGenerator;

public abstract class Piece {

    PieceColor color;
    Character pieceId;
    PieceType pieceType;
    MovementGenerator movementGenerator;

    Piece (PieceColor color, PieceType pieceType){
        this.color = color;
        this.pieceType = pieceType;
    }

    public PieceColor getColor() {
        return color;
    }

    public Character getPieceId() {
        return pieceId;
    }

    public MovementGenerator getMovementGenerator() {
        return movementGenerator;
    }

}
