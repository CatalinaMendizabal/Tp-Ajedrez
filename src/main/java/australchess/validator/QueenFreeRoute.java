package australchess.validator;

import australchess.cli.Board;
import australchess.piece.Move;

public class QueenFreeRoute implements MovementValidator {
    final private MovementValidator straightMovement;
    final private MovementValidator diagonalMovement;

    public QueenFreeRoute(MovementValidator straightMovement, MovementValidator diagonalMovement) {
        this.straightMovement = straightMovement;
        this.diagonalMovement = diagonalMovement;
    }

    @Override
    public boolean validate(Move move, Board board) {
        return straightMovement.validate(move, board) || diagonalMovement.validate(move, board);
    }
}
