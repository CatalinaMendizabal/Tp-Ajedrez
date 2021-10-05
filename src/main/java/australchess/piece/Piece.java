package australchess.piece;

import australchess.cli.Board;
import australchess.cli.BoardPosition;
import australchess.validator.KingMoveGenerator;
import australchess.validator.MovementGenerator;
import australchess.validator.MovementValidator;

import java.util.List;

public abstract class Piece implements MovingCriteria{

    PieceColor color;
    Character pieceId;
    PieceType pieceType;
    MovementGenerator movementGenerator;
    List<MovementValidator> validators;

    Piece (PieceColor color, PieceType pieceType){
        this.color = color;
        this.pieceType = pieceType;
        this.movementGenerator = new KingMoveGenerator();

    }

    public PieceColor getColor() {
        return color;
    }

    public Character getPieceId() {
        return pieceId;
    }

    public PieceType getPieceType() { return pieceType; }

    public boolean validateMove(Board board, Move movement){
        for (MovementValidator validator : validators) {
            if(!validator.validate(movement, board)) return false;
        }
        return true;
    }

    public boolean canMove(Board board, BoardPosition piecePosition) {
        return !movementGenerator.generateMove(board, piecePosition).isEmpty();
    }
}
