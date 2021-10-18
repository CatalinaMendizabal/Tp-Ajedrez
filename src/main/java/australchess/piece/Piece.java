package australchess.piece;

import australchess.validator.MovementGenerator;
import australchess.validator.MovementValidator;

import java.util.List;

public abstract class Piece implements MovingCriteria {

    PieceColor color;
    Character pieceId;
    PieceType pieceType;
    List<MovementValidator> validators;
    MovementGenerator generator;

    public Piece(PieceColor color, PieceType pieceType) {
        this.color = color;
        this.pieceType = pieceType;
        this.generator = new MovementGenerator();
    }

    public PieceColor getColor() { return color; }

    public Character getPieceId() { return pieceId; }

    public PieceType getPieceType() { return pieceType; }

    public MovementGenerator getGenerator() { return generator; }

    public List<MovementValidator> getValidators() { return validators; }
}
