package australchess.piece;

import australchess.cli.Board;
import australchess.validator.MovementValidator;
import lombok.Data;

import java.util.List;

@Data
public abstract class Piece implements MovingCriteria {

    PieceColor color;
    Character pieceId;
    PieceType pieceType;
    List<MovementValidator> validators;

    Piece (PieceColor color, PieceType pieceType){
        this.color = color;
        this.pieceType = pieceType;
    }

    public PieceColor getColor() {
        return color;
    }

    public PieceType getPieceType() {
        return pieceType;
    }

    public Character getPieceId() {
        return pieceId;
    }

    public boolean isValidMove(Move move, Board board){
        for (MovementValidator validator : validators) {
            if(!validator.validate(move, board)) return false;
        }
        return true;
    }
}
