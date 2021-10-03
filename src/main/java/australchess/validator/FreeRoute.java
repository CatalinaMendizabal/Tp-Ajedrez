package australchess.validator;

import australchess.cli.Board;
import australchess.piece.Move;

public interface FreeRoute extends MovementValidator {
    boolean validate(Move move, Board board);
}
